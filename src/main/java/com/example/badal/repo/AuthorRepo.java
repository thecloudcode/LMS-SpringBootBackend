package com.example.badal.repo;

import com.example.badal.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
