package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.controller;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.exception.FreelancerNotFoundException;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.repository.FreelancerRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


// REST API
// A critical ingredient to any RESTful service is adding links to relevant operations.

// routes for each operations (@GetMapping, @PostMapping, @PutMapping and @DeleteMapping, corresponding to HTTP GET, POST, PUT, and DELETE calls)
@RestController // indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
public class FreelancerController {


    private final FreelancerRepository repository;

    // FreelancerRepository is injected by constructor into the controller.
    public FreelancerController(FreelancerRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

//    @GetMapping("/freelancers")
//    List<Freelancer> all() {
//        return repository.findAll();
//    }
    @GetMapping(path = "/freelancers", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    Resources<Resource<Freelancer>> all(){
        List<Resource<Freelancer>> freelancers = repository.findAll().stream()
                .map(freelancer -> new Resource<>(freelancer,
                        linkTo(methodOn(FreelancerController.class).one(freelancer.getId())).withSelfRel(),
                        linkTo(methodOn(FreelancerController.class).all()).withRel("freelancers")))
                .collect(Collectors.toList());

        return new Resources<>(freelancers,
                linkTo(methodOn(FreelancerController.class).all()).withSelfRel());
    }

    @PostMapping("/freelancers")
    Freelancer newFreelancer(@RequestBody Freelancer newFreelancer) {
        return repository.save(newFreelancer);
    }

    // Single item

//    @GetMapping("/freelancers/{id}")
//    Freelancer one(@PathVariable Long id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new FreelancerNotFoundException(id));
//    }

    // Resource<T> is a generic container from Spring HATEOAS that includes not only the data but a collection of links
    // linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel() asks that Spring HATEOAS build a link to the EmployeeController 's one() method, and flag it as a self link.
    //
    //linkTo(methodOn(EmployeeController.class).all()).withRel("employees") asks Spring HATEOAS to build a link to the aggregate root, all(), and call it "employees".
    //One of Spring HATEOAS’s core types is  Link. It includes a URI and a rel (relation). Links are what empower the web.
    @GetMapping(path = "/freelancers/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"} )
    Resource<Freelancer> one(@PathVariable Long id) {

        Freelancer freelancer = repository.findById(id)
                .orElseThrow(() -> new FreelancerNotFoundException(id));

        return new Resource<Freelancer>( freelancer,
            linkTo(methodOn(FreelancerController.class).one(id)).withSelfRel(),
                linkTo(methodOn(FreelancerController.class).all()).withRel("freelancers"));
    }


    @PutMapping("/freelancers/{id}")
    Freelancer replaceFreelancer(@RequestBody Freelancer newFreelancer, @PathVariable Long id) {

        return repository.findById(id)
                .map(freelancer -> {
                    freelancer.setFirstName(newFreelancer.getFirstName());
                    freelancer.setLastName(newFreelancer.getLastName());
                    freelancer.setEmail(newFreelancer.getEmail());
                    return repository.save(freelancer);
                })
                .orElseGet(() -> {
                    newFreelancer.setId(id);
                    return repository.save(newFreelancer);
                });
    }

    @DeleteMapping("/freelancers/{id}")
    void deleteFreelancer(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
