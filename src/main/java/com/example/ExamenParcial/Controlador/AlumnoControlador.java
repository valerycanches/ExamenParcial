package com.example.ExamenParcial.Controlador;

import com.example.ExamenParcial.Modelo.AlumnoModelo;
import com.example.ExamenParcial.Servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoControlador {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoControlador.class);

    @Autowired
    private AlumnoServicio servicio;

    @GetMapping
    public List<AlumnoModelo> listar() {
        try {
            return servicio.listarAlumnos();
        } catch (Exception e) {
            logger.error("Error al listar los alumnos", e);
            throw new RuntimeException("Error al listar los alumnos: " + e.getMessage());
        }
    }

    @PostMapping
    public AlumnoModelo agregar(@RequestBody AlumnoModelo alumno) {
        try {
            return servicio.guardarAlumno(alumno);
        } catch (Exception e) {
            logger.error("Error al agregar el alumno", e);
            throw new RuntimeException("Error al agregar el alumno: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public AlumnoModelo obtener(@PathVariable int id) {
        try {
            return servicio.obtenerAlumnoPorId(id);
        } catch (Exception e) {
            logger.error("Error al obtener el alumno con ID {}", id, e);
            throw new RuntimeException("Error al obtener el alumno con ID " + id + ": " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public AlumnoModelo actualizar(@PathVariable int id, @RequestBody AlumnoModelo alumno) {
        try {
            AlumnoModelo existente = servicio.obtenerAlumnoPorId(id);
            if (existente == null) {
                logger.warn("Intento de actualizar un alumno inexistente con ID {}", id);
                throw new RuntimeException("No se encontró un alumno con ID " + id);
            }
            alumno.setId(id);
            return servicio.guardarAlumno(alumno);
        } catch (Exception e) {
            logger.error("Error al actualizar el alumno con ID {}", id, e);
            throw new RuntimeException("Error al actualizar el alumno con ID " + id + ": " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        try {
            servicio.eliminarAlumno(id);
            return "Alumno eliminado correctamente";
        } catch (Exception e) {
            logger.error("Error al eliminar el alumno con ID {}", id, e);
            throw new RuntimeException("Error al eliminar el alumno con ID " + id + ": " + e.getMessage());
        }
    }
}
