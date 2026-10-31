package test.java.com.ejercicio.edades.application.service;
import main.java.com.ejercicio.edades.application.port.out.PresentarResultadoPort;
import main.java.com.ejercicio.edades.application.service.ControlarEdadesService;
import main.java.com.ejercicio.edades.domain.model.ResultadoCountingSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlarEdadesServiceTest {

    @Test
    void debeOrdenarEdadesAscendentemente() {

        ResultadoCountingSort[] recibido = new ResultadoCountingSort[1];

        PresentarResultadoPort presenter = (grupo, resultado) -> {
            recibido[0] = resultado;
        };

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        service.ejecutar(
                new int[]{18, 25, 18, 30, 20, 25, 18, 22}
        );

        assertArrayEquals(
                new int[]{18, 18, 18, 20, 22, 25, 25, 30},
                recibido[0].obtenerEdadesOrdenadas()
        );
    }

    @Test
    void debeContarCorrectamenteLasEdadesRepetidas() {

        ResultadoCountingSort[] recibido = new ResultadoCountingSort[1];

        PresentarResultadoPort presenter = (grupo, resultado) -> {
            recibido[0] = resultado;
        };

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        service.ejecutar(new int[]{20, 20, 20, 25, 25});

        int[] frecuencias = recibido[0].obtenerFrecuencias();

        assertEquals(3, frecuencias[20]);
        assertEquals(2, frecuencias[25]);
    }

    @Test
    void debeEncontrarLaEdadMaxima() {

        ResultadoCountingSort[] recibido = new ResultadoCountingSort[1];

        PresentarResultadoPort presenter = (grupo, resultado) -> {
            recibido[0] = resultado;
        };

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        service.ejecutar(new int[]{12, 35, 20, 18});

        assertEquals(35, recibido[0].obtenerEdadMaxima());
    }

    @Test
    void debeAceptarUnaEdadIgualACero() {

        ResultadoCountingSort[] recibido = new ResultadoCountingSort[1];

        PresentarResultadoPort presenter = (grupo, resultado) -> {
            recibido[0] = resultado;
        };

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        service.ejecutar(new int[]{5, 0, 2});

        assertArrayEquals(
                new int[]{0, 2, 5},
                recibido[0].obtenerEdadesOrdenadas()
        );
    }

    @Test
    void debeOrdenarCuandoTodasLasEdadesSonIguales() {

        ResultadoCountingSort[] recibido = new ResultadoCountingSort[1];

        PresentarResultadoPort presenter = (grupo, resultado) -> {
            recibido[0] = resultado;
        };

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        service.ejecutar(new int[]{15, 15, 15, 15});

        assertArrayEquals(
                new int[]{15, 15, 15, 15},
                recibido[0].obtenerEdadesOrdenadas()
        );

        assertEquals(
                4,
                recibido[0].obtenerFrecuencias()[15]
        );
    }

    @Test
    void debeRechazarUnGrupoVacio() {

        PresentarResultadoPort presenter = (grupo, resultado) -> {};

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.ejecutar(new int[]{})
        );
    }

    @Test
    void debeRechazarEdadesNegativas() {

        PresentarResultadoPort presenter = (grupo, resultado) -> {};

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.ejecutar(new int[]{18, -1})
        );
    }

    @Test
    void debeRechazarEdadesMayoresA120() {

        PresentarResultadoPort presenter = (grupo, resultado) -> {};

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.ejecutar(new int[]{18, 121})
        );
    }

    @Test
    void noDebeModificarElArregloOriginal() {

        int[] edades = {30, 20, 10};

        PresentarResultadoPort presenter = (grupo, resultado) -> {};

        ControlarEdadesService service =
                new ControlarEdadesService(presenter);

        service.ejecutar(edades);

        assertArrayEquals(
                new int[]{30, 20, 10},
                edades
        );
    }
}
