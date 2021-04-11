package com.example.library.controller;

import com.example.library.entity.Book;
//import com.example.library.entity.User;
import com.example.library.repository.BookRepo;
import com.example.library.service.impl.BookServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Long id){
        return bookRepo.findById(id).get();
    }

    @GetMapping("/find")
    public List<Book> getBookByNameAndGenre(@RequestParam("name") String name,
                                            @RequestParam("genre") String genre){
        return bookRepo.getBookByNameContainsOrGenreContains(name,genre);
    }

    @GetMapping("/user/{id}")
    public List<Book> getAllBooks(@PathVariable("id") Long userId){
        return bookRepo.getAllByUserId(userId);
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book){
        return bookRepo.save(book);
    }

    @PatchMapping("/assignBookToUser")
    public Book updateAssignBookToUser(@RequestParam Long id,
                                       @RequestParam Long userID){
        Book book = bookRepo.findById(id).get();
        book.setUserId(userID);
        return bookRepo.saveAndFlush(book);
    }

    @PatchMapping
    public Book updateAssignBookToLibrary(@RequestParam Long id,
                                          @RequestParam Long libID){
        Book book = bookRepo.findById(id).get();
        book.setLibraryId(libID);
        return bookRepo.save(book);
    }
}
