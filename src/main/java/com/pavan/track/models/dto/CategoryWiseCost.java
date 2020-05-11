package com.pavan.track.models.dto;

import java.io.Serializable;

public class CategoryWiseCost implements Serializable {

    private static final long serialVersionUID = 1226917859412665594L;

    private String categoryName;

    private double categoryWiseTotalCost;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getCategoryWiseTotalCost() {
        return categoryWiseTotalCost;
    }

    public void setCategoryWiseTotalCost(double categoryWiseTotalCost) {
        this.categoryWiseTotalCost = categoryWiseTotalCost;
    }

    @Override
    public String toString() {
        return "CategoryWiseCost{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryWiseTotalCost=" + categoryWiseTotalCost +
                '}';
    }
}
