package com.goit.homeworks.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SeVlad on 20.11.2016.
 */
@Entity
@Table(name = "ingredientlist")
@AssociationOverrides({
        @AssociationOverride(name = "pk.dish", joinColumns = @JoinColumn(name = "id_dish")),
        @AssociationOverride(name = "pk.ingredient", joinColumns = @JoinColumn(name = "id_ingredient"))
})
public class IngredientList implements Serializable {
    @EmbeddedId
    private IngredientKey pk = new IngredientKey();

    @Column(name = "used_amount")
    private int amount;

    public IngredientKey getPk() {
        return pk;
    }

    public void setPk(IngredientKey pk) {
        this.pk = pk;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Transient
    public Dish getDish(){
        return pk.getDish();
    }

    public void setDish(Dish dish){
        pk.setDish(dish);
    }

    @Transient
    public Ingredient getIngredient(){
        return pk.getIngredient();
    }

    public void setIngredient(Ingredient ingredient){
        pk.setIngredient(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientList that = (IngredientList) o;

        if (amount != that.amount) return false;
        return pk != null ? pk.equals(that.pk) : that.pk == null;

    }

    @Override
    public int hashCode() {
        int result = pk != null ? pk.hashCode() : 0;
        result = 31 * result + amount;
        return result;
    }
}

