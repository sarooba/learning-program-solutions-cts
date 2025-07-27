package com.company.inventory;

public class LibraryDemo {
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "Harry Potter", "J.K. Rowling"),
            new Book(103, "Clean Code", "Robert C. Martin"),
            new Book(104, "Wings of Fire", "A.P.J. Abdul Kalam"),
            new Book(105, "The Hobbit", "J.R.R. Tolkien")
        };

        System.out.println("Linear Search: Searching for 'Clean Code'");
        Book result1 = LibrarySearch.linearSearch(books, "Clean Code");
        System.out.println(result1 != null ? result1 : "Book not found");

        LibrarySearch.sortBooksByTitle(books);

        System.out.println("\nBinary Search: Searching for 'Clean Code'");
        Book result2 = LibrarySearch.binarySearch(books, "Clean Code");
        System.out.println(result2 != null ? result2 : "Book not found");
    }
}
