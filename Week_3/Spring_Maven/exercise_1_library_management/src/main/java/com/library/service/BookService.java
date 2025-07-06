package com.library.service;

import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Constructor Injection
    // public BookService(BookRepository bookRepository) {
    //     this.bookRepository = bookRepository;
    // }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("\nBookRepository Dependency Injection Successful.");
    }

    public void addBook(String bookName) {
        bookRepository.saveBook(bookName);

    }
}
