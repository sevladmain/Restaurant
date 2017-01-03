package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.CategoryDao;
import com.goit.homeworks.restaurant.dao.EmployeeDao;
import com.goit.homeworks.restaurant.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * Created by SeVlad on 27.11.2016.
 */
@Component
public class IdToEmployeeConverter implements Converter<Object, Employee> {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee convert(Object source) {
        Integer id = Integer.parseInt((String) source);
        if (id == 0) {
            return employeeDao.getAll().get(0);
        } else {
            return employeeDao.findEmployeeById(id);
        }
    }
}
