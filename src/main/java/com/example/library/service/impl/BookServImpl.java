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
    public Book create(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepo.delete(bookRepo.findById(id).get());
    }

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> findAllByNameOrAuthorAnd(String name, String author) {
        return bookRepo.findAllByNameOrAuthor(name,author);
    }

    @Override
    public List<Book> findAllByUserId(Long id) {
        return bookRepo.getAllByUserId(id);
    }

    @Override
    public List<Book> findAllByLibrary(Long id) {
        return bookRepo.getAllByLibraryId(id);
    }

    @Override
    public Book findById(long id) {
        return bookRepo.findById(id);
    }

    @Override
    public Book assignBookToUser(Long bookId, Long userId){
        Book book= bookRepo.findById(bookId).get();
        book.setUserId(userId);
        bookRepo.save(book);
        return book;
    }

    @Override
    public Book assignBookToLibrary(Long bookId,Long libraryId){
        Book book= bookRepo.findById(bookId).get();
        book.setLibraryId(libraryId);
        bookRepo.save(book);
        return book;
    }

}
