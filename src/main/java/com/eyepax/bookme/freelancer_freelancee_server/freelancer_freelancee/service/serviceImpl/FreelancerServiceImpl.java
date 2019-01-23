package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.service.serviceImpl;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.repository.FreelancerRepository;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreelancerServiceImpl implements FreelancerService {


    private FreelancerRepository freelancerRepository;

    Freelancer TedWilliams = new Freelancer();
    Freelancer BobGibson = new Freelancer();
    Freelancer HonusWagner = new Freelancer();
    Freelancer BilboBaggins = new Freelancer();
    Freelancer FrodoBaggins = new Freelancer();

    @Autowired
    public void setSalonRepositary(FreelancerRepository salonRepositary) {
        this.freelancerRepository = salonRepositary;
    }

    @Override
    public List<Freelancer> findAllFreelancers() {
        return freelancerRepository.findAll();
    }

    @Override
    public Freelancer saveFreelancer(Freelancer freelancer) {
        return freelancerRepository.save(freelancer);
    }

    @Override
    public Optional<Freelancer> findById(String id) {
        return freelancerRepository.findById(id);
    }

    @Override
    public void delete(Freelancer freelancer) {
        freelancerRepository.delete(freelancer);
    }

    @Override
    public void addFreelancer() {
        TedWilliams.setFirstName("Ted");
        TedWilliams.setLastName("Williams");
        TedWilliams.setEmail("ted.w@eyepax.com");
        TedWilliams.setCity("Los Angeles");
        TedWilliams.setSkills("Hair Coloring, Hair Cutting, Layering");



        BobGibson.setFirstName("Bob");
        BobGibson.setLastName("Gibson");
        BobGibson.setEmail("bob.g@eyepax.com");
        BobGibson.setCity("Houston");
        BobGibson.setSkills("Hair Coloring, Hair Cutting");

    }

}
