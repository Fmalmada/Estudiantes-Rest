package com.springrest.service;

import com.springrest.domain.Inscripcion;
import com.springrest.dto.InscripcionDTO;
import com.springrest.repository.CursoRepository;
import com.springrest.repository.EstudianteRepository;
import com.springrest.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<InscripcionDTO> conseguirInscripciones() {
        return inscripcionesRepo.findAll().stream().map(i -> new InscripcionDTO(i.getEstado(), i.getFechaDeInscripcion(),
                i.getUnCurso(), i.getUnEstudiante())).collect(Collectors.toList());
    }

    public InscripcionDTO conseguirInscripcion(Long unId) {
        Optional<Inscripcion> unaInscripcionOptional = inscripcionesRepo.findById(unId);

        if (unaInscripcionOptional.isEmpty()) {
            throw new RuntimeException("Id inválido");
        }

        Inscripcion unaInscripcion = unaInscripcionOptional.get();
        return new InscripcionDTO(unaInscripcion.getEstado(),unaInscripcion.getFechaDeInscripcion(), unaInscripcion.getUnCurso(), unaInscripcion.getUnEstudiante());
    }

    public InscripcionDTO actualizarInscripcion(Long unId, InscripcionDTO unaInscripcionDTO) {
        Optional<Inscripcion> unaInscripcionOptional = inscripcionesRepo.findById(unId);

        if (unaInscripcionOptional.isEmpty()) {
            throw new RuntimeException("Id inválido");
        }

        Inscripcion unaInscripcion = unaInscripcionOptional.get();

        unaInscripcion.setEstado(unaInscripcionDTO.getEstado());
        unaInscripcion.setFechaDeInscripcion(unaInscripcionDTO.getFechaDeInscripcion());
        unaInscripcion.setUnEstudiante(unaInscripcionDTO.getUnEstudiante());
        unaInscripcion.setUnCurso(unaInscripcionDTO.getUnCurso());

        inscripcionesRepo.save(unaInscripcion);

        return unaInscripcionDTO;
    }

    public void eliminarInscripcion(Long unId) {
        inscripcionesRepo.deleteById(unId);
    }

}
