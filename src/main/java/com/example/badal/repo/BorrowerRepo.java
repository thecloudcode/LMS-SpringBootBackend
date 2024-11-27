package com.example.badal.repo;

import com.example.badal.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepo extends JpaRepository<Borrower, Integer> {

}
