package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.exception.config;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.exception.FreelancerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// This Spring MVC configuration is used to render an HTTP 404:
@ControllerAdvice
public class FreelancerNotFoundAdvice {

    @ResponseBody // signals that this advice is rendered straight into the response body.
    @ExceptionHandler(FreelancerNotFoundException.class) //  configures the advice to only respond if an  FreelancerNotFoundException is thrown.
    @ResponseStatus(HttpStatus.NOT_FOUND) // says to issues an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
    String freelancerNotFoundHandler(FreelancerNotFoundException exception){
        // The body of the advice generates the content. In this case, it gives the message of the exception.
        return exception.getMessage();
    }
}
