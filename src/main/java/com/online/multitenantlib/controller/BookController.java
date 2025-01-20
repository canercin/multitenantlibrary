package com.online.multitenantlib.controller;

import com.online.multitenantlib.model.Book;
import com.online.multitenantlib.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{name}")
    public Book getBookByName(@PathVariable String name) {
        return bookService.getBookByName(name).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> addBook(Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateBook(Book book) {
        bookService.updateBook(book);
        return ResponseEntity.ok("Book updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(Book book) {
        bookService.deleteBook(book);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
