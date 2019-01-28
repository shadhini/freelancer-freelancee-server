package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.repository;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// This interface extends Spring Data JPA’s JpaRepository, specifying the domain type as Employee and the id type as Long
// his interface, though empty on the surface, packs a punch given it supports:
//
//Creating new instances
//
//Updating existing ones
//
//Deleting
//
//Finding (one, all, by simple or complex properties)
public interface FreelancerRepository extends JpaRepository<Freelancer, String> {

    @Override
    List<Freelancer> findAll();

    Optional<Freelancer> findByUsername(String username);

}
