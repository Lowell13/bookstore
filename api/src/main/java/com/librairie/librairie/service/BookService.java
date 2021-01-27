package com.librairie.librairie.service;

import com.librairie.librairie.entity.Author;
import com.librairie.librairie.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getAllByAuthor(Author author);
    Optional<Book> getBookById(Long id);
    Book saveBook(Book b);
    void deleteBook(Book b);
}
