package main.java.com.ejercicio.edades.domain.model;
public final class ResultadoCountingSort {

    private final int edadMaxima;
    private final int[] frecuencias;
    private final int[] edadesOrdenadas;

    public ResultadoCountingSort(
            int edadMaxima,
            int[] frecuencias,
            int[] edadesOrdenadas) {

        if (edadMaxima < 0
                || frecuencias == null
                || edadesOrdenadas == null
                || frecuencias.length != edadMaxima + 1) {

            throw new IllegalArgumentException(
                    "Los datos del resultado no son válidos."
            );
        }

        this.edadMaxima = edadMaxima;
        this.frecuencias = frecuencias.clone();
        this.edadesOrdenadas = edadesOrdenadas.clone();
    }

    public int obtenerEdadMaxima() {
        return edadMaxima;
    }

    public int[] obtenerFrecuencias() {
        return frecuencias.clone();
    }

    public int[] obtenerEdadesOrdenadas() {
        return edadesOrdenadas.clone();
    }
}
