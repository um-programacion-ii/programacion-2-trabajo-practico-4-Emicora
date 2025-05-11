package org.example.gestionbiblioteca.repositoryTests;

import org.example.gestionbiblioteca.enums.EstadoLibro;
import org.example.gestionbiblioteca.model.Libro;
import org.example.gestionbiblioteca.model.Prestamo;
import org.example.gestionbiblioteca.model.Usuario;
import org.example.gestionbiblioteca.repository.impl.PrestamoRepositoryImpl;
import org.junit.jupiter.api.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PrestamoRepositoryImplTest {

    private PrestamoRepositoryImpl repo;
    private Libro libroSample;
    private Usuario usuarioSample;

    @BeforeEach
    void setUp() {
        repo = new PrestamoRepositoryImpl();
        libroSample   = new Libro(null, "L-1", "T", "A", EstadoLibro.DISPONIBLE);
        usuarioSample = new Usuario(null, "U", "u@mail", "ACTIVO");
    }

    @Test
    void save_yFindById() {
        Prestamo p = new Prestamo(null, libroSample, usuarioSample,
                LocalDate.now(), LocalDate.now().plusDays(1));
        Prestamo guardado = repo.save(p);

        assertNotNull(guardado.getId());
        assertTrue(repo.findById(guardado.getId()).isPresent());
    }

    @Test
    void findAll_devuelveLista() {
        repo.save(new Prestamo(null, libroSample, usuarioSample,
                LocalDate.now(), LocalDate.now().plusDays(1)));
        assertFalse(repo.findAll().isEmpty());
    }

    @Test
    void deleteById_eliminaElemento() {
        Prestamo p = repo.save(new Prestamo(null, libroSample, usuarioSample,
                LocalDate.now(), LocalDate.now().plusDays(1)));
        repo.deleteById(p.getId());
        assertFalse(repo.existsById(p.getId()));
    }
}