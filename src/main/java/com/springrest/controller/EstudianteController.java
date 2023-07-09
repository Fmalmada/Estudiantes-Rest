package com.springrest.controller;

import com.springrest.dto.EstudianteDTO;
import com.springrest.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteService unEstudianteService;

    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody @Valid EstudianteDTO unEstudianteDTO) {
        return unEstudianteService.crearEstudiante(unEstudianteDTO);
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> conseguirEstudiantes() {
        return unEstudianteService.conseguirEstudiantes();

    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> conseguirEstudiante(@PathVariable Long id) {
        return unEstudianteService.conseguirEstudiante(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody @Valid EstudianteDTO unEstudianteDto) {
        return unEstudianteService.actualizarEstudiante(id, unEstudianteDto);


    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
        unEstudianteService.eliminarEstudiante(id);
    }


}
