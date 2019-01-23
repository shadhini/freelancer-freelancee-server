package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model;

import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Data // Lombok annotation to create all the getters, setters, equals,  hash, and toString methods, based on the fields.
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store.
@Indexed
@Table(name = "Freelancer")
public class Freelancer{

    private @Id
    @GeneratedValue
    Long id; // JPA annotations to indicate it’s the primary key and automatically populated by the JPA provider.
    @Field(termVector = TermVector.YES)
    private String firstName;
    @Field(termVector = TermVector.YES)
    private String lastName;
    @Field(termVector = TermVector.YES)
    private String email;
    @Field(termVector = TermVector.YES)
    private String city;
    @Field(termVector = TermVector.YES)
    private String skills;

    public Freelancer() {
    }

    public Freelancer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Freelancer(String firstName, String lastName, String email, String city, String skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.skills = skills;
    }


}
