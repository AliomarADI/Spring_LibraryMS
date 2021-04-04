package com.example.library.service;

import com.example.library.entity.Library;

import java.util.List;

public interface LibraryServIn {

    List<Library> findAllByNameOrAddress(String name, String address);

    Library findById(long id);
}
