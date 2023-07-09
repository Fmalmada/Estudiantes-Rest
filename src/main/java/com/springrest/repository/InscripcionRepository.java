package com.springrest.repository;

import com.springrest.domain.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    @Query("SELECT i FROM Inscripcion i WHERE i.estado='Rechazada' OR i.estado='Pendiente'")
    List<Inscripcion> listarInscripicionesConEstadoPendienteORechazada();

    @Query("SELECT i FROM Inscripcion i WHERE i.estado = :estado")
    List<Inscripcion> listarInscripcionesPorEstado(@Param("estado") String estado);

    @Query(value = "SELECT * FROM Inscripcion i WHERE i.estado= :estado", nativeQuery = true)
    List<Inscripcion> listarInscripcionesPorEstadoNativo(@Param("estado") String estado);

    List<Inscripcion> findInscripcionByEstadoEqualsOrEstadoEquals(String unEstado, String otroEstado);

    List<Inscripcion> findInscripcionByEstadoEquals(String unEstado);

}
