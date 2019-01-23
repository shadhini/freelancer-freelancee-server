package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public abstract class User {

    private @Id @GeneratedValue String id; // JPA annotations to indicate it’s the primary key and automatically populated by the JPA provider.
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
