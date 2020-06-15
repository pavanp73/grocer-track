package com.pavan.track.models.dto;

import java.io.Serializable;
import java.util.List;

public class DoughnutChartDto implements Serializable {

    private static final long serialVersionUID = -4629464962189622228L;

    private double totalCost;

    private List<CategoryWiseCost> categoryWiseCostList;

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public List<CategoryWiseCost> getCategoryWiseCostList() {
        return categoryWiseCostList;
    }

    public void setCategoryWiseCostList(List<CategoryWiseCost> categoryWiseCostList) {
        this.categoryWiseCostList = categoryWiseCostList;
    }

    @Override
    public String toString() {
        return "DoughnutChartDto{" +
                "totalCost=" + totalCost +
                ", categoryWiseCostList=" + categoryWiseCostList +
                '}';
    }
}
