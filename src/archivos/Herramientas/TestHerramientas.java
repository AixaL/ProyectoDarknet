package archivos.Herramientas;

import java.io.File;
import java.io.IOException;

import static archivos.Herramientas.Herramientas.vaciarDirectorio;
import static constantes.ConstantesDeEjecucion.*;

public class TestHerramientas {
    static String archivoTemp = getRutaDirectorioProceso() + File.separator + "temp.txt";

    public static void main(String[] args) throws IOException {
        System.out.println("Número de líneas en "+ getRutaArchivoEntrada() + " : " + Herramientas.getNumeroDeLineas(getRutaArchivoEntrada()));

        System.out.println("-----------------------------------------------------------------------------------------");

        File temp = new File(archivoTemp);
        System.out.println("Archivo temporal creado con exito: " + temp.createNewFile());
        vaciarDirectorio(getRutaDirectorioProceso());
        System.out.println("Archivo temporal borrado con exito: " + !temp.exists());
    }
}
