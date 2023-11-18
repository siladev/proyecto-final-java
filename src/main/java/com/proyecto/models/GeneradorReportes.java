package com.proyecto.models;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GeneradorReportes {
    // Lógica de inicialización si es necesaria
    // Método para generar el reporte diario de incidentes asignados a cada técnico
    public Map<Tecnico, List<Incidente>> generarReporteIncidentesAsignados(List<Incidente> incidente) {
        // Organiza los incidentes por técnico
        return incidente.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnico));
    }
}
