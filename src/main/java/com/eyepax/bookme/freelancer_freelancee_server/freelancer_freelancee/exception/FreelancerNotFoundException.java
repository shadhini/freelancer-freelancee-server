package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.exception;

// an exception used to indicate when an employee is looked up but not found.
public class FreelancerNotFoundException extends RuntimeException{

    public FreelancerNotFoundException(String freelancer) {
        super("Could not find freelancer " + freelancer);
    }


}
