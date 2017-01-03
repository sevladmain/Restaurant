package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.OrderDao;
import com.goit.homeworks.restaurant.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by SeVlad on 01.12.2016.
 */
@Component
public class IdToOrderConverter implements Converter<Object, Order> {
    @Autowired
    OrderDao orderDao;

    @Override
    public Order convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        return orderDao.findOrderById(id);
    }
}
