package com.proyecto.model.entities;

import com.proyecto.model.entities.Tecnico;
import java.util.stream.Collectors;
import java.util.List;

import com.proyecto.model.entities.Incidente;
import jakarta.persistence.*;
import lombok.*;
@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

@Entity
@Table(name = "tecnico")
public class Tecnico {
    @Id
    @Column (name = "tecnico_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombre_tecnico")
    private String nombreTecnico;
    @ManyToOne ()
    @JoinTable(
            name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "tecnico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
    private List<Especialidad> especialidad;
    @OneToMany(mappedBy = "tecnico_id", cascade = CascadeType.ALL, orphanRemoval = true) // Relación uno a muchos con Incidente
    private List<Incidente> incidente;

    // Método para obtener las especialidades del técnico
    public List<String> getEspecialidades() {
        if (especialidad != null && !especialidad.isEmpty()) {
            return especialidad.stream()
                    .map(Especialidad::getNombreEspecialidad)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
