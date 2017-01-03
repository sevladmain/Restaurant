package com.goit.homeworks.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SeVlad on 22.10.2016.
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ID_EMP")
    private Employee employee;

    @Column(name = "TABLE_NUM")
    private int tableNum;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "ISOPEN")
    private boolean open;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order")
    List<PreparedDish> preparedDishes = new ArrayList<>();

    public Order() {
        this(0, new Employee(), 0, Date.valueOf("2010-01-01"), true);
    }

    public Order(Employee employee, int tableNum, Date date, boolean open) {
        this.employee = employee;
        this.tableNum = tableNum;
        this.date = date;
        this.open = open;
    }

    public Order(int id, Employee employee, int tableNum, Date date, boolean open) {
        this.id = id;
        this.employee = employee;
        this.tableNum = tableNum;
        this.date = date;
        this.open = open;
    }

    public boolean isNew() {
        return id == 0;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<PreparedDish> getPreparedDishes() {
        return preparedDishes;
    }

    public void setPreparedDishes(List<PreparedDish> preparedDishes) {
        this.preparedDishes = preparedDishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (tableNum != order.tableNum) return false;
        if (open != order.open) return false;
        if (employee != null ? !employee.equals(order.employee) : order.employee != null) return false;
        return date != null ? date.equals(order.date) : order.date == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + tableNum;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (open ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", employee=" + employee +
                ", tableNum=" + tableNum +
                ", date=" + date +
                ", open=" + open +
                '}';
    }
}
