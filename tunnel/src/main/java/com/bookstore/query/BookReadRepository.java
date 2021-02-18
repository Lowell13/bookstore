package com.bookstore.query;

import java.util.HashMap;
import java.util.Map;

public class BookReadRepository {
    private Map<String, BookList> bookList = new HashMap<>();
    private Map<String, BookPrice> bookPrice = new HashMap<>();

    public BookPrice getBookPrice(String id) {
        return new BookPrice();
    }

    public BookList getBookList(String id) {
        return new BookList();
    }
}
