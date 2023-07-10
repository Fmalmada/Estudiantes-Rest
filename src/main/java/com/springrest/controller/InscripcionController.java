package com.springrest.controller;

import com.springrest.dto.InscripcionDTO;
import com.springrest.service.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    InscripcionService inscripcionService;

    @PostMapping
    public ResponseEntity<InscripcionDTO> crearInscripcion(@RequestBody @Valid InscripcionDTO unaInscripcionDTO) {
        return inscripcionService.crearInscripcion(unaInscripcionDTO);
    }

    @GetMapping
    public ResponseEntity<List<InscripcionDTO>> conseguirInscripciones(){
        return inscripcionService.conseguirInscripciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionDTO> conseguirInscripcion(@PathVariable Long id) {
        return inscripcionService.conseguirInscripcion(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscripcionDTO> actualizarInscripcion(@PathVariable Long id, @RequestBody @Valid InscripcionDTO unaInscripcionDTO) {
        return inscripcionService.actualizarInscripcion(id, unaInscripcionDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarInscripcion(@PathVariable Long id) {
        inscripcionService.eliminarInscripcion(id);
    }
}
