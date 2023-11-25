package com.proyecto.model.entities;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;
@Data  // genera automáticamente los métodos toString, equals, hashCode, getter y setter
@NoArgsConstructor // genera un constructor sin argumentos.
@AllArgsConstructor // genera un constructor que incluye todos los campos de la clase

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column (name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "razon_social")
    private String razonSocial;
    @Column (name = "cuit")
    private String cuit;
    @Column (name = "email")
    private String email;
    @Column (name = "telefono")
    private String telefono;
    @ManyToMany () // Relación muchos a muchos con Servicio
    @JoinTable(
            name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> cliente_servicio; // Lista de servicios asociados al cliente
    @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.ALL, orphanRemoval = true) // Relación uno a muchos con Incidente
    private List<Incidente> incidente;

}
