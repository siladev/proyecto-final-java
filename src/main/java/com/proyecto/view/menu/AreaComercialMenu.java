package com.proyecto.view.menu;

import java.util.Scanner;
import java.util.Optional;
import com.proyecto.model.entities.Cliente;
import com.proyecto.controller.repositories.ClienteRepository;

public class AreaComercialMenu {
    private Scanner scanner;
    private ClienteRepository clienteRepository;

    public AreaComercialMenu(ClienteRepository clienteRepository) {
        this.scanner = new Scanner(System.in);
        this.clienteRepository = clienteRepository;
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de Área Comercial ===");
            System.out.println("1. Alta de Cliente");
            System.out.println("2. Baja de Cliente");
            System.out.println("3. Modificación de Cliente");
            System.out.println("4. Volver al Menú Principal");
            System.out.println("Ingrese una opción:");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:
                    bajaCliente();
                    break;
                case 3:
                    modificarCliente();
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

    private void altaCliente() {
        System.out.println("Ingrese la razón social del cliente:");
        String razonSocial = scanner.nextLine();

        System.out.println("Ingrese el CUIT del cliente:");
        String cuit = scanner.nextLine();

        System.out.println("Ingrese el email del cliente:");
        String email = scanner.nextLine();

        System.out.println("Ingrese el teléfono del cliente:");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setRazonSocial(razonSocial);
        cliente.setCuit(cuit);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);

        clienteRepository.save(cliente);

        System.out.println("Cliente dado de alta correctamente.");
    }

    private void bajaCliente() {
        System.out.println("=== Dar de Baja Cliente ===");

        System.out.println("Ingrese el ID del cliente a dar de baja:");
        int clienteId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        Cliente cliente = clienteOptional.orElse(null);

        if (cliente != null) {
            System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getRazonSocial());

            System.out.println("¿Está seguro de eliminar al cliente " + cliente.getRazonSocial() + "? (si/no)");
            String confirmacion = scanner.nextLine();

            if (confirmacion.equalsIgnoreCase("si")) {
                clienteRepository.delete(cliente);
                System.out.println("Cliente dado de baja correctamente.");
            } else {
                System.out.println("Operación cancelada.");
            }
        } else {
            System.out.println("No se encontró un cliente con el ID especificado.");
        }
    }
    private void modificarCliente() {
        System.out.println("Ingrese el ID del cliente a modificar:");
        int clienteId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        Cliente cliente = clienteOptional.orElse(null);

        if (cliente != null) {
            System.out.println("Ingrese el nuevo email del cliente:");
            String email = scanner.nextLine();

            System.out.println("Ingrese el nuevo teléfono del cliente:");
            String telefono = scanner.nextLine();

            cliente.setEmail(email);
            cliente.setTelefono(telefono);

            clienteRepository.save(cliente);

            System.out.println("Cliente modificado correctamente.");
        } else {
            System.out.println("No se encontró un cliente con el ID especificado.");
        }
    }

}

