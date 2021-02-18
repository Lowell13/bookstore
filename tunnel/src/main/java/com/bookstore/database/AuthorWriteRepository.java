package com.bookstore.database;

import com.bookstore.entity.Author;

import java.util.HashMap;
import java.util.Map;

public class AuthorWriteRepository {
    private final Map<String, Author> authorStore = new HashMap<>();

    public void addAuthor(String id, Author author) {
        this.authorStore.put(id, author);
    }

    public Author getAuthor(String id) {
        return this.authorStore.get(id);
    }
}
