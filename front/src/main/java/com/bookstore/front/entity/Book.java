package com.bookstore.front.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    private Long id;
    private String name;
    private String releaseDate;
    private Author author;
    private String price;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Book(@JsonProperty("id") Long id,
                @JsonProperty("name") String name,
                @JsonProperty("releaseDate") String releaseDate,
                @JsonProperty("author") Author author,
                @JsonProperty("price") String price) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.author = author;
        this.price = price;
    }

    public Book() {}
}
