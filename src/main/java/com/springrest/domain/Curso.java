package com.springrest.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;

import java.util.Date;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String descripcion;


    private Date fechaDeInicio;
    private Date fechaDeFin;

}
