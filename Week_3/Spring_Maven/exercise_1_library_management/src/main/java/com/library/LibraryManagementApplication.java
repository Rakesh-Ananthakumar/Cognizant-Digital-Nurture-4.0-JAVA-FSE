package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Application Context loaded successfully.\n");

        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        bookService.addBook("Cognizant Digital Future 4.0");
        
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}