package com.springrest.controller;

import com.springrest.dto.EstudianteDTO;
import com.springrest.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteService unEstudianteService;

    @PostMapping
    public EstudianteDTO crearEstudiante(@RequestBody EstudianteDTO unEstudianteDTO) {
        return unEstudianteService.crearEstudiante(unEstudianteDTO);
    }

    @GetMapping
    public List<EstudianteDTO> conseguirEstudiantes() {
        return unEstudianteService.conseguirEstudiantes();

    }

    @GetMapping("/{id}")
    public EstudianteDTO conseguirEstudiante(@PathVariable Long id) {
        return unEstudianteService.conseguirEstudiante(id);
    }

    @PutMapping("/{id}")
    public EstudianteDTO actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO unEstudianteDto) {
        return unEstudianteService.actualizarEstudiante(id, unEstudianteDto);


    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante(@PathVariable Long id) {
        unEstudianteService.eliminarEstudiante(id);
    }


}
