package constantes;

import java.io.File;

public class ConstantesDeEjecucion implements Constantes {

    private static final String RutaArchivos          = RutaEjecucion + File.separator + ("Archivos");
    private static final String RutaDirectorioEntrada = RutaArchivos + File.separator + ("Entrada");
    private static final String RutaDirectorioProceso = RutaArchivos + File.separator + ("Proceso");
    private static final String RutaDirectorioSalida  = RutaArchivos + File.separator + ("Salida");
    private static final String ArchivoSalida         = RutaDirectorioSalida + File.separator + NombreArchivoSalida;

    private static String RutaArchivoEntrada = RutaDirectorioEntrada + File.separator + NombreArchivoEntrada;

    public static String getRutaDirectorioEntrada() {
        return RutaDirectorioEntrada;
    }

    public static String getRutaDirectorioProceso() {
        return RutaDirectorioProceso;
    }

    public static String getRutaDirectorioSalida() {
        return RutaDirectorioSalida;
    }

    public static String getRutaArchivoSalida() {
        return ArchivoSalida;
    }

    public static String getRutaArchivoEntrada() {
        return RutaArchivoEntrada;
    }

    public static void setRutaArchivoEntrada(String rutaArchivoEntrada) {
        RutaArchivoEntrada = rutaArchivoEntrada;
    }
}
