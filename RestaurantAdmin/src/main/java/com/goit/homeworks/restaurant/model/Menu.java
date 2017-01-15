package com.goit.homeworks.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SeVlad on 22.10.2016.
 */
@Entity
@Table(name = "MENU")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Details.class)
    private int id;

    @Column(name = "NAME")
    @JsonView(View.Details.class)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "menulist", joinColumns = @JoinColumn(name = "id_menu"),
            inverseJoinColumns = @JoinColumn(name = "id_dish"))
    List<Dish> dishes = new ArrayList<>();

    public Menu() {
        this(0, "");
    }

    public void setId(int id) {
        this.id = id;
    }

    public Menu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Menu(String name) {
        this.name = name;
    }

    @JsonIgnore
    public boolean isNew() {
        return id == 0;
    }

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

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        return name != null ? name.equals(menu.name) : menu.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @JsonView(View.All.class)
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
