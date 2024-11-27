package com.example.badal.service;

import com.example.badal.entity.Borrower;
import com.example.badal.repo.BorrowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerService {
    @Autowired
    private BorrowerRepo borrowerRepo;

    public List<Borrower> getAllBorrowers() {
        return borrowerRepo.findAll();
    }

    public Borrower getBorrowerById(int id) {
        return borrowerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrower not found for id: " + id));
    }

    public Borrower saveOrUpdateBorrower(Borrower borrower) {
        return borrowerRepo.save(borrower);
    }

    public void deleteBorrowerById(int id) {
        if (!borrowerRepo.existsById(id)) {
            throw new RuntimeException("Borrower not found for id: " + id);
        }
        borrowerRepo.deleteById(id);
    }
}
