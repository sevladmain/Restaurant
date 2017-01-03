package com.goit.homeworks.restaurant.dao.hibernate;

import com.goit.homeworks.restaurant.dao.MenuDao;
import com.goit.homeworks.restaurant.model.Menu;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 20.11.2016.
 */
public class HMenuDao implements MenuDao {
    SessionFactory sessionFactory;

    public HMenuDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Menu create(Menu item) {
        sessionFactory.getCurrentSession().save(item);
        return item;
    }

    @Override
    @Transactional
    public int remove(Menu item) {
        sessionFactory.getCurrentSession().delete(item);
        return 1;
    }

    @Override
    @Transactional
    public int update(Menu item) {
        sessionFactory.getCurrentSession().update(item);
        return 1;
    }

    @Override
    @Transactional
    public List<Menu> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m").list();
    }

    @Override
    @Transactional
    public List<Menu> findMenuByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.list();
    }

    @Override
    @Transactional
    public Menu findMenuById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.id=:id");
        query.setParameter("id", id);
        return (Menu)query.uniqueResult();
    }
}
