package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    @Override
    List<Book> findAll();

    List<Book> findAllByNameOrAuthor(String name, String author);

    Book findById(long id);

    List<Book> getBookByNameContainsOrGenreContains(String name,String genre);

    List<Book> getAllByUserId(Long id);

    List<Book> getAllByLibraryId(Long id);
}
