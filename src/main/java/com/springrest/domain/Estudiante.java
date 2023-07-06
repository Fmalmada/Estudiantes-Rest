package com.springrest.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private Date fechaDeNacimiento;

    @Transient
    private int edad;
}
