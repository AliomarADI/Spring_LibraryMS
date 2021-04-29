package com.example.library.controller;

import com.example.library.entity.Library;
import com.example.library.service.LibraryServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryServIn libraryServIn;

    @GetMapping("")
    public List<Library> getAllLibraries(){
        return libraryServIn.getAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        libraryServIn.delete(id);
    }

    @GetMapping("/{id}")
    public Library getById(@PathVariable Long id){
        return libraryServIn.findById(id);
    }

    @PostMapping("/create")
    public Library createLibrary(@RequestBody Library library){
        return libraryServIn.create(library);
    }
}
