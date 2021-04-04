package com.example.library.service.impl;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepo;
import com.example.library.service.BookServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServImpl implements BookServIn {

    @Autowired
    private BookRepo bookRepo;


    @Override
    public List<Book> findAllByNameOrAuthorAnd(String name, String author) {
        return bookRepo.findAllByNameOrAuthor(name,author);
    }

    @Override
    public Book findById(long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }


}
