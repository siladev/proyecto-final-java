package com.proyecto.view.menu;
import com.proyecto.controller.repositories.*;
import com.proyecto.model.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class MesaAyudaMenu {
    private Scanner scanner;
    private ClienteRepository clienteRepository;
    private ServicioRepository servicioRepository;
    private IncidenteRepository incidenteRepository;
    private TecnicoRepository tecnicoRepository;
    private TipoProblemaRepository tipoProblemaRepository;

    @Autowired
    public MesaAyudaMenu(ClienteRepository clienteRepository, ServicioRepository servicioRepository, IncidenteRepository incidenteRepository, TecnicoRepository tecnicoRepository, TipoProblemaRepository tipoProblemaRepository) {
        this.clienteRepository = clienteRepository;
        this.servicioRepository = servicioRepository;
        this.incidenteRepository = incidenteRepository;
        this.tecnicoRepository = tecnicoRepository;
        this.tipoProblemaRepository = tipoProblemaRepository;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("----- MENÚ MESA DE AYUDA -----");
            System.out.println("1. Reportar incidente");
            System.out.println("2. Modificar incidente");
            System.out.println("3. Eliminar incidente");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (opcion) {
                case 1:
                    reportarIncidente();
                    break;
                case 2:
                    modificarIncidente();
                    break;
                case 3:
                    eliminarIncidente();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        }
    }

    private void reportarIncidente() {
        System.out.println("----- REPORTAR INCIDENTE -----");

        // Solicitar datos del cliente
        System.out.println("Ingrese la razón social del cliente:");
        String razonSocial = scanner.nextLine();

        System.out.println("Ingrese el CUIT del cliente:");
        String cuit = scanner.nextLine();

        // Buscar al cliente en el repositorio
        Optional<Cliente> clienteOptional = clienteRepository.findByRazonSocialAndCuit(razonSocial, cuit);
        Cliente cliente = clienteOptional.orElse(null);

        if (cliente != null) {
            // Mostrar los servicios contratados por el cliente
            List<Servicio> servicios = cliente.getCliente_servicio();

            System.out.println("Servicios contratados por el cliente:");
            for (Servicio servicio : servicios) {
                System.out.println(servicio.getId() + ". " + servicio.getNombreServicio());
            }
            // Solicitar el servicio para reportar el incidente
            System.out.println("Ingrese el ID del servicio para reportar el incidente:");
            int servicioId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Optional<Servicio> servicioOptional = servicioRepository.findById(servicioId);
            Servicio servicio = servicioOptional.orElse(null);

            if (servicio != null) {
                // Solicitar descripción del problema
                System.out.println("Ingrese la descripción del problema:");
                String descripcion = scanner.nextLine();

                // Solicitar tipo de problema
                System.out.println("Ingrese el ID del tipo de problema:");
                int tipoProblemaId = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                Optional<TipoProblema> tipoProblemaOptional = tipoProblemaRepository.findById(tipoProblemaId);
                TipoProblema tipoProblema = tipoProblemaOptional.orElse(null);

                if (tipoProblema != null) {
                    // Obtener la especialidad del tipo de problema
                    Especialidad especialidad = tipoProblema.getEspecialidad();
                    String especialidadString = especialidad.getNombreEspecialidad();
                    // Obtener técnicos disponibles para resolver el problema
                    List<Tecnico> tecnicosDisponibles = tecnicoRepository.findByEspecialidad(especialidadString);

                    // Mostrar los técnicos disponibles
                    System.out.println("Técnicos disponibles:");
                    for (Tecnico tecnico : tecnicosDisponibles) {
                        System.out.println(tecnico.getId() + ". " + tecnico.getNombreTecnico());
                    }

                    // Solicitar el técnico para resolver el problema
                    System.out.println("Ingrese el ID del técnico para resolver el problema:");
                    int tecnicoId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Optional<Tecnico> tecnicoOptional = tecnicoRepository.findById(tecnicoId);
                    Tecnico tecnico = tecnicoOptional.orElse(null);

                    if (tecnico != null) {
                        // Calcular fecha estimada de resolución
                        LocalDateTime fechaIncidente = LocalDateTime.now();
                        LocalDateTime fechaSolucion = fechaIncidente.plusHours(tipoProblema.getTiempoResolucion());

                        // Crear el objeto Incidente
                        Incidente incidente = new Incidente();
                        incidente.setDescripcionIncidente(descripcion);
                        incidente.setFechaIncidente(fechaIncidente);
                        incidente.setFechaSolucion(fechaSolucion);
                        incidente.setEstado("Pendiente");
                        incidente.setCliente(cliente);
                        incidente.setServicio(servicio);
                        incidente.setTecnico(tecnico);
                        incidente.setTipoProblema(tipoProblema);

                        // Guardar el incidente en el repositorio
                        incidenteRepository.save(incidente);

                        System.out.println("Incidente reportado correctamente.");
                    } else {
                        System.out.println("No se encontró un técnico con el ID especificado.");
                    }
                } else {
                    System.out.println("No se encontró un tipo de problema con el ID especificado.");
                }
            } else {
                System.out.println("No se encontró un servicio con el ID especificado.");
            }
        } else {
            System.out.println("No se encontró un cliente con la razón social y CUIT especificados.");
        }
    }

    private void modificarIncidente() {
        // Implementar lógica para modificar un incidente existente
    }

    private void eliminarIncidente() {
        // Implementar lógica para eliminar un incidente existente
    }
}
