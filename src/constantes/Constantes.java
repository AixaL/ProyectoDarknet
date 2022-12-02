package constantes;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface Constantes {
    int    Hilos                = Runtime.getRuntime().availableProcessors();
    int    ArchivosPorHilo      = 4;
    int    ArchivosTotales      = Hilos * ArchivosPorHilo;
    Path   RutaEjecucion        = Paths.get("").toAbsolutePath();
    String NombreArchivoEntrada = "Darknet.csv";
    String NombreArchivoSalida  = "Resultados.csv";
}
