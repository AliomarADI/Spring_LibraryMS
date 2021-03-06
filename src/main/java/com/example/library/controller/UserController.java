package com.example.library.controller;

import com.example.library.entity.User;
import com.example.library.repository.UserRepo;
import com.example.library.service.UserServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServIn userServIn;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userServIn.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userServIn.findById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return userServIn.create(user);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
