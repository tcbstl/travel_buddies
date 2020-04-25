package com.tommybalestreri.hellospring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Destination {

    @Id
    @GeneratedValue
    private int id;

    private String name;

//    @ManyToMany(mappedBy = "destinationList")
//    @Cascade(CascadeType.DELETE)
//    private final List<User> userList = new ArrayList<>();

//    @ManyToMany(mappedBy = "destinationList")
//    @Cascade(CascadeType.DELETE)
    @ManyToMany(mappedBy = "destinationList")
    public final Set<User> userList = new HashSet<User>();

    public Destination(String name) {
        this.name = name;
    }

    public Destination() {}

//    public List<User> getUserList() {
//        return userList;
//    }

    public void addUser(User user) {
        this.userList.add(user);
        user.getDestinationList().add(this);
    }

    public void removeUser(User user) {
        this.userList.remove(user);
        user.getDestinationList().remove(this);
    }


//em.persist()

    public Set<User> getUserList() {
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
