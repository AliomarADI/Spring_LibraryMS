package com.example.library.service;

import com.example.library.entity.Library;

import java.util.List;

public interface LibraryServIn {

    Library create(Library library);
    Library update(Library library);
    void delete(Long id);
    List<Library> getAll();
    List<Library> findAllByNameOrAddress(String name, String address);

    Library findById(long id);
}
