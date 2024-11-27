package com.example.badal.controller;

import com.example.badal.entity.Borrower;
import com.example.badal.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping
    public ResponseEntity<List<Borrower>> getAllBorrowers() {
        List<Borrower> borrowers = borrowerService.getAllBorrowers();
        return ResponseEntity.ok(borrowers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrower> getBorrowerById(@PathVariable int id) {
        Borrower borrower = borrowerService.getBorrowerById(id);
        return ResponseEntity.ok(borrower);
    }

    @PostMapping
    public ResponseEntity<Borrower> createBorrower(@RequestBody Borrower borrower) {
        Borrower createdBorrower = borrowerService.saveOrUpdateBorrower(borrower);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBorrower);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrower> updateBorrower(@PathVariable int id, @RequestBody Borrower borrower) {
        Borrower existingBorrower = borrowerService.getBorrowerById(id);
        borrower.setId(id);
        Borrower updatedBorrower = borrowerService.saveOrUpdateBorrower(borrower);
        return ResponseEntity.ok(updatedBorrower);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrower(@PathVariable int id) {
        borrowerService.deleteBorrowerById(id);
        return ResponseEntity.noContent().build();
    }
}
