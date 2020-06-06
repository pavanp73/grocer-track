package com.pavan.track.models.dto;

import com.pavan.track.annotations.CheckStoreName;
import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.models.BaseModel;

import javax.validation.constraints.Positive;

public class PurchaseRequestDto extends BaseModel {

    private static final long serialVersionUID = -4140634808210307088L;

    @NotNullOrBlank(message = "Purchase date cannot be blank")
    private String purchaseDate;

    @Positive(message = "Weight cannot be negative or 0")
    private double weight;

    @NotNullOrBlank(message = "Units cannot be blank")
    private String units;

    @Positive(message = "Price cannot be negative or 0")
    private float price;

    @NotNullOrBlank(message = "Item name cannot be blank")
    private String itemName;

    @CheckStoreName(message = "Store name must be one of the following: BigBasket/Dunzo/FTH/StoreSe")
    private String storeName;

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "PurchaseRequestDto{" +
                "purchaseDate='" + purchaseDate + '\'' +
                ", weight=" + weight +
                ", units='" + units + '\'' +
                ", price=" + price +
                ", itemName='" + itemName + '\'' +
                ", storeName='" + storeName + '\'' +
                "} " + super.toString();
    }
}
