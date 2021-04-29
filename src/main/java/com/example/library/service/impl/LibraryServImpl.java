package com.example.library.service.impl;

import com.example.library.entity.Library;
import com.example.library.repository.LibraryRepo;
import com.example.library.service.LibraryServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServImpl implements LibraryServIn {

    @Autowired
    private LibraryRepo libraryRepo;

    @Override
    public Library create(Library library) {
        return libraryRepo.save(library);
    }

    @Override
    public Library update(Library library) {
        return libraryRepo.save(library);
    }

    @Override
    public void delete(Long id) {
        libraryRepo.delete(libraryRepo.findById(id).get());
    }

    @Override
    public List<Library> getAll() {
        return libraryRepo.findAll();
    }

    @Override
    public List<Library> findAllByNameOrAddress(String name, String address) {
        return libraryRepo.findAllByNameOrAddress(name, address);
    }

    @Override
    public Library findById(long id) {
        return libraryRepo.findById(id);
    }
}
