package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void displayDate() {
		log.info("Loading date format bean from XML configuration...");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		log.info("Bean loaded successfully. Retrieving date format...");
		SimpleDateFormat dateFormat = context.getBean("dateFormat", SimpleDateFormat.class);
		log.info("Formatting current date using the retrieved format...");
		log.debug("Current Date: {}", dateFormat.format(new java.util.Date()));
		log.info("Date displayed successfully.");
	}

	public static void displayCountry() {
		log.info("Loading country bean from XML configuration...");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		log.info("Bean loaded successfully. Retrieving country...");
		Country country = context.getBean("country", Country.class);
		log.debug("Country : {}", country.toString());
		log.info("Country displayed successfully.");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		log.info("Spring Application has started successfully.");

		// log.info("Displaying current date in specified format:");
		// displayDate();

		// log.info("Displaying country information:");
		// displayCountry();
	}

}
