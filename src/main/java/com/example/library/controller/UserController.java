package com.example.library.controller;

import com.example.library.entity.User;
import com.example.library.repository.UserRepo;
import com.example.library.service.UserServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userRepo.findById(id).get();
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }



}
