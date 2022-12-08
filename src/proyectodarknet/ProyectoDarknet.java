package proyectodarknet;

import constantes.Constantes;

import java.io.File;

import static archivos.Herramientas.Herramientas.vaciarDirectorio;
import static constantes.ConstantesDeEjecucion.*;

public class ProyectoDarknet implements Constantes {

    public static void main(String[] args) throws Exception {
        System.out.println("CPUs disponibles: " + Hilos);

        File directorioEntrada = new File(getRutaDirectorioEntrada());
        if (directorioEntrada.mkdirs()){
            System.out.println("Directorio creado: " + directorioEntrada.getAbsolutePath());
        }

        File directorioSalida = new File(getRutaDirectorioSalida());
        if (directorioSalida.mkdirs()){
            System.out.println("Directorio creado: " + directorioSalida.getAbsolutePath());
        }

        vaciarDirectorio(getRutaDirectorioProceso());

        new Formulario();
    }
    
}
