package com.goit.homeworks.restaurant.dao;

import com.goit.homeworks.restaurant.model.Employee;

import java.util.List;

/**
 * Created by SeVlad on 24.10.2016.
 */
public interface EmployeeDao extends SimpleDao<Employee> {
    List<Employee> findEmployeeByName(String name);
    Employee findEmployeeById(int id);
}
