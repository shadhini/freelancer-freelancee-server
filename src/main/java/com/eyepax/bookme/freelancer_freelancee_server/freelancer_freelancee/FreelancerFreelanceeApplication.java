package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //  a meta-annotation that pulls in component scanning, autoconfiguration, and property support.
// will fire up a servlet container and serve up our service.
public class FreelancerFreelanceeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelancerFreelanceeApplication.class, args);
    }

}

