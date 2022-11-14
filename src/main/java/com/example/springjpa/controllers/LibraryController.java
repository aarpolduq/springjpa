package com.example.springjpa.controllers;

import com.example.springjpa.models.Library;
import com.example.springjpa.repositories.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {

    private LibraryRepository libraryRepository;

    public LibraryController(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    // CRUD sobre la entidad library

    // Buscar todas las library
    @GetMapping("/api/libraries")
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    // Buscar una sola library segun su id
    @GetMapping("/api/libraries/{id}")
    public ResponseEntity<Library> findById(@PathVariable Long id) {

        Optional<Library> libraryOpt = libraryRepository.findById(id);

        return libraryOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

/*
        if(libraryOpt.isPresent()) {
            return ResponseEntity.ok(libraryOpt.get());
        }else {
            return ResponseEntity.notFound().build();
        }

 */


    }


    // Create a new library

    @PostMapping("/api/libraries")
    public Library create(@RequestBody Library library) {
        return libraryRepository.save(library);
    }

    // Actualizar una library

    // Borrar una library


}