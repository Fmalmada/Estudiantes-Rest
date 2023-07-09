package com.springrest.repository;

import com.springrest.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT c FROM Curso c WHERE c.fechaDeInicio > :fecha")
    List<Curso> CursosEmpezadoLuegoDelPrimeroDeFebrero(@Param("fecha") Date fecha);

    @Query("SELECT c from Curso c")
    List<Curso> ListarTodosLosCursos();

    List<Curso> findCursoByFechaDeInicioAfter(Date fecha);

}
