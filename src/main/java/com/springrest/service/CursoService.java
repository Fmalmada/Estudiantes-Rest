package com.springrest.service;

import com.springrest.domain.Curso;
import com.springrest.dto.CursoDTO;
import com.springrest.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository unCursoRepo;

    public CursoDTO guardarCurso(CursoDTO unCursoDto) {
        Curso unCurso = new Curso();
        unCurso.setNombre(unCursoDto.getNombre());
        unCurso.setDescripcion(unCursoDto.getDescripcion());
        unCurso.setFechaDeFin(unCursoDto.getFechaDeFin());
        unCurso.setFechaDeInicio(unCursoDto.getFechaDeInicio());

        unCursoRepo.save(unCurso);
        return unCursoDto;
    }

    public List<CursoDTO> conseguirTodos() {
        return unCursoRepo.findAll()
                .stream().map(c -> new CursoDTO(c.getNombre(), c.getDescripcion(), c.getFechaDeInicio(), c.getFechaDeFin()))
                .collect(Collectors.toList());
    }

    public CursoDTO actualizarCurso(Long id, CursoDTO unCursoDto) {
        Curso unCurso = new Curso();
        unCurso.setId(id);
        unCurso.setNombre(unCursoDto.getNombre());
        unCurso.setDescripcion(unCursoDto.getDescripcion());
        unCurso.setFechaDeFin(unCursoDto.getFechaDeFin());
        unCurso.setFechaDeInicio(unCursoDto.getFechaDeInicio());

        unCursoRepo.save(unCurso);
        return unCursoDto;
    }

    public CursoDTO encontrarCurso(Long id) {
        Optional<Curso> cursoOpcional = unCursoRepo.findById(id);

        if (cursoOpcional.isEmpty()) {
            throw new RuntimeException("Id invalido");
        }

        Curso unCurso = cursoOpcional.get();
        return new CursoDTO(unCurso.getNombre(), unCurso.getDescripcion(), unCurso.getFechaDeInicio(), unCurso.getFechaDeFin());

    }

    public void borrarCUrso(Long id) {
        unCursoRepo.deleteById(id);
    }



}