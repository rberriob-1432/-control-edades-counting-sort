package main.java.com.ejercicio.edades.infrastructure.adapter.in;
import main.java.com.ejercicio.edades.application.port.in.ControlarEdadesUseCase;

import java.util.Objects;
import java.util.Scanner;

public final class ConsolaAdapter {

    private final ControlarEdadesUseCase casoDeUso;
    private final Scanner scanner;

    public ConsolaAdapter(
            ControlarEdadesUseCase casoDeUso,
            Scanner scanner) {

        this.casoDeUso = Objects.requireNonNull(casoDeUso);
        this.scanner = Objects.requireNonNull(scanner);
    }

    public void iniciar() {

        int cantidad;

        do {

            cantidad = leerEntero("Cantidad de personas: ");

            if (cantidad <= 0) {
                System.out.println(
                        "Debe ingresar al menos una persona."
                );
            }

        } while (cantidad <= 0);

        int[] edades = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {

            int edad;

            do {

                edad = leerEntero(
                        "Edad de la persona " + (i + 1) + ": "
                );

                if (edad < 0 || edad > 120) {
                    System.out.println(
                            "La edad debe estar entre 0 y 120."
                    );
                }

            } while (edad < 0 || edad > 120);

            edades[i] = edad;
        }

        // Delegar la operación al caso de uso.
        casoDeUso.ejecutar(edades);
    }

    private int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println(
                    "Entrada inválida. Debe ingresar un número entero."
            );

            scanner.next();
        }
    }
}
