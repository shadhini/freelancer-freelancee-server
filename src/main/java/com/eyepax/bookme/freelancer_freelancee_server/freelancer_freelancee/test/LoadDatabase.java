package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.test;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.repository.FreelancerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
//
//This runner will request a copy of the EmployeeRepository you just created.
//
//Using it, it will create two entities and store them.

//@Slf4j is a Lombok annotation to autocreate an Slf4j-based  LoggerFactory as log, allowing us to log these newly created "freelancers".
@Configuration
@Slf4j
public class LoadDatabase {



    @Bean
    CommandLineRunner initSalonDataBase(FreelancerRepository freelancerRepository) {
        return args -> {
            log.debug("Preloading " + freelancerRepository.save(new Freelancer("1", "Ted", "Williams", "ted.w@eyepax.com", "Los Angeles", "Hair Coloring, Hair Cutting, Layering")));
            log.debug("Preloading " + freelancerRepository.save(new Freelancer("2","Bob", "Gibson", "bob.g@eyepax.com", "Houston", "Hair Coloring, Hair Cutting")));
        };
    }
}
