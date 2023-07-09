package com.springrest.controller;

import com.springrest.dto.CursoDTO;
import com.springrest.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoService unCursoService;

    @PostMapping
    public CursoDTO guardarCurso(@RequestBody CursoDTO unCursoDto) {
        return unCursoService.guardarCurso(unCursoDto);
    }
}

