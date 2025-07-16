package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger log = LoggerFactory.getLogger(SpringLearnApplication.class);
    String name;
    String code;

    public Country() {}

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        log.info("Retrieving country name: {}", name);
        return name;
    }

    public String getCode() {
        log.info("Retrieving country code: {}", code);
        return code;
    }

    public void setName(String name) {
        log.info("Setting country name to: {}", name);
        this.name = name;

    }

    public void setCode(String code) {
        log.info("Setting country code to: {}", code); 
        this.code = code;
    }

    public String toString() {
        log.info("Converting country to string representation");
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
