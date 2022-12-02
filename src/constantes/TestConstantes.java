package constantes;

import static archivos.Herramientas.Herramientas.*;
import static constantes.ConstantesDeEjecucion.*;

public class TestConstantes implements Constantes {
    public static void main(String[] args) {
        System.out.println("CPUs disponibles     :\t" + Hilos);
        System.out.println("Archivos por hilo    :\t" + ArchivosTotales);
        System.out.println("Ruta de ejecución    :\t" + RutaEjecucion);

        System.out.println("Ruta de proceso      :\t" + getRutaDirectorioProceso());
        vaciarDirectorio(getRutaDirectorioProceso());
        System.out.println("Ruta de salida       :\t" + getRutaDirectorioSalida());
        vaciarDirectorio(getRutaDirectorioSalida());

        System.out.println("Ruta Archivo Entrada :\t" + getRutaArchivoEntrada());
        System.out.println("Ruta Archivo Salida  :\t" + getRutaArchivoSalida());
    }
}
