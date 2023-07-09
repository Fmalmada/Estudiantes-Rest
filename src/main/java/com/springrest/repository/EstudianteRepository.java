package com.springrest.repository;

import com.springrest.domain.Estudiante;
import jakarta.validation.constraints.DecimalMin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    @Query("SELECT e from Estudiante  e")
    List<Estudiante> listarTodosLosEstudiantes();

    @Query("SELECT e FROM Estudiante e WHERE e.dni>20000000 AND e.apellido = 'Romero'")
    List<Estudiante> listarTodosLosEstudiantesConDniMayorYApellidoRomero();

    @Query("SELECT e FROM Estudiante e")
    Page<Estudiante> estudiantesPaginados(Pageable pageable);

    @Override
    List<Estudiante> findAll();

    List<Estudiante> findEstudianteByDniAfterAndApellidoEquals(int unDni, String unApellido);
}
