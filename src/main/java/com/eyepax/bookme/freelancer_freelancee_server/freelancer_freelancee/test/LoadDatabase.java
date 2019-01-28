//package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.test;
//
//import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;
//import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.repository.FreelancerRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//// Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
////
////This runner will request a copy of the EmployeeRepository you just created.
////
////Using it, it will create two entities and store them.
//
////@Slf4j is a Lombok annotation to autocreate an Slf4j-based  LoggerFactory as log, allowing us to log these newly created "freelancers".
//@Configuration
//@Slf4j
//public class LoadDatabase {
//
//
//
//    @Bean
//    CommandLineRunner initSalonDataBase(FreelancerRepository freelancerRepository) {
//        return args -> {
//            log.debug("Preloading " + freelancerRepository.save(new Freelancer("Ted Williams", "Ted", "ted.w@eyepax.com" ,"Male","+(94)714679803","$2.8","Hair Coloring, Hair Cutting, Layering","Hair Dresser: 3 years", null, "Los Angeles", "Work to satisfy yourself, not others")));
//            log.debug("Preloading " + freelancerRepository.save(new Freelancer("Bob Gibson", "Bob", "bob.g@eyepax.com","Male" , "+(92)779807243", "$3.1", "Hair Coloring, Hair Cutting", "Fresh gradduate from Fashion School", null, "Houston", "Live like you will die tomorrow, Learn like you'll live forever")));
//        };
//    }
//}
