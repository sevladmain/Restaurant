package com.goit.homeworks.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DISHES")
public class Dish {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.All.class)
    private int id;

    @Column(name = "NAME")
    @JsonView(View.Details.class)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ID_CATEGORY")
    @JsonView(View.Details.class)
    private Category category;

    @Column(name = "PRICE")
    @JsonView(View.Details.class)
    private int price;

    @Column(name = "WEIGHT")
    @JsonView(View.Details.class)
    private int weight;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.dish", cascade = CascadeType.ALL)
    @JsonView(View.All.class)
    private List<IngredientList> ingredients = new ArrayList<>();

    public Dish() {
        this(0, "", new Category(), 0, 0);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish(String name, Category category, int price, int weight) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.weight = weight;
    }

    public Dish(int id, String name, Category category, int price, int weight) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.weight = weight;
    }
    @JsonIgnore
    public boolean isNew(){ return id == 0; }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientList> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientList> ingredients) {
        this.ingredients = ingredients;
    }

    @JsonIgnore
    public boolean isEnoughtIngredient(){
        for (IngredientList i :
                ingredients) {
            if (i.getAmount() > i.getIngredient().getAmount()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (id != dish.id) return false;
        if (price != dish.price) return false;
        if (weight != dish.weight) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        return category != null ? category.equals(dish.category) : dish.category == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
