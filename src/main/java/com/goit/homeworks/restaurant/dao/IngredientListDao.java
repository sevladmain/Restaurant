package com.goit.homeworks.restaurant.dao;

import java.util.List;

/**
 * Created by SeVlad on 31.10.2016.
 */
public interface IngredientListDao {
    int addIngredientToDish(int ingredientId, int dishId, int amount);
    int removeIngredientFromDish(int ingredientId, int dishId);
    boolean isIngredientFromDish(int ingredientId, int dishId);
    List<Integer> getAllIngredientsIds(int dishId);
    int getUsedAmountOfDishIngredient(int ingredientId, int dishId);
}
