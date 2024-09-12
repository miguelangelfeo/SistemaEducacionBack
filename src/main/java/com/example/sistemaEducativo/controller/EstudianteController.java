package com.example.sistemaEducativo.controller;

import com.example.sistemaEducativo.bd.EstudianteJPA;
import com.example.sistemaEducativo.bd.EstudianteORM;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class EstudianteController {

    private EstudianteJPA estudianteJPA;

    List<EstudianteDTO> estudiantes = new ArrayList<>();

    @GetMapping(path = "/saludo")
    public String saludar() {
        return "Hola mundo";
    }


    @PostMapping(path = "/estudiante")
    public String guardarEstudiante(@RequestBody EstudianteDTO estudiante) {
        estudiantes.add(estudiante);
        estudianteJPA.save(new EstudianteORM(estudiante.nombre(), estudiante.genero(), estudiante.edad(),estudiante.carrera(), estudiante.email(), estudiante.semestre(), estudiante.promedio()));
        return "Estudiante guardado";
    }
    @GetMapping(path = "/estudiantes-bd")
    public List<EstudianteORM> obtenerEstudiantesBD() {
        return estudianteJPA.findAll();
    }
}
