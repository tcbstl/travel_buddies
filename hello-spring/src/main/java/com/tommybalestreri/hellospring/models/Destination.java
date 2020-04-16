package com.tommybalestreri.hellospring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Destination {

    @Id
    @GeneratedValue
    private int id;

//    private static int nextId = 1;

    private String destination;

    public Destination(String destination) {
        this.destination = destination;
//        this.id = nextId;
//        nextId++;
    }

    public Destination() {}

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }



    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
