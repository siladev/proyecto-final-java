package com.proyecto.model.entities;

public class EstadoAsignado implements IncidenteState {
    private Tecnico tecnicoAsignado;

    public EstadoAsignado(Tecnico tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    @Override
    public void asignarIncidente(Incidente incidente) {
        // Implementación para asignar el incidente al técnico
        // por ejemplo, incidente.setTecnico(tecnicoAsignado);
    }

    @Override
    public void iniciarEnProceso(Incidente incidente) {
        // Implementación para iniciar el incidente en proceso
        // por ejemplo, incidente.setEstado(new EstadoEnProceso());
    }

    @Override
    public void resolverIncidente(Incidente incidente) {
        // Implementación para resolver el incidente
        // por ejemplo, incidente.setEstado(new EstadoResuelto());
    }

    @Override
    public String toString() {
        return "Estado: Asignado\nTécnico asignado: " + tecnicoAsignado.getNombreTecnico();
    }
}
