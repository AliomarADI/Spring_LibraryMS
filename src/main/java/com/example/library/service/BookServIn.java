package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookServIn {

    Book create(Book book);
    Book update(Book book);
    void delete(Long id);
    List<Book> getAll();
    List<Book> findAllByNameOrAuthorAnd(String name, String author);
    List<Book> findAllByUserId(Long id);
    List<Book> findAllByLibrary(Long id);

    Book findById(long id);

    Book assignBookToUser(Long bookId, Long userId);

    Book assignBookToLibrary(Long bookId, Long libraryId);
}
