package com.example.badal.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.badal.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.badal.entity.Book;
import com.example.badal.service.BookService;

@RestController
@RequestMapping("/api/Books")
public class BookController {

    @Autowired
    private BookService BookService;

    // Get all Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> Books = BookService.getAllBooks();
        return ResponseEntity.ok(Books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        Book Book = BookService.getBookById(id);
        if (Book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Book);
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book Book) {
        Book createdBook = BookService.saveOrUpdateBook(Book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book Book) {
        Book existingBook = BookService.getBookById(id);
        if (existingBook == null) {
            return ResponseEntity.notFound().build();
        }
        Book.setId(id);
        BookService.saveOrUpdateBook(Book);
        return ResponseEntity.ok(Book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        Book Book = BookService.getBookById(id);
        if (Book == null) {
            return ResponseEntity.notFound().build();
        }
        BookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
