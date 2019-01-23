package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.service.serviceImpl;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.service.FreelancerService;
import org.springframework.stereotype.Service;

@Service
public class FreelancerServiceImpl implements FreelancerService {

    Freelancer TedWilliams = new Freelancer();
    Freelancer BobGibson = new Freelancer();
    Freelancer HonusWagner = new Freelancer();
    Freelancer BilboBaggins = new Freelancer();
    Freelancer FrodoBaggins = new Freelancer();

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
