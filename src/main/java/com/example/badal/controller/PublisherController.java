package com.example.badal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.badal.entity.Publisher;
import com.example.badal.service.PublisherService;

@RestController
@RequestMapping("/api/Publishers")
public class PublisherController {

    @Autowired
    private PublisherService PublisherService;

    // Get all Publishers
    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> Publishers = PublisherService.getAllPublishers();
        return ResponseEntity.ok(Publishers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable int id) {
        Publisher Publisher = PublisherService.getPublisherById(id);
        if (Publisher == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Publisher);
    }

    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher Publisher) {
        Publisher createdPublisher = PublisherService.saveOrUpdatePublisher(Publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher Publisher) {
        Publisher existingPublisher = PublisherService.getPublisherById(id);
        if (existingPublisher == null) {
            return ResponseEntity.notFound().build();
        }
        Publisher.setId(id);
        PublisherService.saveOrUpdatePublisher(Publisher);
        return ResponseEntity.ok(Publisher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable int id) {
        Publisher Publisher = PublisherService.getPublisherById(id);
        if (Publisher == null) {
            return ResponseEntity.notFound().build();
        }
        PublisherService.deletePublisherById(id);
        return ResponseEntity.noContent().build();
    }
}
