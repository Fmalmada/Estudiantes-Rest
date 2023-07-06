package com.springrest.repository;

import com.springrest.domain.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}
