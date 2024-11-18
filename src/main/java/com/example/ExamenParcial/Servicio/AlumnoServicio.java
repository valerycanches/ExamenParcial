package com.example.ExamenParcial.Servicio;

import com.example.ExamenParcial.Modelo.AlumnoModelo;
import com.example.ExamenParcial.Repositorio.AlumnoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServicio {
    @Autowired
    private AlumnoRepositorio repositorio;

    public List<AlumnoModelo> listarAlumnos() {
        return repositorio.findAll();
    }

    public AlumnoModelo guardarAlumno(AlumnoModelo alumno) {
        return repositorio.save(alumno);
    }

    public AlumnoModelo obtenerAlumnoPorId(int id) {
        return repositorio.findById(id).orElse(null);
    }

    public AlumnoModelo actualizarAlumno(int id, AlumnoModelo alumnoActualizado) {
        // Verificar si el alumno existe
        AlumnoModelo alumnoExistente = repositorio.findById(id).orElse(null);
        if (alumnoExistente != null) {
            // Actualizar los campos
            alumnoExistente.setNombre(alumnoActualizado.getNombre());
            alumnoExistente.setNota(alumnoActualizado.getNota());
            // Agrega más campos si es necesario
    
            // Guardar los cambios
            return repositorio.save(alumnoExistente);
        }
        return null; // O manejar el caso de que el alumno no exista
    }
    

    public void eliminarAlumno(int id) {
        repositorio.deleteById(id);
    }
    
}
