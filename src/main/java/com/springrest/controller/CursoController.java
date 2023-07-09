package com.springrest.controller;

import com.springrest.dto.CursoDTO;
import com.springrest.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoService unCursoService;

    @PostMapping
    public CursoDTO guardarCurso(@RequestBody @Valid CursoDTO unCursoDto) {
        return unCursoService.guardarCurso(unCursoDto);
    }

    @GetMapping
    public List<CursoDTO> encontrarCursos() {
        return unCursoService.conseguirTodos();
    }

    @GetMapping("/{id}")
    public CursoDTO encontrarCurso(@PathVariable Long id) {
        return unCursoService.encontrarCurso(id);
    }

    @PutMapping("/{id}")
    public CursoDTO actualizarCurso(@PathVariable Long id, @RequestBody @Valid CursoDTO unCursoDto) {
        return unCursoService.actualizarCurso(id, unCursoDto);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id) {
        unCursoService.borrarCUrso(id);
    }
}

