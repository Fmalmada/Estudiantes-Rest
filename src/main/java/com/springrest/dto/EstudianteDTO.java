package com.springrest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class EstudianteDTO {
    @NotBlank(message = "Debe ingresar un nombre del estudiante")
    private String nombre;
    @NotBlank(message = "Debe ingresar un apellido del estudiante")
    private String apellido;
    @Email(message = "Debe ingresar un email válido")
    private String email;
    @NotBlank( message = "Debe ingresar un DNI")
    private String dni;
    @NotNull(message = "Debe ingresar una fecha de nacimiento")
    private Date fechaDeNacimiento;
    @Min(value = 18 , message = "Debe ingresar una fecha de nacimiento")
    private int edad;
}
