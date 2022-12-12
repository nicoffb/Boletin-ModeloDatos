package com.salesianostriana.dam.modelodatos.repository;

import com.salesianostriana.dam.modelodatos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Long> {
}
