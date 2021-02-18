package com.bookstore.api.service;

import com.bookstore.api.entity.Author;
import com.bookstore.api.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getAllByAuthor(Author author);
    Optional<Book> getBookById(Long id);
    Book saveBook(Book b);
    void deleteBook(Book b);
}
