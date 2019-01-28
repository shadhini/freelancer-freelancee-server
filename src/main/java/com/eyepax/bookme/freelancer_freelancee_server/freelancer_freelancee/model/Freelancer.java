package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model;

//import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


//@Data // Lombok annotation to create all the getters, setters, equals,  hash, and toString methods, based on the fields.
@Entity // JPA annotation to make this object ready for storage in a JPA-based data store.

@Table(name = "Freelancer")
public class Freelancer{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id; // JPA annotations to indicate it’s the primary key and automatically populated by the JPA provider.

    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    private String currentJobTitle;

    private String gender;

    private String contactNo;

    private String ratePerHour;

    private String skills;

    private String experience;

    private String description;

    private String city;

    private String tagLine;


    public Freelancer() {
    }

    public Freelancer(@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 15) String username, @NotBlank @Size(max = 40) @Email String email, String gender, String contactNo, String ratePerHour, String skills, String experience, String description, String city, String tagLine) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.contactNo = contactNo;
        this.ratePerHour = ratePerHour;
        this.skills = skills;
        this.experience = experience;
        this.description = description;
        this.city = city;
        this.tagLine = tagLine;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentJobTitle() {
        return currentJobTitle;
    }

    public void setCurrentJobTitle(String currentJobTitle) {
        this.currentJobTitle = currentJobTitle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(String ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }
}
