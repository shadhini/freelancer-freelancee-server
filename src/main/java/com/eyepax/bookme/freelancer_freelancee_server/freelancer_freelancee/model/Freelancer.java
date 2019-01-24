package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;
import java.util.List;


@Data // Lombok annotation to create all the getters, setters, equals,  hash, and toString methods, based on the fields.
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store.
@Indexed
@Table(name = "Freelancer")
public class Freelancer{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id; // JPA annotations to indicate it’s the primary key and automatically populated by the JPA provider.

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

    public Freelancer(String id,  String firstName, String lastName, String email, String city, String skills) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.skills = skills;
    }


}
