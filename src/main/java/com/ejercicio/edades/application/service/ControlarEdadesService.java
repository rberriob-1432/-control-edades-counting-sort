package main.java.com.ejercicio.edades.application.service;
import main.java.com.ejercicio.edades.application.port.in.ControlarEdadesUseCase;
import main.java.com.ejercicio.edades.application.port.out.PresentarResultadoPort;
import main.java.com.ejercicio.edades.domain.model.GrupoEdades;
import main.java.com.ejercicio.edades.domain.model.ResultadoCountingSort;

import java.util.Objects;

public final class ControlarEdadesService
        implements ControlarEdadesUseCase {

    private final PresentarResultadoPort presenter;

    public ControlarEdadesService(
            PresentarResultadoPort presenter) {

        this.presenter = Objects.requireNonNull(
                presenter,
                "El presentador no puede ser nulo."
        );
    }

    @Override
    public void ejecutar(int[] edades) {
        GrupoEdades grupo = new GrupoEdades(edades);

        int[] valores = grupo.obtenerEdades();
        int maximo = valores[0];

        for (int i = 1; i < valores.length; i++) {

            if (valores[i] > maximo) {
                maximo = valores[i];
            }
        }

        int[] frecuencias = new int[maximo + 1];


        for (int edad : valores) {
            frecuencias[edad]++;
        }

        int[] ordenadas = new int[valores.length];

        int posicion = 0;

        for (int edad = 0; edad <= maximo; edad++) {

            for (int cantidad = 0;
                 cantidad < frecuencias[edad];
                 cantidad++) {

                ordenadas[posicion] = edad;
                posicion++;
            }
        }

        ResultadoCountingSort resultado =
                new ResultadoCountingSort(
                        maximo,
                        frecuencias,
                        ordenadas
                );
        presenter.presentar(grupo, resultado);
    }
}
