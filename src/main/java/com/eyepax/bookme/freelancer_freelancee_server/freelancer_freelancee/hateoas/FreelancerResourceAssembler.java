package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.hateoas;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.controller.FreelancerController;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


// This simple interface has one method: toResource(). It is based on converting a non-resource object (Employee) into a resource-based object (Resource<Employee>).
@Component //this component will be automatically created when the starts.
public class FreelancerResourceAssembler implements ResourceAssembler<Freelancer, Resource<Freelancer>>{
    @Override
    public Resource<Freelancer> toResource(Freelancer freelancer) {
        return new Resource<>(freelancer,
                linkTo(methodOn(FreelancerController.class).getFreelancer(freelancer.getUsername())).withSelfRel(),
                linkTo(methodOn(FreelancerController.class).all()).withRel("freelancers"));
    }
}
