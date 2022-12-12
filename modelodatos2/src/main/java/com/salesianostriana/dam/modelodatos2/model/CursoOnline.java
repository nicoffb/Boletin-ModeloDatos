package com.salesianostriana.dam.modelodatos2.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double puntuacion;

    @ManyToOne
    @JoinColumn(name = "profesor_id",
            foreignKey = @ForeignKey(name = "FK_CURSO_PROFESOR"))
    private Profesor profesor;


    @ToString.Exclude
    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Video> videos = new ArrayList<>();


    public void addToProfesor(Profesor c){

        this.profesor = c;
        c.getCursoOnline().add(this);
    }

    public void removeFromProfesor(Profesor c){

        this.profesor = null;
        c.getCursoOnline().remove(this);
    }


}
