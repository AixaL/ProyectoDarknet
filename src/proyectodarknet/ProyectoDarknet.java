package proyectodarknet;

import constantes.Constantes;

import java.io.File;

import static constantes.ConstantesDeEjecucion.getRutaDirectorioEntrada;

public class ProyectoDarknet implements Constantes {

    public static void main(String[] args) throws Exception {

        new Formulario();

        System.out.println("CPUs disponibles: " + Hilos);

        File directorioEntrada = new File(getRutaDirectorioEntrada());
        if (directorioEntrada.mkdirs()){
            System.out.println("Directorio creado: " + directorioEntrada.getAbsolutePath());
        }
        
    }
    
}
