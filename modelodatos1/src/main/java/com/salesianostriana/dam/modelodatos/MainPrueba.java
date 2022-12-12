package com.salesianostriana.dam.modelodatos;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import com.salesianostriana.dam.modelodatos.model.Categoria;
import com.salesianostriana.dam.modelodatos.model.Producto;
import com.salesianostriana.dam.modelodatos.repository.CategoriaRepositorio;
import com.salesianostriana.dam.modelodatos.repository.ProductoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final ProductoRepositorio productoRepositorio;
    private final CategoriaRepositorio categoriaRepositorio;

    @PostConstruct
    public void run(){

        Producto p1 = Producto.builder()
                .nombre("Televisión")
                .pvp(1200)
                .build();

        Producto p2 = Producto.builder()
                .nombre("Lavadora")
                .pvp(500)
                .build();

        productoRepositorio.save(p1);
        productoRepositorio.save(p2);

        Categoria c1 = Categoria.builder()
                .nombre("Electrónica")
                .build();

        Categoria c2 = Categoria.builder()
                .nombre("Electrodomésticos")  //ejemplo de inclusión en categoría padre
                .categoriaPadre(c1)
                .build();


        categoriaRepositorio.save(c1);
        categoriaRepositorio.save(c2);

        List<Producto> listaProductos = List.of(p1,p2);

        p1.addToCategoria(c1);
        p2.addToCategoria(c2);

        productoRepositorio.saveAll(listaProductos);

        //prueba de borrado
        productoRepositorio.delete(p1);

        categoriaRepositorio.findAll()
                .forEach(categoria -> {
                    System.out.println("Categoria: " + categoria.toString());
                    categoria.getProducto().forEach(System.out::println);
                });







    }


}
