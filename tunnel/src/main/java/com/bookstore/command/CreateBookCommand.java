package com.bookstore.command;

public class CreateBookCommand {
    private String bookId;
    private String name;
    private String releaseDate;
    private String authorName;
    private String price;
    private int stock;

    public String getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
