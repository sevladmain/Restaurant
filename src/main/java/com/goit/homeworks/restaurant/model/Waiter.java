package com.goit.homeworks.restaurant.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SeVlad on 05.12.2016.
 */
@Entity
public class Waiter extends Employee {

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_emp")
    List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "orders=" + orders +
                '}';
    }
}
