package com.bookstore.api.service;

import com.bookstore.api.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();
    Optional<Author> getAuthorById(Long id);
    Optional<Author> getAuthorByName(String name);
    Author saveAuthor(Author author);
    void deleteAuthor(Author author);
}
