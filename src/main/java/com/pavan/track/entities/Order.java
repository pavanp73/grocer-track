package com.pavan.track.entities;

import com.pavan.track.entities.base.BaseEntity;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ORDER")
public class Order extends BaseEntity {

    private static final long serialVersionUID = -4089453266663667758L;

    @Type(type = "org.hibernate.type.LocalDateType")
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "units", nullable = false)
    private String units;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "store_name")
    private String storeName;

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
        return "Order{" +
                "orderDate=" + orderDate +
                ", weight=" + weight +
                ", units='" + units + '\'' +
                ", price=" + price +
                ", itemName=" + item.getItemName() +
                ", storeName='" + storeName + '\'' +
                "} " + super.toString();
    }
}
