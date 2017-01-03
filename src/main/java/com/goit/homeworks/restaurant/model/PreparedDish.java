package com.goit.homeworks.restaurant.model;

import javax.persistence.*;

/**
 * Created by SeVlad on 30.10.2016.
 */
@Entity
@Table(name = "PREPARED_DISHES")
public class PreparedDish {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ID_DISH")
    private Dish dish;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ID_EMPLOYEE")
    private Employee employee;

    @Column(name = "ID_ORDER")
    private int orderId;

    @Column(name = "IS_PREPARED")
    private boolean prepared;

    public PreparedDish() {
        this(new Dish(), new Employee(), 0, false);
    }

    public PreparedDish(Dish dish, Employee employee, int orderId, boolean prepared) {
        this.dish = dish;
        this.employee = employee;
        this.orderId = orderId;
        this.prepared = prepared;
    }

    public PreparedDish(int id, Dish dish, Employee employee, int orderId, boolean prepared) {

        this.id = id;
        this.dish = dish;
        this.employee = employee;
        this.orderId = orderId;
        this.prepared = prepared;
    }

    public boolean isNew(){ return id == 0; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isPrepared() {
        return prepared;
    }

    public void setPrepared(boolean prepared) {
        this.prepared = prepared;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreparedDish that = (PreparedDish) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (prepared != that.prepared) return false;
        if (dish != null ? !dish.equals(that.dish) : that.dish != null) return false;
        return employee != null ? employee.equals(that.employee) : that.employee == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dish != null ? dish.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + orderId;
        result = 31 * result + (prepared ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PreparedDish{" +
                "id=" + id +
                ", dish=" + dish +
                ", employee=" + employee +
                ", orderId=" + orderId +
                ", prepared=" + prepared +
                '}';
    }
}
