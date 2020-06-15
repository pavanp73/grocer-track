package com.pavan.track.models.dto;

import com.pavan.track.models.BaseModel;

public class PurchaseResponseDto extends BaseModel {

    private static final long serialVersionUID = 3885595972892440407L;

    private String purchaseDate;

    private String itemName;

    private String categoryName;

    private double price;

    private String weight;

    private String storeName;

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "PurchaseResponseDto{" +
                super.getId() +
                "purchaseDate='" + purchaseDate + '\'' +
                ", itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", cost=" + price +
                ", weight='" + weight + '\'' +
                ", storeName='" + storeName + '\'' +
                "} " + super.toString();
    }
}
