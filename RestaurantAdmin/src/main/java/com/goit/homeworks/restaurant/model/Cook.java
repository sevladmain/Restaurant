package com.goit.homeworks.restaurant.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SeVlad on 06.12.2016.
 */
@Entity
public class Cook extends Employee {
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_employee")
    List<PreparedDish> preparedDishList = new ArrayList<>();

    public List<PreparedDish> getPreparedDishList() {
        return preparedDishList;
    }

    public void setPreparedDishList(List<PreparedDish> preparedDishList) {
        this.preparedDishList = preparedDishList;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "preparedDishList=" + preparedDishList +
                "} " + super.toString();
    }
}
