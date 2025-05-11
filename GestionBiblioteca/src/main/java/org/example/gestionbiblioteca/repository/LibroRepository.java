package org.example.gestionbiblioteca.repository;

import org.example.gestionbiblioteca.model.Libro;

import java.util.*;

public interface LibroRepository {
    Libro save(Libro libro);
    Optional<Libro> findById(Long id);
    Optional<Libro> findByIsbn(String isbn);
    List<Libro> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}