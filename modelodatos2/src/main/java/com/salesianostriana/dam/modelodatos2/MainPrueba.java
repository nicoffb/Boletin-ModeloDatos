package com.salesianostriana.dam.modelodatos2;

import com.salesianostriana.dam.modelodatos2.model.Profesor;
import com.salesianostriana.dam.modelodatos2.model.CursoOnline;
import com.salesianostriana.dam.modelodatos2.model.Video;
import com.salesianostriana.dam.modelodatos2.repository.CursoRepositorio;
import com.salesianostriana.dam.modelodatos2.repository.ProfesorRepositorio;
import com.salesianostriana.dam.modelodatos2.repository.VideoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final CursoRepositorio cursoRepositorio;
    private final ProfesorRepositorio profesorRepositorio;
    private final VideoRepositorio videoRepositorio;

    @PostConstruct
    public void run(){

        //CURSOS
        CursoOnline c1 = CursoOnline.builder()
                .nombre("Matemáticas avanzadas")
                .puntuacion(8)
                .build();

        CursoOnline c2 = CursoOnline.builder()
                .nombre("Biología Básica")
                .puntuacion(7)
                .build();

        cursoRepositorio.save(c1);
        cursoRepositorio.save(c2);


        //PROFESORES
        Profesor p1 = Profesor.builder()
                .nombre("Mortadelo Filomeno")
                .puntuacion(8.5)
                .build();

        Profesor p2 = Profesor.builder()
                .nombre("Filemón Mortadelle")
                .puntuacion(9)
                .build();


        profesorRepositorio.save(p1);
        profesorRepositorio.save(p2);

        List<CursoOnline> listaCursoOnlines = List.of(c1,c2);

        c1.addToProfesor(p1);
        c2.addToProfesor(p2);

        cursoRepositorio.saveAll(listaCursoOnlines);

        //VIDEOS
        Video v1 = Video.builder()
                .orden(1)
                .titulo("Sumas y restas")
                .descripcion("Explicación de las operaciones básicas")
                .url("www.curso.com")
                .build();

        Video v2 = Video.builder()
                .orden(2)
                .titulo("Las células")
                .descripcion("Definición de las células")
                .url("www.curso.com")
                .build();

        videoRepositorio.save(v1);
        videoRepositorio.save(v2);

        List<Video> listaVideos = List.of(v1,v2);

        v1.addToCurso(c1);
        v2.addToCurso(c2);

        videoRepositorio.saveAll(listaVideos);


        //prueba de borrado
        //cursoRepositorio.delete(c2);

        profesorRepositorio.findAll()
                .forEach(profesor -> {
                    System.out.println("Curso: " + profesor.toString());
                    profesor.getCursoOnline().forEach(System.out::println);
                });

        cursoRepositorio.findAll()
                .forEach(curso -> {
                    System.out.println("Video: " + curso.toString());
                    curso.getVideos().forEach(System.out::println);
                });







    }


}
