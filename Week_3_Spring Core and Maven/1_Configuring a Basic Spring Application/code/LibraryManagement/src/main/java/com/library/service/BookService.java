package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(String bookName) {
        bookRepository.save(bookName);
    }

    public List<String> getAllBooks() {
        return bookRepository.findAll();
    }
}
