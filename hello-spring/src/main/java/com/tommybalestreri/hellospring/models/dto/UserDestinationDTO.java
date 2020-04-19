package com.tommybalestreri.hellospring.models.dto;

import com.tommybalestreri.hellospring.models.Destination;
import com.tommybalestreri.hellospring.models.User;

import javax.validation.constraints.NotNull;

public class UserDestinationDTO {

    @NotNull
    private User user;

    @NotNull
    private Destination destination;

    public UserDestinationDTO() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
