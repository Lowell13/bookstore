package com.bookstore.command;

import com.bookstore.database.AuthorWriteRepository;
import com.bookstore.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorAggregate {
    private final AuthorWriteRepository authorWriteRepository;

    @Autowired
    public AuthorAggregate(AuthorWriteRepository authorWriteRepository) {
        this.authorWriteRepository = authorWriteRepository;
    }

    public Author handleCreateAuthorCommand(CreateAuthorCommand command) {
        Author author = new Author(command.getAuthorId(), command.getName());
        authorWriteRepository.addAuthor(author.getId(), author);
        return author;
    }
}
