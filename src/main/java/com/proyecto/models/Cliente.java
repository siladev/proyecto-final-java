package com.proyecto.models;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;
@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

public class Cliente {

    private int id;
    private String razonSocial;
    private String cuit;
    private String email;
    private String telefono;
    private List<Servicio> cliente_servicio;
    private List<Incidente> incidente;

}
