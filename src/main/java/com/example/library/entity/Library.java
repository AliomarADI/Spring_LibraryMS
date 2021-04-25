package com.example.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "libraries")
@Data
@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @JsonIgnore
    @ManyToMany(mappedBy = "libraries")
    private List<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "library")
    private List<Book> books;


}
