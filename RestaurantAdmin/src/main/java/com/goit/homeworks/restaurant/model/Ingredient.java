package com.goit.homeworks.restaurant.model;

import javax.persistence.*;

/**
 * Created by SeVlad on 22.10.2016.
 */
@Entity
@Table(name = "INGREDIENTS")
public class Ingredient {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AMOUNT")
    private int amount;

    public Ingredient(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public Ingredient(String name, int amount) {
        this(0, name, amount);
    }

    public Ingredient() {
        this(0, "", 0);
    }

    public boolean isNew(){ return id == 0; }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Ingredient(String name) {
        this.name = name;
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

        Ingredient that = (Ingredient) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }
    public void decAmount(int amount){
        this.amount -= amount;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
