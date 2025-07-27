package com.library.controller;

import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public String addBook(@RequestBody String bookName) {
        bookService.addBook(bookName);
        return "Book added: " + bookName;
    }

    @GetMapping
    public List<String> getAllBooks() {
        return bookService.getAllBooks();
    }
}
