package com.online.multitenantlib.controller;

import com.online.multitenantlib.model.Publisher;
import com.online.multitenantlib.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/publisher") public class PublisherController {
    private PublisherService publisherService;

    @GetMapping
    public List<Publisher> getPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{name}")
    public Publisher getPublisherByName(@PathVariable String name) {
        return publisherService.getPublisherByName(name).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> addPublisher(Publisher publisher) {
        publisherService.addPublisher(publisher);
        return ResponseEntity.ok("Publisher added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updatePublisher(Publisher publisher) {
        publisherService.updatePublisher(publisher);
        return ResponseEntity.ok("Publisher updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deletePublisher(Publisher publisher) {
        publisherService.deletePublisher(publisher);
        return ResponseEntity.ok("Publisher deleted successfully");
    }
}
