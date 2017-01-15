package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.CategoryDao;
import com.goit.homeworks.restaurant.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by SeVlad on 24.11.2016.
 */
@Component
public class IdToCategoryConverter implements Converter<Object, Category> {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        return categoryDao.findCategoryById(id);
    }
}
