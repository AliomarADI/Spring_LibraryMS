package com.example.library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;

    @Column(unique = true)
    String ino; // identifier number as ИИН

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    List<Book> books;

    @ManyToMany
    @JoinTable(name = "user_libraries",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "library_id", referencedColumnName = "id")})
    List<Library> libraries;


    public User() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIno() {
        return ino;
    }

    public void setIno(String ino) {
        this.ino = ino;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }
}
