package com.example.library.service;

import com.example.library.entity.User;

import java.util.List;

public interface UserServIn {

    List<User> findAllByUsernameOrIno(String username, String ino);

    User findById(long id);

    List<User> getAllUsers();

    User findByIno(String ino);
}
