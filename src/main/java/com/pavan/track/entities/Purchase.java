package com.pavan.track.entities;

import com.pavan.track.entities.base.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PURCHASE")
public class Purchase extends BaseEntity {

    private static final long serialVersionUID = -4089453266663667758L;

    @Type(type = "org.hibernate.type.LocalDateType")
    @Column(name = "purchase_date", nullable = false)
    private LocalDate purchaseDate;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "units", nullable = false)
    private String units;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "store_name")
    private String storeName;

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseDate=" + purchaseDate +
                ", weight=" + weight +
                ", units='" + units + '\'' +
                ", price=" + price +
                ", itemName=" + item.getItemName() +
                ", storeName='" + storeName + '\'' +
                "} " + super.toString();
    }
}
