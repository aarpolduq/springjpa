package com.example.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class SpringjpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);

        CocheRepository repository = context.getBean(CocheRepository.class);

        Coche coche = new Coche();

        coche.setNombre("Toyota");

        repository.save(coche);

        System.out.println(repository.findAll());

    }

}
