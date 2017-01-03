package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.PositionDao;
import com.goit.homeworks.restaurant.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by SeVlad on 24.11.2016.
 */
@Component
public class IdToPositionConverter implements Converter<Object, Position>{
    @Autowired
    PositionDao positionDao;
    @Override
    public Position convert(Object source) {
        Integer id = Integer.parseInt((String)source);
        return positionDao.findPositionById(id);
    }
}
