package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.DishDao;
import com.goit.homeworks.restaurant.dao.MenuDao;

import com.goit.homeworks.restaurant.model.Dish;
import com.goit.homeworks.restaurant.model.Menu;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SeVlad on 12.11.2016.
 */
public class MenuService {
    private MenuDao menuDao;
    private DishDao dishDao;

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Transactional
    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();
        menus = menuDao.getAll();
        return menus;
    }

    @Transactional
    public List<Dish> getDishesFromMenu(int id) {
        return menuDao.findMenuById(id).getDishes();
    }

    @Transactional
    public List<Menu> findMenuByName(String name) {
        return menuDao.findMenuByName(name);
    }

    @Transactional
    public Menu getMenuById(int id) {
        return menuDao.findMenuById(id);
    }

    @Transactional
    public int deleteMenu(Menu menu) {
            return menuDao.remove(menu);
    }

    @Transactional
    public Menu addMenu(Menu menu) {
        return menuDao.create(menu);
    }

    @Transactional
    public int updateMenu(Menu menu) {
        return menuDao.update(menu);
    }

    @Transactional
    public int addDishToMenu(int dishId, int menuId) {
        Menu menu = menuDao.findMenuById(menuId);
        Dish dish = dishDao.findDishById(dishId);
        menu.getDishes().add(dish);
        menuDao.update(menu);
        return 1;
    }

    @Transactional
    public int removeDishFromMenu(int dishId, int menuId) {
        Menu menu = menuDao.findMenuById(menuId);
        Dish dish = dishDao.findDishById(dishId);
        menu.getDishes().remove(dish);
        menuDao.update(menu);
        return 1;
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.getAll();
    }

    @Transactional
    public List<Dish> getNewDishes(int id) {
        List<Dish> newDishes = getAllDishes();
        List<Dish> exDishes = getDishesFromMenu(id);
        newDishes.removeAll(exDishes);
        return newDishes;
    }
}
