package com.goit.homeworks.restaurant.dao.hibernate;

import com.goit.homeworks.restaurant.dao.OrderDao;
import com.goit.homeworks.restaurant.model.Order;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 20.11.2016.
 */
public class HOrderDao implements OrderDao {
    SessionFactory sessionFactory;

    public HOrderDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Order create(Order item) {
        sessionFactory.getCurrentSession().save(item);
        return item;
    }

    @Override
    @Transactional
    public int remove(Order item) {
        sessionFactory.getCurrentSession().delete(item);
        return 1;
    }

    @Override
    @Transactional
    public int update(Order item) {
        sessionFactory.getCurrentSession().update(item);
        return 1;
    }

    @Override
    @Transactional
    public List<Order> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o").list();
    }

    @Override
    @Transactional
    public List<Order> getAllOpenOrders() {
        return sessionFactory.getCurrentSession                                                    ().createQuery("select o from Order o where o.open=true").list();
    }

    @Override
    @Transactional
    public List<Order> getAllClosedOrders() {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o where o.open=false").list();
    }

    @Override
    @Transactional
    public Order findOrderById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select o from Order o where o.id=:id");
        query.setParameter("id", id);
        return (Order)query.uniqueResult();
    }
}
