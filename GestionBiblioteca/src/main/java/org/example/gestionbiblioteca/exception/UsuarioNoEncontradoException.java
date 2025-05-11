package org.example.gestionbiblioteca.exception;


public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(Long id) {
        super("Usuario no encontrado con id: " + id);
    }
}