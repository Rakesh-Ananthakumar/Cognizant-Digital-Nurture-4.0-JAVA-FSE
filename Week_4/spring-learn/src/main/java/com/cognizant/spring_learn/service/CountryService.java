package com.cognizant.spring_learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;

@Service
public class CountryService {

    private static final Logger log = LoggerFactory.getLogger(CountryService.class);

    public Country getCountry(String code) {
        log.info("Start: getCountry() method called with code: {}", code);

        log.info("Loading all country beans from XML configuration...");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        log.info("Beans loaded successfully. Retrieving all countries...");
        List<Country> countries = new ArrayList<>();

        countries.add(context.getBean("country", Country.class));
        countries.add(context.getBean("usa", Country.class));
        countries.add(context.getBean("japan", Country.class));
        countries.add(context.getBean("germany", Country.class));

        context.close();

        log.info("Searching for country with code: {}", code);

        Optional<Country> foundCountry = countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();

        if (foundCountry.isPresent()) {
            log.info("End: getCountry() method returning country: {}", foundCountry.get().toString());
            return foundCountry.get();
        } else {
            log.warn("Country with code '{}' not found", code);
            return null;
        }
    }
}
