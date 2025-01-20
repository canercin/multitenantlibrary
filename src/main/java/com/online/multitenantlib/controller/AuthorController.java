package com.online.multitenantlib.controller;

import com.online.multitenantlib.model.Author;
import com.online.multitenantlib.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return authorService.getAuthorByName(name).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> addAuthor(Author author) {
        authorService.addAuthor(author);
        return ResponseEntity.ok("Author added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateAuthor(Author author) {
        authorService.updateAuthor(author);
        return ResponseEntity.ok("Author updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAuthor(Author author) {
        authorService.deleteAuthor(author);
        return ResponseEntity.ok("Author deleted successfully");
    }
}
