package com.goit.homeworks.restaurant.dao;

import com.goit.homeworks.restaurant.model.Dish;

import java.util.List;

/**
 * Created by SeVlad on 24.10.2016.
 */
public interface DishDao extends SimpleDao<Dish> {
    List<Dish> findDishByName(String name);
    Dish findDishById(int id);
}
