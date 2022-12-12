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
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String email;
    private double puntuacion;


    @ToString.Exclude
    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    @Builder.Default
    private List<CursoOnline> cursoOnline = new ArrayList<>();

    @PreRemove
    public void setNullCursos() {
        cursoOnline.forEach(c -> c.setProfesor(null));
    }

}
