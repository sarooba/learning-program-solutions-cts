package com.library.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<String> books = new ArrayList<>();

    public void save(String bookName) {
        books.add(bookName);
    }

    public List<String> findAll() {
        return books;
    }
}
