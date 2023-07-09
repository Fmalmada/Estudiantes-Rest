package com.springrest.dto;

import com.springrest.domain.Curso;
import com.springrest.domain.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class InscripcionDTO {
    private String estado;
    private Date fechaDeInscripcion;
    private Curso unCurso;
    private Estudiante unEstudiante;
}
