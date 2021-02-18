package com.bookstore.database;

import com.bookstore.entity.Book;

import java.util.HashMap;
import java.util.Map;

public class BookWriteRepository {
    private final Map<String, Book> bookStore = new HashMap<>();

    public void addBook(String id, Book book) {
        this.bookStore.put(id, book);
    }

    public Book getBook(String id) {
        return this.bookStore.get(id);
    }
}
