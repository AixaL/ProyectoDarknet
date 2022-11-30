
package procesamiento.worker;
import static procesamiento.enumeradores.Columna.C06;
import procesamiento.enumeradores.Operador;
import procesamiento.enumeradores.Tipo;
import procesamiento.filtro.Filtrado;
import procesamiento.filtro.Filtro;
import java.io.File;
import archivos.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import procesamiento.enumeradores.Columna;
import static procesamiento.enumeradores.Columna.*;
import procesamiento.extractor.Extractor;

/**
 *
 * @author 93004
 */
public class Worker implements Runnable{
    
    private String nombreA;
    private File file;
    private File fileResultado;
    
    public Worker(String nombreArchivo, File f , File fr){
        
        System.out.println(f.getAbsolutePath());
        System.out.println(fr.getAbsolutePath());
        
        nombreA = nombreArchivo;
        file = f;
        fileResultado = fr;
        
        
        
    }
    
    @Override
    public void run() {
        
        Set<Columna> columnasRequeridas1 = Set.of(C84, C05, C06, C83, C00);
        
        int         posicion1   = C02.getPosicion();
        Operador    operador1   = Operador.MORETHAN;
        String      valor1      = "40000"; // Valor aceptado
        Tipo        tipo1      = C02.getTipo();
        
        Filtro[] filtros1 = {
            new Filtro(
                posicion1,
                operador1,
                valor1,
                tipo1
            )
        };
        
        try{
            System.out.println(fileResultado.getAbsoluteFile());
            FileWriter fstream1 = new FileWriter(fileResultado);
            BufferedWriter out = new BufferedWriter(fstream1);
            
            BufferedReader br = new BufferedReader(new FileReader(nombreA)); 
            String line = "";
            String linea = "";
            while ((line = br.readLine()) != null) 
            {
                String[] separacionEjemplo = line.trim().split(",");
                
                Extractor extractorEjemplo = new Extractor(separacionEjemplo);
                try{
                    
                    for (String element: extractorEjemplo.getValores(columnasRequeridas1, filtros1)) {
                        System.out.println(element);
                        linea = linea + element + ", " ;
                    }
                    if(linea!=""){
                        out.write(linea);
                        out.newLine();
                    }
                   
                    line = "";
                    System.out.println(linea);
                    linea = "";
                    
                }catch(Exception e){
                    System.out.println(e);
                 }
            }
        }catch(IOException e){
           System.out.println(e);
        }
    }
        
}

                
             
