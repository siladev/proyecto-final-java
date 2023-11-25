package com.proyecto.controller.services;

import com.proyecto.model.entities.Tecnico;
import com.proyecto.model.entities.IncidenteState;
import com.proyecto.model.entities.EstadoAsignado;
import com.proyecto.model.entities.EstadoResuelto;
import org.springframework.stereotype.Service;

@Service
public class EstadoIncidenteService {
    public IncidenteState getEstadoAsignado(Tecnico tecnico) {
        return new EstadoAsignado(tecnico);
    }

    public IncidenteState getEstadoEnProceso() {
        return new EstadoEnProceso();
    }

    public IncidenteState getEstadoResuelto() {
        return new EstadoResuelto();
    }
}
