package com.pavan.track.models.dto;

import com.pavan.track.models.BaseModel;

public class OrderResponseDto extends BaseModel {

    private static final long serialVersionUID = 3885595972892440407L;

    private String orderDate;

    private String itemName;

    private String categoryName;

    private double price;

    private String weight;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{" +
                super.getId() +
                "orderDate='" + orderDate + '\'' +
                ", itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", cost=" + price +
                ", weight='" + weight + '\'' +
                "} " + super.toString();
    }
}
