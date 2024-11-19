package com.example.ExamenParcial.Controlador;

import com.example.ExamenParcial.Modelo.AlumnoModelo;
import com.example.ExamenParcial.Servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoControlador {

    @Autowired
    private AlumnoServicio servicio;

    @GetMapping
    public List<AlumnoModelo> listar() {
        try {
            return servicio.listarAlumnos();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los alumnos: " + e.getMessage());
        }
    }

    @PostMapping
    public AlumnoModelo agregar(@RequestBody AlumnoModelo alumno) {
        try {
            return servicio.guardarAlumno(alumno);
        } catch (Exception e) {
            throw new RuntimeException("Error al agregar el alumno: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public AlumnoModelo obtener(@PathVariable int id) {
        try {
            return servicio.obtenerAlumnoPorId(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el alumno con ID " + id + ": " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        try {
            servicio.eliminarAlumno(id);
            return "Alumno eliminado correctamente";
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el alumno con ID " + id + ": " + e.getMessage());
        }
    }
}
