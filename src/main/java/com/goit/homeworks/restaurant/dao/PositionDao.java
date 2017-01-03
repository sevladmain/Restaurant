package com.goit.homeworks.restaurant.dao;

import com.goit.homeworks.restaurant.model.Position;

/**
 * Created by SeVlad on 26.10.2016.
 */
public interface PositionDao extends SimpleDao<Position> {
    Position findPositionById(int id);
}
