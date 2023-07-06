package com.springrest.repository;

import com.springrest.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
