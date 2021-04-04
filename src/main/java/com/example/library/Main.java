package com.example.library;

import com.example.library.SpringConfig.Config;
import com.example.library.entity.Book;
import com.example.library.entity.Library;
import com.example.library.entity.User;
import com.example.library.repository.BookRepo;
import com.example.library.repository.UserRepo;
import com.example.library.service.BookServIn;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    static  Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Facade facade = new Facade();

        Library library;

        User user = facade.authUser();

        int p = 10000;

        while(p != 0){

            System.out.println("Options: ");
            System.out.println("1.Create Library");
            System.out.println("2.Create Book");
            System.out.println("3.Assign User to Library");
            System.out.println("4.Assign Book to Library");
            System.out.println("5.Assign Book To User");
            System.out.println("6.Show Library's Books and Users");

            p = in.nextInt();

            switch (p){
                case 1:
                    facade.createLibrary();
                    break;

                case 2:
                    facade.createBook();
                    break;

                case 3:
                    library = facade.findLibrary();
                    System.out.println("User: " + user.getUsername()
                    + " and founded library: " + library.getName() + library.getAddress());
                    facade.assignUserToLibrary(user, library);
                    break;

                case 4:
                    facade.assignBookToLibrary();
                    break;

                case 5:
                    facade.assignBookToUser(user);
                    break;

                case 6:
                    facade.showUsersOfLibrary();
                    break;

                case 7:
                    facade.showLibraryBooks();
                    break;

                case 0:
                    System.out.println("System.out");
                    return;
            }
        }

    }
}
