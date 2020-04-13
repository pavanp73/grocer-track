package com.pavan.track.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pavan.track.entities.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item extends BaseEntity {

    private static final long serialVersionUID = 824552183452141495L;

    @Column(name = "item_name", length = 50, nullable = false, unique = true)
    private String itemName;

    @Column(name = "unit_type", nullable = false)
    private String unitType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", unitType='" + unitType + '\'' +
                ", categoryName=" + category.getCategoryName() +
                '}';
    }
}
