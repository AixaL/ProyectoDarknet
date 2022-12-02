package proyectodarknet;

import archivos.Archivo;
import constantes.Constantes;
import procesamiento.manager.Manager;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import static constantes.ConstantesDeEjecucion.*;

/**
 *
 * @author 93004
 */
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

            //Scanner teclado2 = new Scanner(System.in);
            //String columnas = teclado2.nextLine();
            
            //System.out.println(columnas);
            
            System.out.println("Ingresa el criterio: ");
            //Scanner teclado3 = new Scanner(System.in);
            //String criterio = teclado3.nextLine();
            
            //System.out.println(criterio);

             //Archivo read = new Archivo();
             Archivo.procesarArchivo(getRutaArchivoEntrada());

             new Manager();
             
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Error en la entrada " + e);
        }
        
    }
    
}
