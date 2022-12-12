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

    @ManyToOne
    private Categoria categoriaPadre;

    @ToString.Exclude
    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    @Builder.Default
    private List<Producto> producto = new ArrayList<>();

    @PreRemove
    public void setNullProductos() {
        producto.forEach(p -> p.setCategoria(null));
    }

}
