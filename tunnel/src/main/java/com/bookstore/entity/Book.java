package com.bookstore.entity;

public class Book {

    private String id;
    private String name;
    private String releaseDate;
    private String authorName;
    private String price;
    private int stock;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Book() {

    }

    public Book(String id, String name, String releaseDate, String authorName, String price, int stock) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.authorName = authorName;
        this.price = price;
        this.stock = stock;
    }
}
