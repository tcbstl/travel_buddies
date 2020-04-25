package com.tommybalestreri.hellospring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

//    @OneToOne(cascade = CascadeType.ALL)
//    public Destination destination;


    @ManyToMany(cascade ={
        CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST})
    public final Set<Destination> destinationList = new HashSet<Destination>();

    public void addDestination(Destination destination) {
        this.destinationList.add(destination);
        destination.getUserList().add(this);
    }

    public void removeDestination(Destination destination) {
        this.destinationList.remove(destination);
        destination.getUserList().remove(this);
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

//    public List<Destination> getDestinationList() {
//        return destinationList;
//    }
    public Set<Destination> getDestinationList() {
        return destinationList;
    }

//    public Destination getDestination() {
//        return destination;
//    }
//    public void addDestination(Destination destination){
//        this.destinationList.add(destination);
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
