package com.springrest.service;

import com.springrest.domain.Estudiante;
import com.springrest.dto.EstudianteDTO;
import com.springrest.repository.EstudianteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudiantesRepo;

    public EstudianteDTO crearEstudiante(EstudianteDTO unEstudianteDTO){

        if (unEstudianteDTO.getEdad() < 19){
            throw new RuntimeException("El estudiante debe ser mayor a 18 años");
        }
        Estudiante unEstudiante = new Estudiante();
        unEstudiante.setApellido(unEstudianteDTO.getApellido());
        unEstudiante.setNombre(unEstudianteDTO.getNombre());
        unEstudiante.setDni(unEstudianteDTO.getDni());
        unEstudiante.setEdad(unEstudianteDTO.getEdad());
        unEstudiante.setFechaDeNacimiento(unEstudianteDTO.getFechaDeNacimiento());

        estudiantesRepo.save(unEstudiante);
        return unEstudianteDTO;
    }

    public List<EstudianteDTO> conseguirEstudiantes() {
        return estudiantesRepo.findAll().stream().map(e-> new EstudianteDTO(e.getNombre(), e.getApellido(), e.getEmail(), e.getDni(), e.getFechaDeNacimiento(), e.getEdad()))
                .collect(Collectors.toList());
    }

    public EstudianteDTO conseguirEstudiante(Long unId) {
        Optional<Estudiante> unEstudianteOpcional = estudiantesRepo.findById(unId);

        if (unEstudianteOpcional.isEmpty()) {
            throw new RuntimeException("Id invalido");
        }

        Estudiante unEstudiante = unEstudianteOpcional.get();

        return new EstudianteDTO(unEstudiante.getNombre(), unEstudiante.getApellido(), unEstudiante.getEmail(), unEstudiante.getDni(), unEstudiante.getFechaDeNacimiento(), unEstudiante.getEdad());
    }

    public void eliminarEstudiante(Long unId) {
        estudiantesRepo.deleteById(unId);
    }

    public EstudianteDTO actualizarEstudiante(Long unId, @Valid EstudianteDTO unEstudianteDTO){
        Estudiante unEstudiante = new Estudiante();
        unEstudiante.setId(unId);
        unEstudiante.setNombre(unEstudianteDTO.getNombre());
        unEstudiante.setDni(unEstudianteDTO.getDni());
        unEstudiante.setEdad(unEstudianteDTO.getEdad());
        unEstudiante.setFechaDeNacimiento(unEstudianteDTO.getFechaDeNacimiento());
        unEstudiante.setApellido(unEstudianteDTO.getApellido());

        estudiantesRepo.save(unEstudiante);

        return unEstudianteDTO;

    }
}