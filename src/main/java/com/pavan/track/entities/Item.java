package com.pavan.track.entities;

import com.pavan.track.entities.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item extends BaseEntity {

    private static final long serialVersionUID = 824552183452141495L;

    @Column(name = "item_name", length = 50, nullable = false)
    private String name;

    @Column(name = "cost", nullable = false)
    private float cost;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_type", nullable = false)
    private String unitType;

    @Column(name = "unit", nullable = false, length = 15)
    private String unit;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", categoryName=" + category.getCategoryName() +
                '}';
    }
}
