package com.salesianostriana.dam.modelodatos.model;

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
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    //categorias padres
    @ManyToOne
    @JoinColumn(name = "categoria_padre",
            foreignKey = @ForeignKey(name = "FK_CATEGORIA_CATEGORIA"))
    private Categoria categoriaPadre;

    @OneToMany(mappedBy = "categoriaPadre" , fetch = FetchType.EAGER) //,cascade = {CascadeType})  //ELIMINAR SIN EL SET NULL

    private List<Categoria> categoriasHijas = new ArrayList<>();

    //CATEGORIAS

    @ToString.Exclude
    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Producto> producto = new ArrayList<>();


    //PREREMOVE
    @PreRemove
    public void setNullProductos() {
        producto.forEach(p -> p.setCategoria(null));
    }

    @PreRemove
    public void setnullCategoriaHijas(){
        categoriasHijas.forEach(c -> c.setCategoriaPadre(null));
    }


    //HELPERS
    public void addCategoriaPadre(Categoria c){

        this.setCategoriaPadre(c);
        c.getCategoriasHijas().add(this);
    }

    public void removeCategoriaPadre(Categoria c){

        categoriaPadre= null;
        c.getCategoriasHijas().remove(this);
    }

    public void addCategoriaHija(Categoria c){
        this.getCategoriasHijas().add(c);
        c.setCategoriaPadre(this);
    }

    public void removeCategoriaHijas(Categoria c){
        categoriasHijas= null;
        c.getCategoriasHijas().remove(this);
    }


}
