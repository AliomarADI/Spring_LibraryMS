package com.example.library.repository;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {


    @Override
    List<User> findAll();

    List<User> findAllByUsernameOrIno(String username, String ino);

    User findById(long id);

    User findByIno(String ino);

    User findByUsername(String username);


}
