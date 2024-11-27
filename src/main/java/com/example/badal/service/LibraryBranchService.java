package com.example.badal.service;

import com.example.badal.entity.LibraryBranch;
import com.example.badal.repo.LibraryBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryBranchService {
    @Autowired
    private LibraryBranchRepo libraryBranchRepo;

    public List<LibraryBranch> getAllLibraryBranches() {
        return libraryBranchRepo.findAll();
    }

    public LibraryBranch getLibraryBranchById(int id) {
        return libraryBranchRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Library Branch not found for id: " + id));
    }

    public LibraryBranch saveOrUpdateLibraryBranch(LibraryBranch libraryBranch) {
        return libraryBranchRepo.save(libraryBranch);
    }

    public void deleteLibraryBranchById(int id) {
        if (!libraryBranchRepo.existsById(id)) {
            throw new RuntimeException("Library Branch not found for id: " + id);
        }
        libraryBranchRepo.deleteById(id);
    }
}
