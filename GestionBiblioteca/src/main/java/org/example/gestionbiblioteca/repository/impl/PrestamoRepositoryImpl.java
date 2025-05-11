package org.example.gestionbiblioteca.repository.impl;

import org.example.gestionbiblioteca.model.Prestamo;
import org.example.gestionbiblioteca.repository.PrestamoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PrestamoRepositoryImpl implements PrestamoRepository {
    private final Map<Long, Prestamo> storage = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public Prestamo save(Prestamo prestamo) {
        if (prestamo.getId() == null) {
            prestamo.setId(nextId++);
        }
        storage.put(prestamo.getId(), prestamo);
        return prestamo;
    }

    @Override
    public Optional<Prestamo> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Prestamo> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }
}