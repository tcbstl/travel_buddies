package com.tommybalestreri.hellospring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters.")
    private String username;

    @NotBlank
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters.")
    private String password;

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

    public Set<Destination> getDestinationList() {
        return destinationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
