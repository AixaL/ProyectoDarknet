package constantes;

import java.io.File;

public class ConstantesDeEjecucion implements Constantes {

    private static final String RutaArchivos        = RutaEjecucion + File.separator + ("Archivos");
    private static final String RutaArchivosEntrada = RutaArchivos + File.separator + ("Entrada");
    private static final String RutaArchivosProceso = RutaArchivos + File.separator + ("Proceso");
    private static final String RutaArchivosSalida  = RutaArchivos + File.separator + ("Salida");
    private static final String ArchivoEntrada      = RutaArchivosEntrada + File.separator + NombreArchivoEntrada;
    private static final String ArchivoSalida       = RutaArchivosSalida  + File.separator + NombreArchivoSalida;

    public static String getRutaProceso() {
        return RutaArchivosProceso;
    }

    public static String getRutaSalida() {
        return RutaArchivosSalida;
    }

    public static String getRutaArchivoEntrada() {
        return ArchivoEntrada;
    }

    public static String getRutaArchivoSalida() {
        return ArchivoSalida;
    }
}
