package org.example.gestionbiblioteca.model;

import lombok.*;
import org.example.gestionbiblioteca.enums.EstadoLibro;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    private Long id;
    private String isbn;
    private String titulo;
    private String autor;
    private EstadoLibro estado;
}