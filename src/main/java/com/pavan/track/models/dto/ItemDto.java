package com.pavan.track.models.dto;

import com.pavan.track.annotations.CheckUnitType;
import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.models.BaseModel;

public class ItemDto extends BaseModel {

    private static final long serialVersionUID = -7787555242287139258L;

    @NotNullOrBlank(message = "Item name cannot be blank")
    private String itemName;

    @CheckUnitType(message = "Invalid unit type. It must be Kilogram/Litre")
    private String unitType;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                super.toString() +
                "itemName='" + itemName + '\'' +
                ", unitType='" + unitType + '\'' +
                '}';
    }
}
