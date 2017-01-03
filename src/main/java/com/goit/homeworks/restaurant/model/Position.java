package com.goit.homeworks.restaurant.model;

import javax.persistence.*;

/**
 * Created by SeVlad on 22.10.2016.
 */
@Entity
@Table(name = "POSITIONS")
public class Position {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "POSITION")
    private String position;

    public Position() {
        this(0,"");
    }

    public Position(int id, String position) {
        this.id = id;
        this.position = position;
    }

    public Position(String position) {
        this.position = position;
    }

    public Position(int id) {
        this.id = id;
    }

    public boolean isNew(){ return id == 0; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        if (id != position1.id) return false;
        return position != null ? position.equals(position1.position) : position1.position == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
