package com.goit.homeworks.restaurant.dao.hibernate;

import com.goit.homeworks.restaurant.dao.CategoryDao;
import com.goit.homeworks.restaurant.model.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SeVlad on 20.11.2016.
 */
public class HCategoryDao implements CategoryDao {
    SessionFactory sessionFactory;

    public HCategoryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Category create(Category item) {
        sessionFactory.getCurrentSession().save(item);
        return item;
    }

    @Override
    @Transactional
    public int remove(Category item) {
        sessionFactory.getCurrentSession().delete(item);
        return 1;
    }

    @Override
    @Transactional
    public int update(Category item) {
        sessionFactory.getCurrentSession().update(item);
        return 1;
    }

    @Override
    @Transactional
    public List<Category> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select c from Category c").list();
    }

    @Override
    @Transactional
    public Category findCategoryById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select c from Category c where c.id=:id");
        query.setParameter("id", id);
        return (Category)query.uniqueResult();
    }
}
