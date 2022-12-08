package constantes;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface Constantes {
    int    Hilos                = Runtime.getRuntime().availableProcessors();
    int    ArchivosPorHilo      = 1;
    int    ArchivosPorCPU       = 4;
    int    ArchivosTotales      = Hilos * ArchivosPorCPU;
    Path   RutaEjecucion        = Paths.get("").toAbsolutePath();
    String FormatoArchivo       = ".csv";
    String NombreArchivoEntrada = "Darknet";
    String EtiquetaSalida       = "_filtered";
}
