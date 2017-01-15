package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.IngredientDao;
import com.goit.homeworks.restaurant.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by SeVlad on 28.11.2016.
 */
@Component
public class IdToIngredientConverter implements Converter<Object, Ingredient> {
    @Autowired
    IngredientDao ingredientDao;

    @Override
    public Ingredient convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        return ingredientDao.findIngredientById(id);
    }
}
