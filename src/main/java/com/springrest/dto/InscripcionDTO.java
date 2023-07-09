package com.springrest.dto;

import com.springrest.domain.Curso;
import com.springrest.domain.Estudiante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class InscripcionDTO {

    @NotBlank(message = "Debe ingresar un estado")
    private String estado;
    @NotNull(message =  "Debe ingresar una fecha")
    private Date fechaDeInscripcion;
    @NotNull(message = "Debe ingresar un curso")
    private Curso curso;
    @NotNull(message = "Debe ingresar un estudiante")
    private Estudiante estudiante;
}
