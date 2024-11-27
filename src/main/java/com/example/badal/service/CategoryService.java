package com.example.badal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.example.badal.entity.Category;
import com.example.badal.repo.CategoryRepo;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo CategoryRepo;
    public List<Category> getAllCategorys(){
        return CategoryRepo.findAll();
    }

    public Category getCategoryById(int id){
        return CategoryRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id is incorrect"));
    }

    public Category saveOrUpdateCategory(Category Category){
        return CategoryRepo.save(Category);
    }

    public void deleteCategoryById(int id){
        CategoryRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id is incorrect"));
        CategoryRepo.deleteById(id);
    }
}
