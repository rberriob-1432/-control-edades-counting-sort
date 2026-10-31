package main.java.com.ejercicio.edades;
import main.java.com.ejercicio.edades.application.port.in.ControlarEdadesUseCase;
import main.java.com.ejercicio.edades.application.port.out.PresentarResultadoPort;
import main.java.com.ejercicio.edades.application.service.ControlarEdadesService;
import main.java.com.ejercicio.edades.insfraestructure.adapter.in.ConsolaAdapter;
import main.java.com.ejercicio.edades.insfraestructure.adapter.out.ConsolaPresenter;

import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            // Crear adaptador de salida.
            PresentarResultadoPort presenter =
                    new ConsolaPresenter();

            // Crear servicio de aplicación.
            ControlarEdadesUseCase casoDeUso =
                    new ControlarEdadesService(presenter);

            // Crear adaptador de entrada.
            ConsolaAdapter consola =
                    new ConsolaAdapter(casoDeUso, scanner);

            // Iniciar aplicación.
            consola.iniciar();
        }
    }
}
