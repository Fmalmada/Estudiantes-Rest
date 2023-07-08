package com.springrest.controller;

import com.springrest.dto.InscripcionDTO;
import com.springrest.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    InscripcionService inscripcionService;

    @PostMapping
    public InscripcionDTO crearInscripcion(@RequestBody InscripcionDTO unaInscripcionDTO) {
        return inscripcionService.crearInscripcion(unaInscripcionDTO);
    }
}
