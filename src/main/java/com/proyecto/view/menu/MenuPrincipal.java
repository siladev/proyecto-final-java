package com.proyecto.view.menu;
import com.proyecto.controller.repositories.ClienteRepository;
import com.proyecto.controller.repositories.ServicioRepository;
import com.proyecto.controller.repositories.IncidenteRepository;
import com.proyecto.controller.repositories.TecnicoRepository;
import com.proyecto.controller.repositories.TipoProblemaRepository;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private ClienteRepository clienteRepository;
    private ServicioRepository servicioRepository;
    private IncidenteRepository incidenteRepository;
    private TecnicoRepository tecnicoRepository;
    private TipoProblemaRepository tipoProblemaRepository;

    public MenuPrincipal(ClienteRepository clienteRepository, ServicioRepository servicioRepository, IncidenteRepository incidenteRepository, TecnicoRepository tecnicoRepository, TipoProblemaRepository tipoProblemaRepository) {
        this.scanner = new Scanner(System.in);
        this.clienteRepository = clienteRepository;
        this.servicioRepository = servicioRepository;
        this.incidenteRepository = incidenteRepository;
        this.tecnicoRepository = tecnicoRepository;
        this.tipoProblemaRepository = tipoProblemaRepository;
    }

    public void mostrarMenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Menú de RRHH");
            System.out.println("2. Menú de Área Comercial");
            System.out.println("3. Menú de Mesa de Ayuda");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opción:");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (opcion) {
                case 1:
                    RRHHMenu rrhhMenu = new RRHHMenu();
                    rrhhMenu.mostrarMenu();
                    break;
                case 2:
                    AreaComercialMenu areaComercialMenu = new AreaComercialMenu(clienteRepository);
                    areaComercialMenu.mostrarMenu();
                    break;
                case 3:
                    MesaAyudaMenu mesaAyudaMenu = new MesaAyudaMenu(clienteRepository, servicioRepository, incidenteRepository, tecnicoRepository, tipoProblemaRepository);
                    mesaAyudaMenu.mostrarMenu();
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
}