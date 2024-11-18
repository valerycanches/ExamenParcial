package com.example.ExamenParcial.Controlador;

import com.example.ExamenParcial.Modelo.AlumnoModelo;
import com.example.ExamenParcial.Servicio.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos") // link para encontrar proyecto
public class AlumnoControlador {

    @Autowired
    private AlumnoServicio servicio;

    @GetMapping
    public ResponseEntity<List<AlumnoModelo>> listar() {
        try {
            List<AlumnoModelo> alumnos = servicio.listarAlumnos();
            return ResponseEntity.ok(alumnos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<AlumnoModelo> agregar(@RequestBody AlumnoModelo alumno) {
        try {
            AlumnoModelo nuevoAlumno = servicio.guardarAlumno(alumno);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAlumno);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoModelo> obtener(@PathVariable int id) {
        try {
            AlumnoModelo alumno = servicio.obtenerAlumnoPorId(id);
            if (alumno != null) {
                return ResponseEntity.ok(alumno);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoModelo> actualizarAlumno(@PathVariable int id, @RequestBody AlumnoModelo alumnoActualizado) {
        try {
            AlumnoModelo alumno = servicio.actualizarAlumno(id, alumnoActualizado);
            if (alumno != null) {
                return ResponseEntity.ok(alumno);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        try {
            servicio.eliminarAlumno(id);
            return ResponseEntity.ok("Alumno eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el alumno");
        }
    }
}
