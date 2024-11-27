package com.example.badal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.example.badal.entity.Book;
import com.example.badal.repo.BookRepo;

@Service
public class BookService {
    @Autowired
    private BookRepo BookRepo;
    public List<Book> getAllBooks(){
        return BookRepo.findAll();
    }

    public Book getBookById(int id){
        return BookRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id is incorrect"));
    }

    public Book saveOrUpdateBook(Book Book){
        return BookRepo.save(Book);
    }

    public void deleteBookById(int id){
        BookRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id is incorrect"));
        BookRepo.deleteById(id);
    }
}
