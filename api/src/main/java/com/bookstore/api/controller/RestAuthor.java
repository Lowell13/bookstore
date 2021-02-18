package com.bookstore.api.controller;

import com.bookstore.api.entity.Author;
import com.bookstore.api.service.AuthorService;
import com.bookstore.api.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestAuthor {

    private final AuthorService authorService;

    @Autowired
    private RestAuthor(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "/author/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus addAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return HttpStatus.OK;
    }

    @GetMapping(value = "/author")
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }
}
