package com.example.library.controller;

import com.example.library.entity.Book;
//import com.example.library.entity.User;
import com.example.library.service.BookServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServIn bookServIn;

    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookServIn.getAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Long id){
        return bookServIn.findById(id);
    }

    @GetMapping("/find")
    public List<Book> getBookByNameAndGenre(@RequestParam("name") String name,
                                            @RequestParam("genre") String genre){
        return bookServIn.findAllByNameOrAuthorAnd(name,genre);
    }

    @GetMapping("/user/{id}")
    public List<Book> getAllBooks(@PathVariable("id") Long userId){
        return bookServIn.findAllByUserId(userId);
    }

    @GetMapping("/library/{id}")
    public List<Book> getBookOfLibraries(@PathVariable("id") Long libraryId){
        return bookServIn.findAllByLibrary(libraryId);
    }

    @PostMapping("")
    public Book createBook(@RequestBody Book book){
        return bookServIn.create(book);
    }

    @PatchMapping("/assignBookToUser")
    public Book updateAssignBookToUser(@RequestParam Long id,
                                       @RequestParam Long userID){
        return bookServIn.assignBookToUser(id,userID);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookServIn.delete(id);
    }
    @PatchMapping
    public Book updateAssignBookToLibrary(@RequestParam Long id,
                                          @RequestParam Long libID){
        return  bookServIn.assignBookToLibrary(id,libID);
    }
}
