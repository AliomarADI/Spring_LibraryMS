package com.example.library.service.impl;

import com.example.library.entity.User;
import com.example.library.repository.UserRepo;
import com.example.library.service.UserServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServImpl implements UserServIn {

    @Autowired
    private UserRepo userRepo;


    @Override
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @Override
    public User findByIno(String ino) {
        return userRepo.findByIno(ino);
    }

    @Override
    public List<User> findAllByUsernameOrIno(String username, String ino) {
        return userRepo.findAllByUsernameOrIno(username,ino);
    }



    @Override
    public User findById(long id) {
        return findById(id);
    }
}
