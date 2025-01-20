package com.online.multitenantlib.service;

import com.online.multitenantlib.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> getAllAuthors();
    Optional<Author> getAuthorByName(String name);
    Author addAuthor(Author author);
    Author updateAuthor(Author author);
    void deleteAuthor(Author author);
}
