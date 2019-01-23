package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.exception;

// an exception used to indicate when an employee is looked up but not found.
public class FreelancerNotFoundException extends RuntimeException{

    public FreelancerNotFoundException(Long id) {
        super("Could not find freelancer " + id);
    }

}
