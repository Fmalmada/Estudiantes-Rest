package com.springrest.controller;

import com.springrest.dto.InscripcionDTO;
import com.springrest.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    InscripcionService inscripcionService;

    @PostMapping
    public InscripcionDTO crearInscripcion(@RequestBody InscripcionDTO unaInscripcionDTO) {
        return inscripcionService.crearInscripcion(unaInscripcionDTO);
    }

    @GetMapping
    public List<InscripcionDTO> conseguirInscripciones(){
        return inscripcionService.conseguirInscripciones();
    }

    @GetMapping("/{id}")
    public InscripcionDTO conseguirInscripcion(@PathVariable Long id) {
        return inscripcionService.conseguirInscripcion(id);
    }

    @PutMapping("/{id}")
    public InscripcionDTO actualizarInscripcion(@PathVariable Long id, @RequestBody InscripcionDTO unaInscripcionDTO) {
        return inscripcionService.actualizarInscripcion(id, unaInscripcionDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarInscripcion(@PathVariable Long id) {
        inscripcionService.eliminarInscripcion(id);
    }
}
