package com.proyecto.models;

import lombok.*;

import java.time.LocalDateTime;

@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

public class Incidente {
    private int id;
    private String descripcionIncidente;
    private LocalDateTime fechaIncidente;
    private LocalDateTime fechaSolucion;
    private String estado;
    private String observacion;
    private Cliente cliente;
    private Servicio servicio;
    private Tecnico tecnico;
    private TipoProblema tipoProblema;
}
