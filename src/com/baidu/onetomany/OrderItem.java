package com.baidu.onetomany;

import javax.persistence.*;

/**
 * Created by dell on 2017/7/2.
 */
@Entity
public class OrderItem {
    private Integer id;
    private String name;
    private Float price;
    private Order order;

    public OrderItem(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public OrderItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(length = 32,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(length = 10,nullable = false)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE},optional = false)
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
