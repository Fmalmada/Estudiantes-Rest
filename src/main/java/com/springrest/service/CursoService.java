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

}