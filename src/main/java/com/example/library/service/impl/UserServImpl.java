package com.example.library.service.impl;

import com.example.library.entity.User;
import com.example.library.repository.UserRepo;
import com.example.library.service.UserServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServImpl implements UserServIn, UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @Override
    public User findByIno(String ino) {
        return userRepo.findByIno(ino);
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Encoded password: " + user.getPassword());
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }


    @Override
    public List<User> findAllByUsernameOrIno(String username, String ino) {
        return userRepo.findAllByUsernameOrIno(username,ino);
    }



    @Override
    public User findById(long id) {
        return findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("User: " + user.getUsername() + " not found");
        }
        return user;
    }
}
