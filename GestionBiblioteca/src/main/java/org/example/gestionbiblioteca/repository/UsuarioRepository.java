package org.example.gestionbiblioteca.repository;

import org.example.gestionbiblioteca.model.Usuario;

import java.util.*;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    List<Usuario> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}