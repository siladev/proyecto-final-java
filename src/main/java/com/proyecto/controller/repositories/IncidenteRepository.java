package com.proyecto.controller.repositories;
import com.proyecto.model.entities.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {
    List<Incidente> findByFechaSolucionAfter(LocalDateTime date);

    List<Incidente> findByFechaSolucionAfterAndTecnicoEspecialidad(LocalDateTime date, String especialidad);

    List<Incidente> findByEstadoOrderByFechaSolucionAsc(String estado);
}