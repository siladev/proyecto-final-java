package com.proyecto.models;

import java.util.List;
import lombok.*;
@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

public class Servicio {
    private int id;
    private String nombreServicio;
    private String descripcionServicio;
    private List<Incidente> incidente;

}
