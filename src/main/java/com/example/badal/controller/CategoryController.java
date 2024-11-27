package com.example.badal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.badal.entity.Category;
import com.example.badal.service.CategoryService;

@RestController
@RequestMapping("/api/Categorys")
public class CategoryController {

    @Autowired
    private CategoryService CategoryService;

    // Get all Categorys
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategorys() {
        List<Category> Categorys = CategoryService.getAllCategorys();
        return ResponseEntity.ok(Categorys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        Category Category = CategoryService.getCategoryById(id);
        if (Category == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Category);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category Category) {
        Category createdCategory = CategoryService.saveOrUpdateCategory(Category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category Category) {
        Category existingCategory = CategoryService.getCategoryById(id);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }
        Category.setId(id);
        CategoryService.saveOrUpdateCategory(Category);
        return ResponseEntity.ok(Category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        Category Category = CategoryService.getCategoryById(id);
        if (Category == null) {
            return ResponseEntity.notFound().build();
        }
        CategoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
