package com.goit.homeworks.restaurant.dao.hibernate;

import com.goit.homeworks.restaurant.dao.PositionDao;
import com.goit.homeworks.restaurant.model.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 19.11.2016.
 */
public class HPositionDao implements PositionDao {
    SessionFactory sessionFactory;

    public HPositionDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Position create(Position item) {
        sessionFactory.getCurrentSession().save(item);
        return item;
    }

    @Override
    @Transactional
    public int remove(Position item) {
        sessionFactory.getCurrentSession().delete(item);
        return 1;
    }

    @Override
    @Transactional
    public int update(Position item) {
        sessionFactory.getCurrentSession().update(item);
        return 1;
    }

    @Override
    @Transactional
    public List<Position> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Position p").list();
    }

    @Override
    @Transactional
    public Position findPositionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from Position p where p.id=:id");
        query.setParameter("id", id);
        return (Position) query.uniqueResult();
    }
}
