package com.tommybalestreri.hellospring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Destination {

    @Id
    @GeneratedValue
    private int id;

//    private static int nextId = 1;
//    private String destination;
    private String name;

    @ManyToMany(mappedBy = "destinationList")
    private final List<User> userList = new ArrayList<>();

    public Destination(String name) {
//        this();
        this.name = name;
//        this.id = nextId;
//        nextId++;
    }

    public Destination() {}

//    public String getDestination() {
//        return destination;
//    }
//
//    public void setDestination(String destination) {
//        this.destination = destination;
//    }


    public List<User> getUserList() {
        return userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
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
