package com.bookstore.front.service;

import com.bookstore.front.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService {

    private final List<Book> bookList;

    public ShoppingCartService() {
        this.bookList = new ArrayList<>();
    }

    public void addBookToCart(Book book) {
        this.bookList.add(book);
    }

    public float getTotalPrice() {
        float price = 0.0F;

        for (Book b: bookList) {
            price += Float.parseFloat(b.getPrice());
        }

        return price;
    }

    public List<Book> getBookList() {
        return this.bookList;
    }
}
