package proyectodarknet;

import archivos.Archivo;
import constantes.Constantes;
import procesamiento.manager.Manager;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import static constantes.ConstantesDeEjecucion.*;

public class ProyectoDarknet implements Constantes {

    public static void main(String[] args) throws Exception {

        System.out.println("CPUs disponibles: " + Hilos);

        System.out.println("Ingresa la ruta del archivo: ");
        try {
            File directorioEntrada = new File(getRutaDirectorioEntrada());
            if (directorioEntrada.mkdirs()){
                System.out.println("Directorio creado: " + directorioEntrada.getAbsolutePath());
            }

            System.out.println("Ingresa la ruta del archivo o presione ENTER para ruta defecto (/Archivos/Entrada/Darknet.csv): ");
            Scanner teclado = new Scanner(System.in);
            String  ruta    = teclado.nextLine();

            if (!ruta.isBlank()) {
                setRutaArchivoEntrada(ruta);
                System.out.println("Nueva ruta: " + getRutaArchivoEntrada());
            }

            System.out.println("Ingresa las columnas deseadas (C00 - C84): ");
            String columnasRequeridas = teclado.nextLine();
            
            System.out.println("Ingresa el criterio de filtrado (CXX >|<|= Y): ");
            String criterioFiltrado = teclado.nextLine();

             Archivo.procesarArchivo(getRutaArchivoEntrada());

             new Manager();
             
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Error en la entrada " + e);
        }
        
    }
    
}
