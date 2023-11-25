package com.proyecto.model.entities;

import java.util.List;

import com.proyecto.model.entities.Especialidad;
import com.proyecto.model.entities.Incidente;
import jakarta.persistence.*;
import lombok.*;
@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

@Entity
@Table(name = "tipo_problema")
public class TipoProblema {
    @Id
    @Column (name = "tipo_problema_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "nombre_problema")
    private String nombreProblema;
    @Column (name = "tiempo_resolucion")
    private int tiempoResolucion; // en minutos
    @ManyToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "id")
    private Especialidad especialidad;
    @OneToMany(mappedBy = "tipo_problema_id", cascade = CascadeType.ALL, orphanRemoval = true) // Relación uno a muchos con Incidente
    private List<Incidente> incidente;
}
