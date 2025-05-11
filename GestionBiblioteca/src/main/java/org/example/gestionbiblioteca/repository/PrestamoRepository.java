package org.example.gestionbiblioteca.repository;

import org.example.gestionbiblioteca.model.Prestamo;

import java.util.*;

public interface PrestamoRepository {
    Prestamo save(Prestamo prestamo);
    Optional<Prestamo> findById(Long id);
    List<Prestamo> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}