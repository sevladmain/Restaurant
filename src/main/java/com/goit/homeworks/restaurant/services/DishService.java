package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.CategoryDao;
import com.goit.homeworks.restaurant.dao.DishDao;
import com.goit.homeworks.restaurant.model.Category;
import com.goit.homeworks.restaurant.model.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SeVlad on 10.11.2016.
 */
public class DishService {
    private DishDao dishDao;
    private CategoryDao categoryDao;

    public DishDao getDishDao() {
        return dishDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.getAll();
    }

    @Transactional
    public List<Dish> findDishByName(String name) {
        return dishDao.findDishByName(name);
    }

    @Transactional
    public Dish getDishById(int id) {
        return dishDao.findDishById(id);
    }

    @Transactional
    public int deleteDish(Dish dish) {
        return dishDao.remove(dish);
    }

    @Transactional
    public Dish addDish(Dish dish) {
        return dishDao.create(dish);
    }

    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }

    @Transactional
    public int updateDish(Dish dish) {
        return dishDao.update(dish);
    }
}
