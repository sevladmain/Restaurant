package com.goit.homeworks.restaurant.services;

import com.goit.homeworks.restaurant.dao.EmployeeDao;
import com.goit.homeworks.restaurant.dao.PositionDao;
import com.goit.homeworks.restaurant.model.Employee;
import com.goit.homeworks.restaurant.model.Position;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 06.11.2016.
 */
@Service
public class EmployeeService {
    private EmployeeDao employeeDao;
    private PositionDao positionDao;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public PositionDao getPositionDao() {
        return positionDao;
    }

    @Transactional
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    @Transactional
    public List<Employee> findEmployeeByName(String name) {
        return employeeDao.findEmployeeByName(name);
    }

    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDao.findEmployeeById(id);
    }

    @Transactional
    public int deleteEmployee(Employee employee) {
        return employeeDao.remove(employee);
    }

    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeDao.create(employee);
    }

    @Transactional
    public List<Position> getAllPositions() {
        return positionDao.getAll();
    }

    @Transactional
    public int updateEmployee(Employee employee) {
        return employeeDao.update(employee);
    }
}
