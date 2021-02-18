package com.bookstore.command;

public class UpdateBookStockCommand {
    private String bookId;
    private int stock;

    public String getBookId() {
        return bookId;
    }

    public int getStock() {
        return stock;
    }
}
