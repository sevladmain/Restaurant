package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.IngredientDao;
import com.goit.homeworks.restaurant.model.Ingredient;

import java.util.List;

/**
 * Created by SeVlad on 19.11.2016.
 */
public class IngredientService {
    IngredientDao ingredientDao;

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public Ingredient getIngredientById(int id){
        return ingredientDao.findIngredientById(id);
    }

    public List<Ingredient> findIngredientByName(String name){
        return ingredientDao.findIngredientByName(name);
    }

    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientDao.create(ingredient);
    }

    public int updateIngredient(Ingredient ingredient){
        return ingredientDao.update(ingredient);
    }

    public int deleteIngredient(Ingredient ingredient){
        return ingredientDao.remove(ingredient);
    }

    public List<Ingredient> getAllIngredients(){
        return ingredientDao.getAll();
    }

    public List<Ingredient> getAllEndIngredients(int minAmount){
        return ingredientDao.getAllEndIngredients(minAmount);
    }
}
