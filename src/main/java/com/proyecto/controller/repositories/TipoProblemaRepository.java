package com.proyecto.controller.repositories;

import com.proyecto.model.entities.TipoProblema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProblemaRepository extends JpaRepository<TipoProblema, Integer> {
}