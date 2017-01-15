package com.goit.homeworks.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

/**
 * Created by SeVlad on 22.10.2016.
 */
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.All.class)
    private int id;

    @Column(name = "NAME")
    @JsonView(View.Details.class)
    private String name;

    public Category() {
        this(0,"");
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    @JsonIgnore
    public boolean isNew(){ return id == 0; }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        return name != null ? name.equals(category.name) : category.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
