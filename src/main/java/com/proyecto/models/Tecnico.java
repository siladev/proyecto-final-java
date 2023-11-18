package com.proyecto.models;

import java.util.List;
import lombok.*;
@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

public class Tecnico {
    private int id;
    private String nombreTecnico;
    private List<Especialidad> tecnicoEspecialidad;
    private List<Incidente> incidente;

}
