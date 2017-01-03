package com.goit.homeworks.restaurant.dao.hibernate;

import com.goit.homeworks.restaurant.dao.EmployeeDao;
import com.goit.homeworks.restaurant.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 19.11.2016.
 */
public class HEmployeeDao implements EmployeeDao {
    private SessionFactory sessionFactory;
    public HEmployeeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Employee create(Employee item) {
        sessionFactory.getCurrentSession().save(item);
        return item;
    }

    @Override
    @Transactional
    public int remove(Employee item) {
        sessionFactory.getCurrentSession().delete(item);
        return 1;
    }

    @Override
    @Transactional
    public int update(Employee item) {
        sessionFactory.getCurrentSession().update(item);
        return 1;
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e").list();
    }

    @Override
    @Transactional
    public List<Employee> findEmployeeByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Employee e where e.firstName like :name or e.lastName like :name");
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select e from Employee e where e.id=:id");
        query.setParameter("id", id);
        query.uniqueResult();
        Employee result = (Employee) query.uniqueResult();
        if (result == null)
            result = new Employee();
        return result;
    }
}
