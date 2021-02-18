package com.bookstore.front.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author(@JsonProperty("id") Long id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
