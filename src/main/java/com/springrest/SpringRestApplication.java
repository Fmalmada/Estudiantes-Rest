package com.springrest;

import com.springrest.domain.Curso;
import com.springrest.domain.Estudiante;
import com.springrest.domain.Inscripcion;
import com.springrest.repository.CursoRepository;
import com.springrest.repository.EstudianteRepository;
import com.springrest.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringRestApplication {

    @Autowired
    EstudianteRepository esRepo;

    @Autowired
    InscripcionRepository iRepo;

    @Autowired
    CursoRepository cRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            guardarInscripciones();
        };
    }

    private void guardarInscripciones() {

        Curso unCurso = new Curso();
        unCurso.setFechaDeInicio( new Date());
        cRepo.save(unCurso);

        Estudiante estudiantesinRomero1 = new Estudiante();
        estudiantesinRomero1.setApellido("Romero");
        estudiantesinRomero1.setDni(2);

        Estudiante estudianteRomero1 = new Estudiante();
        estudianteRomero1.setApellido("Vazques");
        estudianteRomero1.setDni(2);

        Estudiante estudianteRomero = new Estudiante();
        estudianteRomero.setApellido("Romero");
        estudianteRomero.setDni(3000000);

        Estudiante estudianteMal = new Estudiante();
        estudianteMal.setApellido("Nose");
        estudianteMal.setDni(99999999);

        esRepo.save(estudianteRomero);
        esRepo.save(estudianteRomero1);
        esRepo.save(estudiantesinRomero1);
        esRepo.save(estudianteMal);

        Inscripcion inscripcionRechazada = new Inscripcion();
        inscripcionRechazada.setEstado("Rechazada");
        inscripcionRechazada.setUnEstudiante(estudianteMal);
        inscripcionRechazada.setUnCurso(unCurso);

        Inscripcion inscripcionAceptada = new Inscripcion();
        inscripcionAceptada.setEstado("Aceptada");
        inscripcionAceptada.setUnEstudiante(estudianteMal);
        inscripcionAceptada.setUnCurso(unCurso);



        esRepo.save(new Estudiante());
    }



}
