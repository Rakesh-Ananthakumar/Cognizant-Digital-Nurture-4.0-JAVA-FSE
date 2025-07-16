package com.cognizant.spring_learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;

@RestController
public class CountryController {

    private static final Logger log = LoggerFactory.getLogger(CountryController.class);
    
    @Autowired
    private CountryService countryService;

    @RequestMapping("/country")
    public Country getCountryIndia() {
        log.info("Start: getCountryIndia() method called");

        log.info("Loading country bean from XML configuration...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        log.info("Bean loaded successfully. Retrieving country...");
        Country country = context.getBean("country", Country.class);

        context.close(); // Close the context to prevent resource leak

        log.info("End: getCountryIndia() method returning country: {}", country.toString());
        return country;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        log.info("Start: getAllCountries() method called");

        log.info("Loading all country beans from XML configuration...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        log.info("Beans loaded successfully. Retrieving all countries...");
        List<Country> countries = new ArrayList<>();

        countries.add(context.getBean("country", Country.class));
        countries.add(context.getBean("usa", Country.class));
        countries.add(context.getBean("japan", Country.class));
        countries.add(context.getBean("germany", Country.class));

        context.close();

        log.info("End: getAllCountries() method returning {} countries", countries.size());
        return countries;
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        log.info("Start: getCountry() method called with code: {}", code);
        
        Country country = countryService.getCountry(code);
        
        if (country != null) {
            log.info("End: getCountry() method returning country: {}", country.toString());
            return country;
        } else {
            log.warn("Country with code '{}' not found", code);
            return null;
        }
    }

}
