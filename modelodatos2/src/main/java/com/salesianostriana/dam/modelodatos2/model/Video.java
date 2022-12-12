package com.salesianostriana.dam.modelodatos2.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Video {

    @Id
    @GeneratedValue
    private Long id;
    private int orden;
    private String titulo;
    private String descripcion;
    private String url;

    @ManyToOne
    @JoinColumn(name = "curso_id",
            foreignKey = @ForeignKey(name = "FK_VIDEO_CURSO"))
    private CursoOnline cursoOnline;

    public void addToCurso(CursoOnline c){

        this.cursoOnline = c;
        c.getVideos().add(this);
    }

    public void removeFromCurso(CursoOnline c){

        this.cursoOnline = null;
        c.getVideos().remove(this);
    }

}
