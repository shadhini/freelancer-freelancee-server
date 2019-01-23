package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.controller;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.exception.FreelancerNotFoundException;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.hateoas.FreelancerResourceAssembler;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.model.Freelancer;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.repository.FreelancerRepository;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.service.FreelancerService;
import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.service.HibernateSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


// REST API
// A critical ingredient to any RESTful service is adding links to relevant operations.

// routes for each operations (@GetMapping, @PostMapping, @PutMapping and @DeleteMapping, corresponding to HTTP GET, POST, PUT, and DELETE calls)
@CrossOrigin(origins = "http://localhost:3000")
@RestController // indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
@RequestMapping("/api")
public class FreelancerController {


    private final FreelancerRepository repository;
    private final FreelancerResourceAssembler assembler;

    @Autowired
    private HibernateSearchService searchservice;

    @Autowired
    private FreelancerService freelancerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String search(@RequestParam(value = "search", required = false) String q, Model model) {
        List<Freelancer> searchResults = null;
        try {
            freelancerService.addFreelancer();
            searchResults = searchservice.fuzzySearch(q);

        } catch (Exception ex) {
            // here you should handle unexpected errors
            // ...
            // throw ex;
        }
        model.addAttribute("search", searchResults);
        return "index";

    }


    // FreelancerRepository is injected by constructor into the controller.
    public FreelancerController(FreelancerRepository repository, FreelancerResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler; // To leverage this assembler, you only have to alter the EmployeeController by injecting the assembler
    }

    // Aggregate root

//    @GetMapping("/freelancers")
//    List<Freelancer> all() {
//        return repository.findAll();
//    }
    @GetMapping(path = "/freelancers", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
    public Resources<Resource<Freelancer>> all(){
        List<Resource<Freelancer>> freelancers = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(freelancers,
                linkTo(methodOn(FreelancerController.class).all()).withSelfRel());
    }

    // The new Freelancer object is saved as before. But the resulting object is wrapped using the FreelancerResourceAssembler.
    // Spring MVC’s ResponseEntity is used to create an HTTP 201 Created status message. This type of response typically includes a Location response header, and we use the newly formed link.
    // Additionally, return the resource-based version of the saved object.
    @PostMapping("/freelancers")
    ResponseEntity<?> newFreelancer(@RequestBody Freelancer newFreelancer) {
        Resource<Freelancer> resource = assembler.toResource(repository.save(newFreelancer));

        try {
            return ResponseEntity
                    .created(new URI((resource.getId().expand().getHref())))
                    .body(resource);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(resource); //manually added
    }
    // the result will have the Location header populated with http://localhost:8080/employees/3. A hypermedia powered client could opt to "surf" to this new resource and proceed to interact with it



    // Single item

    // Resource<T> is a generic container from Spring HATEOAS that includes not only the data but a collection of links
    // linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel() asks that Spring HATEOAS build a link to the EmployeeController 's one() method, and flag it as a self link.
    //
    //linkTo(methodOn(EmployeeController.class).all()).withRel("employees") asks Spring HATEOAS to build a link to the aggregate root, all(), and call it "employees".
    //One of Spring HATEOAS’s core types is  Link. It includes a URI and a rel (relation). Links are what empower the web.
    @GetMapping(path = "/freelancers/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"} )
    public Resource<Freelancer> one(@PathVariable String id) {

        Freelancer freelancer = repository.findById(id)
                .orElseThrow(() -> new FreelancerNotFoundException(id));

        return assembler.toResource(freelancer);
    }


    // The Employee object built from the save() operation is then wrapped using the EmployeeResourceAssembler into a Resource<Employee> object. Since we want a more detailed HTTP response code than 200 OK, we will use Spring MVC’s ResponseEntity wrapper. It has a handy static method created() where we can plug in the resource’s URI.
    //
    //By grabbing the resource you can fetch it’s "self" link via the getId() method call. This method yields a Link which you can turn into a Java URI. To tie things up nicely, you inject the resource itself into the body() method.
    //
    //In REST, a resource’s id is the URI of that resource. Hence, Spring HATEOAS doesn’t hand you the id field of the underlying data type (which no client should), but instead, the URI for it. And don’t confuse ResourceSupport.getId() with Employee.getId().
    @PutMapping("/freelancers/{id}")
    ResponseEntity<?> replaceFreelancer(@RequestBody Freelancer newFreelancer, @PathVariable String id) throws URISyntaxException {

        Freelancer updatedFreelancer = repository.findById(id)
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

        Resource<Freelancer> resource = assembler.toResource(updatedFreelancer);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @DeleteMapping("/freelancers/{id}")
    ResponseEntity<?> deleteFreelancer(@PathVariable String id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
