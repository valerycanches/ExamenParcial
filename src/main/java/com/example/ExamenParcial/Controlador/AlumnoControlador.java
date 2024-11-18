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
        return servicio.listarAlumnos();
    }

    @PostMapping
    public AlumnoModelo agregar(@RequestBody AlumnoModelo alumno) {
        return servicio.guardarAlumno(alumno);
    }

    @GetMapping("/{id}")
    public AlumnoModelo obtener(@PathVariable int id) {
        return servicio.obtenerAlumnoPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        servicio.eliminarAlumno(id);
        return "Alumno eliminado correctamente";
    }
}
