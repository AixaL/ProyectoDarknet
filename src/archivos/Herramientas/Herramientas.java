package archivos.Herramientas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Herramientas {

    public static int getNumeroDeLineas(String ruta) {
        int cantidad = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(ruta));

            while (reader.readLine() != null) {
                cantidad++;
            }
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo");
        }

        return cantidad;
    }

    public static void vaciarDirectorio(String ruta) {
        File directorio = new File(ruta);

        try {
            if (!directorio.exists()) {
                directorio.mkdirs();
            } else {
                for (File file: directorio.listFiles()) {
                    file.delete();
                }
                System.out.println("Directorio: " + directorio + " vaciado con exito");
            }
        } catch (SecurityException securityException) {
            System.out.println("Manager de seguridad no permite la creación de directorios");
        }
    }

    public static String getNombreSubArchivo(int numeroArchivo) {
        return "FileNumber_" + numeroArchivo + ".csv";
    }
}
