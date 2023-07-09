package com.springrest.service;

import com.springrest.domain.Curso;
import com.springrest.dto.CursoDTO;
import com.springrest.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository unCursoRepo;

    public ResponseEntity<CursoDTO> guardarCurso(CursoDTO unCursoDto) {
        Curso unCurso = new Curso();
        unCurso.setNombre(unCursoDto.getNombre());
        unCurso.setDescripcion(unCursoDto.getDescripcion());
        unCurso.setFechaDeFin(unCursoDto.getFechaDeFin());
        unCurso.setFechaDeInicio(unCursoDto.getFechaDeInicio());

        unCursoRepo.save(unCurso);
        return  new ResponseEntity<>(unCursoDto,HttpStatus.CREATED);
    }

    public ResponseEntity<List<CursoDTO>> conseguirTodos() {
        return  new ResponseEntity<>(unCursoRepo.findAll()
                .stream().map(c -> new CursoDTO(c.getNombre(), c.getDescripcion(), c.getFechaDeInicio(), c.getFechaDeFin()))
                .collect(Collectors.toList()),HttpStatus.OK);
    }

    public ResponseEntity<CursoDTO> actualizarCurso(Long id, CursoDTO unCursoDto) {
        Optional<Curso> cursoOpcional = unCursoRepo.findById(id);

        if (cursoOpcional.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        Curso unCurso = cursoOpcional.get();
        unCurso.setNombre(unCursoDto.getNombre());
        unCurso.setDescripcion(unCursoDto.getDescripcion());
        unCurso.setFechaDeFin(unCursoDto.getFechaDeFin());
        unCurso.setFechaDeInicio(unCursoDto.getFechaDeInicio());

        unCursoRepo.save(unCurso);
        return new ResponseEntity<>(unCursoDto, HttpStatus.OK);
    }

    public ResponseEntity<CursoDTO> encontrarCurso(Long id) {
        Optional<Curso> cursoOpcional = unCursoRepo.findById(id);

        if (cursoOpcional.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        Curso unCurso = cursoOpcional.get();
        return new ResponseEntity<> (new CursoDTO(unCurso.getNombre(), unCurso.getDescripcion(), unCurso.getFechaDeInicio(),
                unCurso.getFechaDeFin()), HttpStatus.CREATED);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarCurso(Long id) {
        unCursoRepo.deleteById(id);
    }




}