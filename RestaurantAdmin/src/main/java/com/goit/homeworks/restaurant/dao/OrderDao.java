package com.goit.homeworks.restaurant.dao;

import com.goit.homeworks.restaurant.model.Order;

import java.util.List;

/**
 * Created by SeVlad on 24.10.2016.
 */
public interface OrderDao extends SimpleDao<Order> {
    List<Order> getAllOpenOrders();
    List<Order> getAllClosedOrders();
    Order findOrderById(int id);
}
