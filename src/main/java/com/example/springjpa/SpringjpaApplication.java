package com.example.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);

        LibraryRepository repository = context.getBean(LibraryRepository.class);

        Library library = new Library(1L, "Libreria 1");
        Library library2 = new Library(2L, "Libreria 2");

        Book book = new Book(null,"Quijote",739,"Cervantes", 19.99);

        library.getBooks().add(book);
        library2.getBooks().add(book);

        repository.save(library);

        System.out.println(repository.findAll());

        repository.save(library2);

        System.out.println(repository.findAll());

    }

}
