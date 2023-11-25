package com.proyecto.model.entities;

public interface IncidenteState  {
    void asignarIncidente(Incidente incidente);
    void iniciarEnProceso(Incidente incidente);
    void resolverIncidente(Incidente incidente);
}