package com.springrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class EstudianteDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Date fechaDeNacimiento;
    private int edad;
}
