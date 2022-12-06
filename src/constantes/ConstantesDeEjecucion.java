package constantes;

import java.io.File;
import java.time.ZonedDateTime;

public class ConstantesDeEjecucion implements Constantes {

    private static final String RutaArchivos          = RutaEjecucion + File.separator + ("Archivos");
    private static final String RutaDirectorioEntrada = RutaArchivos + File.separator + ("Entrada");
    private static final String RutaDirectorioProceso = RutaArchivos + File.separator + ("Proceso");
    private static final String RutaDirectorioSalida  = RutaArchivos + File.separator + ("Salida");

    private static String RutaArchivoEntrada = RutaDirectorioEntrada + File.separator + NombreArchivoEntrada + FormatoArchivo;
    private static String RutaArchivoSalida  = "";

    public static String getRutaDirectorioEntrada() {
        return RutaDirectorioEntrada;
    }

    public static String getRutaDirectorioProceso() {
        return RutaDirectorioProceso;
    }

    public static String getRutaDirectorioSalida() {
        return RutaDirectorioSalida;
    }

    private static void setRutaArchivoSalida() {
        final String nombreArchivoOrigen =
                RutaArchivoEntrada.substring(
                    RutaArchivoEntrada.lastIndexOf(File.separator) + 1,
                    RutaArchivoEntrada.lastIndexOf(FormatoArchivo)
                );

        final ZonedDateTime FechaTiempoActual = ZonedDateTime.now();

        final String aaaa = String.valueOf(FechaTiempoActual.getYear());
        final String mm   = String.format("%02d", FechaTiempoActual.getMonthValue());
        final String dd   = String.format("%02d", FechaTiempoActual.getDayOfMonth());
        final String hr   = String.format("%02d", FechaTiempoActual.getHour());
        final String min  = String.format("%02d", FechaTiempoActual.getMinute());

        String nombreArchivoSalida = (nombreArchivoOrigen + EtiquetaSalida + "(" + aaaa + mm + dd + "_" + hr + min + ")");

        RutaArchivoSalida = RutaDirectorioSalida + File.separator + nombreArchivoSalida + FormatoArchivo;
    }

    public static String getRutaArchivoSalida() {
        setRutaArchivoSalida();
        return RutaArchivoSalida;
    }

    public static void setRutaArchivoEntrada(String rutaArchivoEntrada) {
        RutaArchivoEntrada = rutaArchivoEntrada;
    }

    public static String getRutaArchivoEntrada() {
        return RutaArchivoEntrada;
    }


}
