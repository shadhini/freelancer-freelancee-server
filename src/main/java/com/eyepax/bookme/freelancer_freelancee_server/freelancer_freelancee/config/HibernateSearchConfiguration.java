package com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.config;

import com.eyepax.bookme.freelancer_freelancee_server.freelancer_freelancee.service.HibernateSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.EntityManager;

@EnableAutoConfiguration
@Configuration
public class HibernateSearchConfiguration {

    @Autowired
    private EntityManager b_entityManager;



    HibernateSearchService searchService() {
        HibernateSearchService hibernateSearchService = new HibernateSearchService(b_entityManager);
        hibernateSearchService.initializeHibernateSearch();
        return hibernateSearchService;
    }
}
