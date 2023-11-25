package com.proyecto.model.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

@Entity
@Table(name = "incidente")
public class Incidente {
    @Id
    @Column (name = "id_incidente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "descripcion_incidente")
    private String descripcionIncidente;
    @Column (name = "fecha_incidente")
    private LocalDateTime fechaIncidente;
    @Column (name = "fecha_solucion")
    private LocalDateTime fechaSolucion;
    @Column (name = "estado")
    private String estado;
    @Column (name = "observacion")
    private String observacion;
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "tecnico_id", referencedColumnName = "id")
    private Tecnico tecnico;
    @ManyToOne
    @JoinColumn(name = "tipo_problema_id", referencedColumnName = "id")
    private TipoProblema tipoProblema;
}
