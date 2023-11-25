package com.proyecto.view.menu;

import com.proyecto.model.entities.Especialidad;
import com.proyecto.model.entities.Tecnico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RRHHMenu {
    private Scanner scanner;
    private List<Tecnico> tecnicos;

    public RRHHMenu() {
        scanner = new Scanner(System.in);
        tecnicos = new ArrayList<>();
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú de RRHH ===");
            System.out.println("1. Alta de Técnico");
            System.out.println("2. Baja de Técnico");
            System.out.println("3. Modificación de Técnico");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opción:");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (opcion) {
                case 1:
                    altaTecnico();
                    break;
                case 2:
                    bajaTecnico();
                    break;
                case 3:
                    modificarTecnico();
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

    public void altaTecnico() {
        System.out.println("Ingrese el nombre del técnico:");
        String nombreTecnico = scanner.nextLine();

        List<Especialidad> especialidades = new ArrayList<>();
        boolean agregarEspecialidad = true;

        while (agregarEspecialidad) {
            System.out.println("Ingrese el nombre de la especialidad:");
            String nombreEspecialidad = scanner.nextLine();

            Especialidad especialidad = new Especialidad(nombreEspecialidad);
            especialidades.add(especialidad);

            System.out.println("¿Desea agregar otra especialidad? (S/N)");
            String respuesta = scanner.nextLine();

            agregarEspecialidad = respuesta.equalsIgnoreCase("S");
        }

        Tecnico tecnico = new Tecnico();
        tecnico.setNombreTecnico(nombreTecnico);
        tecnico.setEspecialidad(especialidades);

        tecnicos.add(tecnico);

        System.out.println("Técnico agregado correctamente.");
    }

    public void bajaTecnico() {
        System.out.println("Ingrese el ID del técnico a dar de baja:");
        int idTecnico = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean encontrado = false;
        Tecnico tecnicoEncontrado = null;

        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getId() == idTecnico) {
                encontrado = true;
                tecnicoEncontrado = tecnico;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Técnico encontrado:");
            System.out.println("ID: " + tecnicoEncontrado.getId());
            System.out.println("Nombre: " + tecnicoEncontrado.getNombreTecnico());

            System.out.println("¿Está seguro de que desea dar de baja a este técnico? (si/no)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                tecnicos.remove(tecnicoEncontrado);
                System.out.println("Técnico dado de baja correctamente.");
            } else {
                System.out.println("Operación cancelada. El técnico no ha sido dado de baja.");
            }
        } else {
            System.out.println("No se encontró ningún técnico con el ID especificado.");
        }
    }
    public void modificarTecnico() {
        System.out.println("Ingrese el ID del técnico a modificar:");
        int idTecnico = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        boolean encontrado = false;
        Tecnico tecnicoEncontrado = null;

        for (Tecnico tecnico : tecnicos) {
            if (tecnico.getId() == idTecnico) {
                encontrado = true;
                tecnicoEncontrado = tecnico;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Técnico encontrado:");
            System.out.println("ID: " + tecnicoEncontrado.getId());
            System.out.println("Nombre: " + tecnicoEncontrado.getNombreTecnico());

            System.out.println("¿Desea modificar las especialidades del técnico? (si/no)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                List<Especialidad> especialidades = tecnicoEncontrado.getEspecialidad();

                boolean agregarEspecialidad = true;

                while (agregarEspecialidad) {
                    System.out.println("Ingrese el nombre de la especialidad:");
                    String nombreEspecialidad = scanner.nextLine();

                    Especialidad especialidad = new Especialidad(nombreEspecialidad);
                    especialidades.add(especialidad);

                    System.out.println("¿Desea agregar otra especialidad? (si/no)");
                    respuesta = scanner.nextLine();

                    agregarEspecialidad = respuesta.equalsIgnoreCase("si");
                }

                System.out.println("¿Está seguro de que desea modificar las especialidades de este técnico? (si/no)");
                respuesta = scanner.nextLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    System.out.println("Especialidades del técnico modificadas correctamente.");
                } else {
                    System.out.println("Operación cancelada. Las especialidades del técnico no han sido modificadas.");
                }
            } else {
                System.out.println("Operación cancelada. No se realizaron modificaciones en las especialidades del técnico.");
            }
        } else {
            System.out.println("No se encontró ningún técnico con el ID especificado.");
        }
    }
}

