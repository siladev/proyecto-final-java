package com.proyecto.model.entities;

import java.util.List;

import com.proyecto.model.entities.Incidente;
import jakarta.persistence.*;
import lombok.*;
@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

@Entity
@Table (name = "servicio")
public class Servicio {
    @Id
    @Column (name = "servicio_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombre_servicio")
    private String nombreServicio;
    @Column (name = "descripcion_servicio")
    private String descripcionServicio;
    @OneToMany(mappedBy = "servicio_id", cascade = CascadeType.ALL, orphanRemoval = true) // Relación uno a muchos con Incidente.
    private List<Incidente> incidente;

}
