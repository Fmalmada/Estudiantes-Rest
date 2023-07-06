package com.springrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CursoDTO {

    private String nombre;
    private String descripcion;
    private Date fechaDeInicio;
    private Date fechaDeFin;
}
