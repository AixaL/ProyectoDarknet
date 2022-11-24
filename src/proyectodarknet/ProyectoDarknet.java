package proyectodarknet;
import archivos.*;

import java.util.Scanner;
/**
 *
 * @author 93004
 */
public class ProyectoDarknet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int CPUs = Runtime.getRuntime().availableProcessors();
        System.out.println(CPUs);
        
        System.out.println("Ingresa la ruta del archivo: ");
        Scanner teclado = new Scanner(System.in);
        String ruta = teclado.nextLine();
        
        Archivo read = new Archivo(ruta);
        
        
       
        
    }
    
}
