package com.salesianostriana.dam.modelodatos.repository;

import com.salesianostriana.dam.modelodatos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}
