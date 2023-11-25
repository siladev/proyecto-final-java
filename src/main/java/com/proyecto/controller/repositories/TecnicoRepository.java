package com.proyecto.controller.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.model.entities.Tecnico;
import java.util.List;
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    List<Tecnico> findByEspecialidad(String especialidad);
}
