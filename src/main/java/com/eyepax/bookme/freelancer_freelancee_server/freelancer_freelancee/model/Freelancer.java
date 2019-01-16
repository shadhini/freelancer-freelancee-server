package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data // Lombok annotation to create all the getters, setters, equals,  hash, and toString methods, based on the fields.
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store.
public class Freelancer{

    private @Id
    @GeneratedValue
    Long id; // JPA annotations to indicate it’s the primary key and automatically populated by the JPA provider.
    private String firstName;
    private String lastName;
    private String email;

    public Freelancer() {
    }

    public Freelancer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
