package com.pavan.track.models.dto;

import com.pavan.track.annotations.CheckUnitType;
import com.pavan.track.annotations.NotNullOrBlank;
import com.pavan.track.models.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ItemDto extends BaseModel {

    private static final long serialVersionUID = -7787555242287139258L;

    @ApiModelProperty(value = "Item name")
    @NotNullOrBlank(message = "Item name cannot be blank")
    private String itemName;

    @ApiModelProperty(value = "Unit type of an item")
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
                "itemName='" + itemName + '\'' +
                ", unitType='" + unitType + '\'' +
                '}';
    }
}
