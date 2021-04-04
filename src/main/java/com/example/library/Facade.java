package com.example.library;

import com.example.library.SpringConfig.Config;
import com.example.library.entity.Book;
import com.example.library.entity.Library;
import com.example.library.entity.User;
import com.example.library.repository.BookRepo;
import com.example.library.repository.LibraryRepo;
import com.example.library.repository.UserRepo;
import com.example.library.service.BookServIn;
import com.example.library.service.impl.BookServImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;
import java.util.Scanner;

public class Facade {
    static Scanner in = new Scanner(System.in);

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    public UserRepo getUserRepo(){
        return context.getBean("userRepo",UserRepo.class);
    }

    public LibraryRepo getLibraryRepo(){
        return context.getBean("libraryRepo", LibraryRepo.class);
    }

    public BookRepo getBookRepo(){
        return context.getBean("bookRepo", BookRepo.class);
    }


    public void createBook(){
        System.out.println("Please enter name of book:");
        String name = in.nextLine();
        System.out.println("Please enter genre:");
        String genre = in.nextLine();
        System.out.println("PLease enter name of author:");
        String author = in.nextLine();

        Book book = new Book();

        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);

        BookRepo bookRepo = getBookRepo();

        bookRepo.save(book);

        System.out.println("Book saved!");
    }

    public void createLibrary(){
        System.out.println("Please enter name: ");
        String name = in.nextLine();
        System.out.println("Please enter address: ");
        String address = in.nextLine();

        Library lib = new Library();

        lib.setName(name);
        lib.setAddress(address);

        LibraryRepo libraryRepo = getLibraryRepo();

        libraryRepo.save(lib);

        System.out.println("Library saved!");
    }

    public User authUser(){


        System.out.println("Enter username: ");
        String username = in.nextLine();
        System.out.println("Enter ino");
        String ino = in.nextLine();

        UserRepo userRepo = getUserRepo();

        if (userRepo.findByIno(ino) == null){
            User user = new User();

            user.setUsername(username);
            user.setIno(ino);

            userRepo.save(user);

            System.out.println("Welcome . We are happy to see you");
            return user;
        }else{
            User user = userRepo.findByIno(ino);

            System.out.println(user.getUsername() + " - We are glad to see you again");
            return user;
        }

    }

    public void assignUserToLibrary(User user, Library library){

        if (library != null){

            LibraryRepo libraryRepo = getLibraryRepo();
            UserRepo userRepo = getUserRepo();

            library.getUsers().add(user);
            user.getLibraries().add(library);

            userRepo.save(user);
            libraryRepo.save(library);
            System.out.println("User assigned to Library");
        }else{
            System.out.println("Library NOT FOUND, Sorry");
        }
    }

    public void assignBookToLibrary(){
        BookRepo bookRepo = getBookRepo();
        LibraryRepo libraryRepo = getLibraryRepo();

        System.out.println("Enter id of Book: ");
        Long idOfBook = in.nextLong();

        System.out.println("Enter id of Library: ");
        Long idOfLib = in.nextLong();

        Library library = libraryRepo.findById(idOfLib).get();
        Book book = bookRepo.findById(idOfBook).get();

        if (library != null && book != null){

            library.getBooks().add(book);
            book.setLibrary(library);

            libraryRepo.save(library);
            bookRepo.save(book);

            System.out.println("Book assigned to library");
        }else{
            System.out.println("Error: Book or Library is null");
        }
    }

    public void assignBookToUser(User user){
        BookRepo bookRepo = getBookRepo();
        UserRepo userRepo = getUserRepo();

        System.out.println("Enter id of book: ");
        Long idOfBook = in.nextLong();

        Book book = bookRepo.findById(idOfBook).get();

        if (book != null){
            user.getBooks().add(book);
            book.setUser(user);
            book.setBooked(true);

            userRepo.save(user);
            bookRepo.save(book);

            System.out.println("Book assigned to user");
        }else{
            System.out.println("Error: Book can be null");
        }
    }

    public Library findLibrary(){
        LibraryRepo libraryRepo = getLibraryRepo();

        System.out.println("Enter name or Address of Library: ");
        String findWord = in.nextLine();

        Library library = libraryRepo.findByNameOrAddress(findWord,findWord);

        return library;
    }

    public void showUsersOfLibrary(){
        LibraryRepo libraryRepo = getLibraryRepo();

        for (Library l: libraryRepo.findAll()){
            for (User u: libraryRepo.findById(l.getId()).get().getUsers()){

                System.out.println("Library[" + l.getName() + "]: " + u.getUsername() +" his books<Boolean>: "
                        + u.getBooks().isEmpty());
            }
        }
    }

    public void showLibraryBooks(){
        LibraryRepo libraryRepo = getLibraryRepo();

        for (Library l: libraryRepo.findAll()){
            System.out.println("Library[" + l.getName() + "]: " + l.getBooks().toString());
        }
    }
}
