package com.goit.homeworks.restaurant.dao;

import com.goit.homeworks.restaurant.model.Ingredient;

import java.util.List;

/**
 * Created by SeVlad on 24.10.2016.
 */
public interface IngredientDao extends SimpleDao<Ingredient> {
    List<Ingredient> findIngredientByName(String name);
    List<Ingredient> getAllEndIngredients(int minAmount);
    Ingredient findIngredientById(int id);
}
