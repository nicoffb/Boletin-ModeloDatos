package com.salesianostriana.dam.modelodatos2.repository;

import com.salesianostriana.dam.modelodatos2.model.CursoOnline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<CursoOnline, Long> {
}
