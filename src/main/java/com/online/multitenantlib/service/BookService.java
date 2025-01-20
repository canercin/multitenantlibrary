package com.online.multitenantlib.service;

import com.online.multitenantlib.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookByName(String name);
    Book addBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Book book);
}
