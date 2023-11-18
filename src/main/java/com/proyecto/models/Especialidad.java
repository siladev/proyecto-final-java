package com.proyecto.models;

import lombok.*;

import java.util.List;

@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

public class Especialidad {
    private int id;
    private String nombreEspecialidad;
    private List<TipoProblema> problemaEspecialidad;
}