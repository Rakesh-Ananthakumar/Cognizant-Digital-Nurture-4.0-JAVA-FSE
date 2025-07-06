package com.cognizant.orm_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	private static void testGetAllCountries() {
		LOGGER.info("START");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("END");
	}
	private static void testAddCountries() {
		LOGGER.info("START");
		if(countryService.addCountry("AU", "Australia")) {
			LOGGER.info("Country added successfully");
		} else {
			LOGGER.error("Failed to add country");
		}
		LOGGER.info("END");
	}
	private static void testFindCountryByCode() {
		LOGGER.info("START");
		Country country = countryService.findCountryByCode("IN");
		if (country != null) {
			LOGGER.debug("Country found: {}", country);
		} else {
			LOGGER.error("Country not found");
		}
		LOGGER.info("END");
	}
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		testAddCountries();
		testGetAllCountries();
		testFindCountryByCode();
	}

}
