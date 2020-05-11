package com.pavan.track.controllers.implementations;

import com.pavan.track.controllers.interfaces.ChartController;
import com.pavan.track.entities.Order;
import com.pavan.track.models.dto.CategoryWiseCost;
import com.pavan.track.models.dto.DoughnutChartDto;
import com.pavan.track.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Validated
public class ChartControllerImpl implements ChartController {

    private final OrderRepository orderRepository;

    @Autowired
    public ChartControllerImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public DoughnutChartDto getDataForDoughnutChart(String month) {

        DecimalFormat df = new DecimalFormat("#.00");
        LocalDate start = LocalDate.of(2020, Month.valueOf((month.toUpperCase())), 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
        System.out.println(start.toString() + " " + end.toString());
        List<Order> orders = orderRepository.findAllByOrderDateBetween(start, end);

        List<CategoryWiseCost> categoryWiseCostList = orders.stream()
                .collect(Collectors.groupingBy(
                        o -> o.getItem().getCategory().getCategoryName()
                ))
                .entrySet().stream()
                .map(x -> {
                    double sum = x.getValue().stream().mapToDouble(Order::getPrice).sum();
                    CategoryWiseCost categoryWiseCost = new CategoryWiseCost();
                    categoryWiseCost.setCategoryName(x.getKey());
                    categoryWiseCost.setCategoryWiseTotalCost(Double.parseDouble(df.format(sum)));
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
