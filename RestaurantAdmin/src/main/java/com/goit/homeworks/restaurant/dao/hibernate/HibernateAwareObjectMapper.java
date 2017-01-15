package com.goit.homeworks.restaurant.dao.hibernate;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * Created by SeVlad on 22.12.2016.
 */
public class HibernateAwareObjectMapper extends ObjectMapper {
    public HibernateAwareObjectMapper() {
        registerModule(new Hibernate5Module());
        disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
    }
}
