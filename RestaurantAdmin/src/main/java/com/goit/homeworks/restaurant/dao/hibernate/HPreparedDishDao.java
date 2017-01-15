package com.goit.homeworks.restaurant.dao.hibernate;

import com.goit.homeworks.restaurant.dao.PreparedDishDao;
import com.goit.homeworks.restaurant.model.Order;
import com.goit.homeworks.restaurant.model.PreparedDish;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 20.11.2016.
 */
public class HPreparedDishDao implements PreparedDishDao {
    SessionFactory sessionFactory;

    public HPreparedDishDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public PreparedDish create(PreparedDish item) {
        sessionFactory.getCurrentSession().save(item);
        return item;
    }

    @Override
    @Transactional
    public int remove(PreparedDish item) {
        sessionFactory.getCurrentSession().delete(item);
        return 1;
    }

    @Override
    @Transactional
    public int update(PreparedDish item) {
        sessionFactory.getCurrentSession().update(item);
        return 1;
    }

    @Override
    @Transactional
    public List<PreparedDish> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select p from PreparedDish p").list();
    }

    @Override
    @Transactional
    public List<PreparedDish> findPreparedDishes() {
        Query query = sessionFactory.getCurrentSession().createQuery("select p from PreparedDish p where p.prepared=true");
        return query.list();
    }

    @Override
    @Transactional
    public PreparedDish findPreparedDishById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select p from PreparedDish p where p.id=:id");
        query.setParameter("id", id);
        return (PreparedDish) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<PreparedDish> getAllDishFromOrder(int orderId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select o from Order o where o.id=:orderId");
        query.setParameter("orderId", orderId);
        return ((Order)query.uniqueResult()).getPreparedDishes();
    }

    @Override
    @Transactional
    public List<PreparedDish> getAllPreparedDishFromOrder(int orderId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select p from PreparedDish p where p.order.id=:orderId and p.prepared=true");
        query.setParameter("orderId", orderId);
        return query.list();
    }
}
