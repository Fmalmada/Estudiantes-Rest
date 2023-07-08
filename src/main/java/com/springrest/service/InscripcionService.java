package com.springrest.service;

import com.springrest.domain.Inscripcion;
import com.springrest.dto.InscripcionDTO;
import com.springrest.repository.CursoRepository;
import com.springrest.repository.EstudianteRepository;
import com.springrest.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {

    @Autowired
    InscripcionRepository inscripcionesRepo;
    @Autowired
    EstudianteRepository estudiantesRepo;
    @Autowired
    CursoRepository cursosRepo;

    public InscripcionDTO crearInscripcion(InscripcionDTO unaInscripcionDTO) {
        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setFechaDeInscripcion(unaInscripcionDTO.getFechaDeInscripcion());
        unaInscripcion.setEstado(unaInscripcionDTO.getEstado());
        unaInscripcion.setUnCurso(unaInscripcionDTO.getUnCurso());
        unaInscripcion.setUnEstudiante(unaInscripcionDTO.getUnEstudiante());

        inscripcionesRepo.save(unaInscripcion);
        return unaInscripcionDTO;
    }

}
