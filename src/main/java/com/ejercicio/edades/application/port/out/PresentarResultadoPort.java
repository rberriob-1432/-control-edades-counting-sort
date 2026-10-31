package main.java.com.ejercicio.edades.application.port.out;
import main.java.com.ejercicio.edades.domain.model.GrupoEdades;
import main.java.com.ejercicio.edades.domain.model.ResultadoCountingSort;
public interface PresentarResultadoPort {

    void presentar(
            GrupoEdades grupoOriginal,
            ResultadoCountingSort resultado
    );
}
