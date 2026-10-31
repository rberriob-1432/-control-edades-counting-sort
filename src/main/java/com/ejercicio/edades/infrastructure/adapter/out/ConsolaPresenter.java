package main.java.com.ejercicio.edades.infrastructure.adapter.out;

import main.java.com.ejercicio.edades.application.port.out.PresentarResultadoPort;
import main.java.com.ejercicio.edades.domain.model.GrupoEdades;
import main.java.com.ejercicio.edades.domain.model.ResultadoCountingSort;

public final class ConsolaPresenter
        implements PresentarResultadoPort {

    @Override
    public void presentar(
            GrupoEdades grupo,
            ResultadoCountingSort resultado) {

        // 1. Mostrar edades originales.
        System.out.println("\n========== CONTROL DE EDADES ==========");

        System.out.println("\nEdades originales:");

        mostrarArreglo(grupo.obtenerEdades());

        // 2. Mostrar edad máxima.
        System.out.println(
                "\nEdad máxima: " + resultado.obtenerEdadMaxima()
        );

        // 3. Mostrar frecuencias.
        int[] frecuencias = resultado.obtenerFrecuencias();

        System.out.println("\nFrecuencias encontradas:");

        for (int edad = 0; edad < frecuencias.length; edad++) {

            System.out.printf(
                    "Edad %d: %d%n",
                    edad,
                    frecuencias[edad]
            );
        }

        // 4. Mostrar arreglo ordenado.
        System.out.println(
                "\nEdades ordenadas ascendentemente:"
        );

        mostrarArreglo(resultado.obtenerEdadesOrdenadas());

        // 5. Mostrar edades repetidas.
        System.out.println("\nEdades repetidas:");

        boolean hayRepetidas = false;

        for (int edad = 0; edad < frecuencias.length; edad++) {

            if (frecuencias[edad] > 1) {

                System.out.printf(
                        "Edad %d: %d veces%n",
                        edad,
                        frecuencias[edad]
                );

                hayRepetidas = true;
            }
        }

        if (!hayRepetidas) {
            System.out.println("No hay edades repetidas.");
        }

        System.out.println("\n=======================================");
    }

    private void mostrarArreglo(int[] valores) {

        System.out.print("[");

        for (int i = 0; i < valores.length; i++) {

            System.out.print(valores[i]);

            if (i < valores.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
