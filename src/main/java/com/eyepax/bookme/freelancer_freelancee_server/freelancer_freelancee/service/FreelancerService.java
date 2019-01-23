package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.service;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;

import java.util.List;
import java.util.Optional;

public interface FreelancerService {

    List<Freelancer> findAllFreelancers();

    Freelancer saveFreelancer(Freelancer freelancer);

    Optional<Freelancer> findById(String id);

    void delete(Freelancer freelancer);

    void addFreelancer();
}
