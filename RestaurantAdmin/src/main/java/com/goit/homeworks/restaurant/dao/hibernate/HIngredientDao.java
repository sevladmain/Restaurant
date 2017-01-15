package com.goit.homeworks.restaurant.dao.hibernate;

import com.goit.homeworks.restaurant.dao.IngredientDao;
import com.goit.homeworks.restaurant.model.Ingredient;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 20.11.2016.
 */
public class HIngredientDao implements IngredientDao {
    SessionFactory sessionFactory;

    public HIngredientDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Ingredient create(Ingredient item) {
        sessionFactory.getCurrentSession().save(item);
        return item;
    }

    @Override
    @Transactional
    public int remove(Ingredient item) {
        sessionFactory.getCurrentSession().delete(item);
        return 1;
    }

    @Override
    @Transactional
    public int update(Ingredient item) {
        sessionFactory.getCurrentSession().update(item);
        return 1;
    }

    @Override
    @Transactional
    public List<Ingredient> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select i from Ingredient i").list();
    }

    @Override
    @Transactional
    public List<Ingredient> findIngredientByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("select i from Ingredient i where i.name like :name");
        query.setParameter("name", "%" + name + "%");
        return query.list();
    }

    @Override
    @Transactional
    public List<Ingredient> getAllEndIngredients(int minAmount) {
        Query query = sessionFactory.getCurrentSession().createQuery("select i from Ingredient i where i.amount<=:minAmount");
        query.setParameter("minAmount", minAmount);
        return query.list();
    }

    @Override
    @Transactional
    public Ingredient findIngredientById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select i from Ingredient i where i.id=:id");
        query.setParameter("id", id);
        return (Ingredient)query.uniqueResult();
    }
}
