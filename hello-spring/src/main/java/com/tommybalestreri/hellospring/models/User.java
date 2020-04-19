package com.tommybalestreri.hellospring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String username;
    private String password;

    @ManyToMany
    private final List<Destination> destinationList = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Destination> getDestinationList() {
        return destinationList;
    }

    public void addDestination(Destination destination){
        this.destinationList.add(destination);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
