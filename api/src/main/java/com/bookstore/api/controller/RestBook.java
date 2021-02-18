package com.bookstore.api.controller;

import com.bookstore.api.entity.Author;
import com.bookstore.api.entity.Book;
import com.bookstore.api.service.impl.AuthorServiceImpl;
import com.bookstore.api.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
public class RestBook {

    private final BookServiceImpl bookService;
    private final AuthorServiceImpl authorService;

    @Autowired
    private RestBook(BookServiceImpl bookService, AuthorServiceImpl authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping(value = "/book/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addBook(@RequestBody Book book) {
        Optional<Author> author;

        author = authorService.getAuthorByName(book.getAuthor().getName());

        if (!author.isPresent()) {
            authorService.saveAuthor(new Author(book.getAuthor().getName()));
            author = authorService.getAuthorByName(book.getAuthor().getName());
        }

        // Safe to do, since we either fetch it from DB, or save it then fetch it from DB
        book.setAuthor(author.get());

        bookService.saveBook(book);

        return HttpStatus.OK;
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBookById(@PathVariable Long id) {
        System.out.println("Id in API : " + id);
        Optional<Book> book = bookService.getBookById(id);
        return book.orElse(null);
    }

    @GetMapping(value = "/book/author", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBookByAuthor(@RequestBody Author author) {
        Optional<Author> authorFromDb = authorService.getAuthorByName(author.getName());
        List<Book> bookList = new ArrayList<>();

        if (authorFromDb.isPresent()) {
            bookList = bookService.getAllByAuthor(authorFromDb.get());
        }

        return bookList;
    }
}
