package com.example.badal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.example.badal.entity.Publisher;
import com.example.badal.repo.PublisherRepo;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepo PublisherRepo;
    public List<Publisher> getAllPublishers(){
        return PublisherRepo.findAll();
    }

    public Publisher getPublisherById(int id){
        return PublisherRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id is incorrect"));
    }

    public Publisher saveOrUpdatePublisher(Publisher Publisher){
        return PublisherRepo.save(Publisher);
    }

    public void deletePublisherById(int id){
        PublisherRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id is incorrect"));
        PublisherRepo.deleteById(id);
    }
}
