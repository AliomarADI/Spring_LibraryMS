package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookServIn {

    List<Book> findAllByNameOrAuthorAnd(String name, String author);

    Book findById(long id);

    Book save(Book book);

}
