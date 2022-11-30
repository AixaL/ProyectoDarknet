package proyectodarknet;
import archivos.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import procesamiento.manager.*;
/**
 *
 * @author 93004
 */
public class ProyectoDarknet {
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int CPUs = Runtime.getRuntime().availableProcessors();
        System.out.println(CPUs);
        
//        Formulario form = new Formulario();
        
        System.out.println("Ingresa la ruta del archivo: ");
        try{
            Scanner teclado = new Scanner(System.in);
            String ruta = teclado.nextLine();
           
            
//            teclado.close();
            
            System.out.println("Ingresa las columnas: ");
            Scanner teclado2 = new Scanner(System.in);
            String columnas = teclado2.nextLine();
            
            System.out.println(columnas);
            
            System.out.println("Ingresa el criterio: ");
            Scanner teclado3 = new Scanner(System.in);
            String criterio = teclado3.nextLine();
            
            System.out.println(criterio);
            
//            Archivo read = new Archivo(ruta);
            
             Archivo read = new Archivo(ruta);
             
             Manager m = new Manager();
             m.manager(CPUs,30);
             
        } catch (InputMismatchException ex ) {
            System.out.println(ex);
        }
       
        
        
        
        
        
        
       
        
    }
    
}
