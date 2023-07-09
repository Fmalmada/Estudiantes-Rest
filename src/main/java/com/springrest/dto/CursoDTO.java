package com.springrest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class CursoDTO {

    @NotBlank(message = "Debe ingresar un curso")
    private String nombre;
    @NotBlank(message = "Debe ingresar una descripción")
    private String descripcion;
    @NotNull(message = "Debe ingresar una fecha de inicio del curso")
    private Date fechaDeInicio;
    @NotNull(message = "Debe ingresar una fecha de fin del curso")
    private Date fechaDeFin;
}
