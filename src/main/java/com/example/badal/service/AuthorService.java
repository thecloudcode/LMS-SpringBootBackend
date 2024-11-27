package com.example.badal.service;

import com.example.badal.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.example.badal.entity.Author;
import com.example.badal.repo.AuthorRepo;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    public List<Author> getAllAuthors(){
        return authorRepo.findAll();
    }

    public Author getAuthorById(int id){
        return authorRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id is incorrect"));
    }

    public Author saveOrUpdateAuthor(Author author){
        return authorRepo.save(author);
    }

    public void deleteAuthorById(int id){
        authorRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id is incorrect"));
        authorRepo.deleteById(id);
    }
}
