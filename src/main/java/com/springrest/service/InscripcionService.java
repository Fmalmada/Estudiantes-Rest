package com.springrest.service;

import com.springrest.domain.Inscripcion;
import com.springrest.dto.InscripcionDTO;
import com.springrest.repository.CursoRepository;
import com.springrest.repository.EstudianteRepository;
import com.springrest.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    public ResponseEntity<InscripcionDTO> crearInscripcion(InscripcionDTO unaInscripcionDTO) {
        Inscripcion unaInscripcion = new Inscripcion();
        unaInscripcion.setFechaDeInscripcion(unaInscripcionDTO.getFechaDeInscripcion());
        unaInscripcion.setEstado(unaInscripcionDTO.getEstado());
        unaInscripcion.setCurso(unaInscripcionDTO.getCurso());
        unaInscripcion.setEstudiante(unaInscripcionDTO.getEstudiante());

        inscripcionesRepo.save(unaInscripcion);
        return new ResponseEntity<>(unaInscripcionDTO, HttpStatus.CREATED);
    }

    public ResponseEntity<List<InscripcionDTO>> conseguirInscripciones() {
        return  new ResponseEntity<>(inscripcionesRepo.findAll().stream().map(i -> new InscripcionDTO(i.getEstado(), i.getFechaDeInscripcion(),
                i.getCurso(), i.getEstudiante())).collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<InscripcionDTO> conseguirInscripcion(Long unId) {
        Optional<Inscripcion> unaInscripcionOptional = inscripcionesRepo.findById(unId);

        if (unaInscripcionOptional.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }

        Inscripcion unaInscripcion = unaInscripcionOptional.get();
        return new ResponseEntity<>(new InscripcionDTO(unaInscripcion.getEstado(),unaInscripcion.getFechaDeInscripcion(), unaInscripcion.getCurso(), unaInscripcion.getEstudiante())
        , HttpStatus.OK);
    }

    public ResponseEntity<InscripcionDTO> actualizarInscripcion(Long unId, InscripcionDTO unaInscripcionDTO) {
        Optional<Inscripcion> unaInscripcionOptional = inscripcionesRepo.findById(unId);

        if (unaInscripcionOptional.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        Inscripcion unaInscripcion = unaInscripcionOptional.get();

        unaInscripcion.setEstado(unaInscripcionDTO.getEstado());
        unaInscripcion.setFechaDeInscripcion(unaInscripcionDTO.getFechaDeInscripcion());
        unaInscripcion.setEstudiante(unaInscripcionDTO.getEstudiante());
        unaInscripcion.setCurso(unaInscripcionDTO.getCurso());

        inscripcionesRepo.save(unaInscripcion);

        return new ResponseEntity<>(unaInscripcionDTO, HttpStatus.OK);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarInscripcion(Long unId) {
        inscripcionesRepo.deleteById(unId);
    }

}
