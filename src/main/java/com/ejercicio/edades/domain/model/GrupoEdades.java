package main.java.com.ejercicio.edades.domain.model;
public final class GrupoEdades {

    private static final int EDAD_MINIMA = 0;
    private static final int EDAD_MAXIMA = 120;

    private final int[] edades;

    public GrupoEdades(int[] edades) {

        if (edades == null || edades.length == 0) {
            throw new IllegalArgumentException(
                    "El grupo debe contener al menos una edad."
            );
        }

        this.edades = edades.clone();

        for (int edad : this.edades) {

            if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
                throw new IllegalArgumentException(
                        "Edad fuera del rango permitido: " + edad
                );
            }
        }
    }

    public int[] obtenerEdades() {
        return edades.clone();
    }

    public int cantidadPersonas() {
        return edades.length;
    }
}
