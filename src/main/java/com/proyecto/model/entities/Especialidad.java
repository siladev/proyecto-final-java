package com.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @Column (name = "id_especialidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombre_especialidad")
    private String nombreEspecialidad;
    @ManyToMany () // Relación muchos a muchos con Tecnico
    @JoinTable(
            name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "especialidad_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id"))
    private List<TipoProblema> problemaEspecialidad;

    public Especialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
}
