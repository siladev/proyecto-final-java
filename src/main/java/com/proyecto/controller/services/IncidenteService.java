package com.proyecto.controller.services;

import com.proyecto.model.entities.Incidente;
import com.proyecto.model.entities.Tecnico;
import com.proyecto.controller.repositories.IncidenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class IncidenteService {
    private final IncidenteRepository incidenteRepository;

    @Autowired
    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    public List<Incidente> getTecnicoConMasIncidentesResueltos(int n) {
        LocalDateTime date = LocalDateTime.now().minusDays(n);
        return incidenteRepository.findByFechaSolucionAfter(date);
    }

    public List<Incidente> getTecnicoConMasIncidentesResueltosPorEspecialidad(int n, String especialidad) {
        LocalDateTime date = LocalDateTime.now().minusDays(n);
        return incidenteRepository.findByFechaSolucionAfterAndTecnicoEspecialidad(date, especialidad);
    }

    public Tecnico getTecnicoMasRapido() {
        List<Incidente> incidentes = incidenteRepository.findAll();
        return incidentes.stream()
                .min(Comparator.comparing(Incidente::getFechaSolucion))
                .map(Incidente::getTecnico)
                .orElse(null);
    }

    public void printClientes() {
        List<Incidente> incidentes = incidenteRepository.findAll();
        incidentes.stream()
                .map(Incidente::getCliente)
                .distinct()
                .forEach(cliente -> System.out.println(cliente.getRazonSocial()));
    }

    public void printIncidentes() {
        List<Incidente> incidentes = incidenteRepository.findAll();
        incidentes.forEach(incidente -> System.out.println(incidente.getDescripcionIncidente()));
    }
}