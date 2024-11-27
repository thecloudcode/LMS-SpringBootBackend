package com.example.badal.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> authors;

    @ManyToMany
    @JoinTable(name = "books_categories",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
    private List<Category> categories;

    @ManyToMany
    @JoinTable(name = "books_publishers",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
    private List<Publisher> publishers;

    @ManyToOne
    @JoinColumn(name = "library_branch_id", nullable = false)
    private LibraryBranch libraryBranch;

    @ManyToMany
    @JoinTable(name = "books_borrowers",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "borrower_id")})
    private List<Borrower> borrowers;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public LibraryBranch getLibraryBranch() {
        return libraryBranch;
    }

    public void setLibraryBranch(LibraryBranch libraryBranch) {
        this.libraryBranch = libraryBranch;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }
}
