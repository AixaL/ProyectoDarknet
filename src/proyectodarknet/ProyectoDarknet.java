package proyectodarknet;

import archivos.Archivo;
import constantes.Constantes;
import procesamiento.manager.Manager;

import java.util.InputMismatchException;
import java.util.Scanner;

import static constantes.ConstantesDeEjecucion.getRutaArchivoEntrada;

/**
 *
 * @author 93004
 */
public class ProyectoDarknet implements Constantes {

    public static void main(String[] args) throws Exception {

        System.out.println("CPUs disponibles: " + Hilos);

        System.out.println("Ingresa la ruta del archivo: ");
        try {

            System.out.println("Ingresa las columnas: ");
            //Scanner teclado2 = new Scanner(System.in);
            //String columnas = teclado2.nextLine();
            
            //System.out.println(columnas);
            
            System.out.println("Ingresa el criterio: ");
            //Scanner teclado3 = new Scanner(System.in);
            //String criterio = teclado3.nextLine();
            
            //System.out.println(criterio);

             //Archivo read = new Archivo();
             Archivo.procesarArchivo(getRutaArchivoEntrada());

             Manager m = new Manager();
             m.manager();
             
        } catch (InputMismatchException ex ) {
            System.out.println(ex);
        }
        
    }
    
}
