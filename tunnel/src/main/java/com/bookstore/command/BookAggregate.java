package com.bookstore.command;

import com.bookstore.database.BookWriteRepository;
import com.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;

public class BookAggregate {

    private final BookWriteRepository bookWriteRepository;

    @Autowired
    public BookAggregate(BookWriteRepository bookWriteRepository) {
        this.bookWriteRepository = bookWriteRepository;
    }

    public Book handleCreateBookCommand(CreateBookCommand command) {
        Book book = new Book(command.getBookId(), command.getName(), command.getReleaseDate(), command.getAuthorName(), command.getPrice(), command.getStock());
        bookWriteRepository.addBook(book.getId(), book);
        return book;
    }

    public Book handleUpdateBookCommand(UpdateBookStockCommand command) {
        Book book = bookWriteRepository.getBook(command.getBookId());
        book.setStock(command.getStock());
        bookWriteRepository.addBook(book.getId(), book);
        return book;
    }
}
