package com.pavan.track.controllers.implementations;

import com.pavan.track.controllers.interfaces.ChartController;
import com.pavan.track.entities.Purchase;
import com.pavan.track.models.dto.CategoryWiseCost;
import com.pavan.track.models.dto.DoughnutChartDto;
import com.pavan.track.repositories.PurchaseRepository;
import com.pavan.track.services.utils.MathUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Validated
public class ChartControllerImpl implements ChartController {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public ChartControllerImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public DoughnutChartDto getDataForDoughnutChart(String month) {

        LocalDate start = LocalDate.of(2020, Month.valueOf((month.toUpperCase())), 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
        System.out.println(start.toString() + " " + end.toString());
        List<Purchase> purchases = purchaseRepository.findAllByPurchaseDateBetween(start, end);

        List<CategoryWiseCost> categoryWiseCostList = purchases.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getItem().getCategory().getCategoryName()
                ))
                .entrySet().stream()
                .map(x -> {
                    double sum = x.getValue().stream().mapToDouble(value -> MathUtility.twoDecimalRoundOff(value.getPrice())).sum();
                    CategoryWiseCost categoryWiseCost = new CategoryWiseCost();
                    categoryWiseCost.setCategoryName(x.getKey());
                    categoryWiseCost.setCategoryWiseTotalCost(sum);
                    return categoryWiseCost;
                }).collect(Collectors.toList());

        DoughnutChartDto doughnutChartDto = new DoughnutChartDto();
        doughnutChartDto.setCategoryWiseCostList(categoryWiseCostList);
        doughnutChartDto.setTotalCost(
                categoryWiseCostList.stream()
                        .mapToDouble(CategoryWiseCost::getCategoryWiseTotalCost).sum());
        return doughnutChartDto;
    }
}
