package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.DishDao;
import com.goit.homeworks.restaurant.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by SeVlad on 27.11.2016.
 */
@Component
public class IdToDishConverter implements Converter<Object, Dish> {
    @Autowired
    DishDao dishDao;

    @Override
    public Dish convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        return dishDao.findDishById(id);
    }
}
