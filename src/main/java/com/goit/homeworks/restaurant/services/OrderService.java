package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.*;
import com.goit.homeworks.restaurant.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 13.11.2016.
 */
public class OrderService {
    OrderDao orderDao;
    EmployeeDao employeeDao;
    PreparedDishDao preparedDishDao;
    DishDao dishDao;
    IngredientDao ingredientDao;

    public void setIngredientDao(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setPreparedDishDao(PreparedDishDao preparedDishDao) {
        this.preparedDishDao = preparedDishDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Transactional
    public List<Order> getAllOpenOrders() {
        return orderDao.getAllOpenOrders();
    }

    @Transactional
    public List<Order> getAllClosedOrders() {
        return orderDao.getAllClosedOrders();
    }

    @Transactional
    public Order getOrderById(int id) {
        return orderDao.findOrderById(id);
    }

    @Transactional
    public int deleteOrder(Order order) {
        return orderDao.remove(order);
    }

    @Transactional
    public Order addOrder(Order order) {
        return orderDao.create(order);
    }

    @Transactional
    public int updateOrder(Order order) {
        return orderDao.update(order);
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDao.getAll();
    }

    @Transactional
    public Employee getEmployee(int id) {
        return employeeDao.findEmployeeById(id);
    }

    @Transactional
    public PreparedDish addPreparedDish(PreparedDish dish) {
        return preparedDishDao.create(dish);
    }

    @Transactional
    public int updatePreparedDish(PreparedDish dish) {
        return preparedDishDao.update(dish);
    }

    @Transactional
    public int removePreparedDish(PreparedDish dish) {
        return preparedDishDao.remove(dish);
    }

    @Transactional
    public int setPreparedToDish(PreparedDish dish) {
        dish.setPrepared(true);
        return preparedDishDao.update(dish);
    }

    @Transactional
    public int closeOrder(Order order) {
        order.setOpen(false);
        return orderDao.update(order);
    }

    @Transactional
    public List<PreparedDish> getDishesFromOrder(int orderId) {
        List<PreparedDish> preparedDishes = preparedDishDao.getAllDishFromOrder(orderId);
        return preparedDishes;
    }

    @Transactional
    public List<Dish> getAllDishes() {
        return dishDao.getAll();
    }

    @Transactional
    public List<Dish> getAllDishesToPrepare() {
        List<Dish> all = dishDao.getAll();
        all.removeIf(dish -> !dish.isEnoughtIngredient());
        return all;
    }

    @Transactional
    public PreparedDish getPreparedDishById(int id) {
        return preparedDishDao.findPreparedDishById(id);
    }

    @Transactional
    public Dish getDishById(int id) {
        return dishDao.findDishById(id);
    }

    @Transactional
    public int getUsedAmountOfDishIngredient(int ingredientId, int dishId) {
        Dish dish = dishDao.findDishById(dishId);
        int amount = 0;
        for (IngredientList ingredient :
                dish.getIngredients()) {
            if (ingredient.getIngredient().getId() == ingredientId) {
                amount = ingredient.getAmount();
            }
        }
        return amount;
    }

    @Transactional
    public void reduceIngredientsAmountFromPreparedDish(int preparedDishId) {
        PreparedDish preparedDish = preparedDishDao.findPreparedDishById(preparedDishId);
        Dish dish = preparedDish.getDish();
        for (IngredientList ingredient :
                dish.getIngredients()) {
            int amount = ingredient.getAmount();
            ingredient.getIngredient().decAmount(amount);
        }
        dishDao.update(dish);
    }

    public List<Order> getAllOrders() {
        return orderDao.getAll();
    }
}