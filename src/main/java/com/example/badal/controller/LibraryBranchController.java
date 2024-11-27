package com.example.badal.controller;

import com.example.badal.entity.LibraryBranch;
import com.example.badal.service.LibraryBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library-branches")
public class LibraryBranchController {

    @Autowired
    private LibraryBranchService libraryBranchService;

    @GetMapping
    public ResponseEntity<List<LibraryBranch>> getAllLibraryBranches() {
        List<LibraryBranch> libraryBranches = libraryBranchService.getAllLibraryBranches();
        return ResponseEntity.ok(libraryBranches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryBranch> getLibraryBranchById(@PathVariable int id) {
        LibraryBranch libraryBranch = libraryBranchService.getLibraryBranchById(id);
        return ResponseEntity.ok(libraryBranch);
    }

    @PostMapping
    public ResponseEntity<LibraryBranch> createLibraryBranch(@RequestBody LibraryBranch libraryBranch) {
        LibraryBranch createdBranch = libraryBranchService.saveOrUpdateLibraryBranch(libraryBranch);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBranch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryBranch> updateLibraryBranch(@PathVariable int id, @RequestBody LibraryBranch libraryBranch) {
        LibraryBranch existingBranch = libraryBranchService.getLibraryBranchById(id);
        libraryBranch.setId(id);
        LibraryBranch updatedBranch = libraryBranchService.saveOrUpdateLibraryBranch(libraryBranch);
        return ResponseEntity.ok(updatedBranch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryBranch(@PathVariable int id) {
        libraryBranchService.deleteLibraryBranchById(id);
        return ResponseEntity.noContent().build();
    }
}
