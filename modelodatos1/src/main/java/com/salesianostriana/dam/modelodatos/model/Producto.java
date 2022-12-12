package com.salesianostriana.dam.modelodatos.model;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double pvp;

    @ManyToOne
    @JoinColumn(name = "categoria_id",
            foreignKey = @ForeignKey(name = "FK_PRODUCTO_CATEGORIA"))
    private Categoria categoria;


    public void addToCategoria(Categoria c){

        this.categoria = c;
        c.getProducto().add(this);
    }

    public void removeFromCategoria(Categoria c){

        this.categoria = null;
        c.getProducto().remove(this);
    }


}
