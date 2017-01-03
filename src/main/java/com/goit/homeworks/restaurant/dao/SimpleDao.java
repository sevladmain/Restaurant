package com.goit.homeworks.restaurant.dao;

import java.util.List;

/**
 * Created by SeVlad on 24.10.2016.
 */
public interface SimpleDao <T> {
    T create(T item);
    int remove(T item);
    int update(T item);
    List<T> getAll();
}
