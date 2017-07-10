package com.baidu.onetomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell on 2017/7/2.
 */
@Entity
@Table(name="orders")
public class Order {
    private String id;
    private Float sunPrice;
    private Set<OrderItem> items = new HashSet<>();
    public Order(Float sunPrice) {
        this.sunPrice = sunPrice;
    }

    public Order() {
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order",fetch = FetchType.LAZY)
    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(length = 10,nullable = false)
    public Float getSunPrice() {
        return sunPrice;
    }

    public void setSunPrice(Float sunPrice) {
        this.sunPrice = sunPrice;
    }
    public void addOrderItem(OrderItem item) {
        item.setOrder(this);
        items.add(item);
    }
}
