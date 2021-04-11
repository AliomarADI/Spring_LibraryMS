package com.example.library.controller;

import com.example.library.entity.Library;
import com.example.library.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    LibraryRepo libraryRepo;

    @GetMapping("")
    public List<Library> getAllLibraries(){
        return libraryRepo.findAll();
    }

    @GetMapping("/{id}")
    public Library getById(@PathVariable Long id){
        return libraryRepo.findById(id).get();
    }

    @PostMapping("")
    public Library createLibrary(@RequestBody Library library){
        return libraryRepo.save(library);
    }
}
