package com.bookstore.query;

import com.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookProjection {

    private BookReadRepository bookReadRepository;

    @Autowired
    public BookProjection(BookReadRepository bookReadRepository) {
        this.bookReadRepository = bookReadRepository;
    }

    public int handle(PriceByBook query) {
        BookPrice bookPrice = bookReadRepository.getBookPrice(query.getBook_id());

    }

    public List<Book> handle (BookByAuthor query) {
        BookList bookList = bookReadRepository.getBookList(query.getAuthorName());
    }
}
