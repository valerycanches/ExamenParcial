package com.example.ExamenParcial.Repositorio;

import com.example.ExamenParcial.Modelo.AlumnoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepositorio extends JpaRepository<AlumnoModelo, Integer> {
}
