
package procesamiento.worker;

import procesamiento.enumeradores.Columna;
import procesamiento.enumeradores.Operador;
import procesamiento.enumeradores.Tipo;
import procesamiento.extractor.Extractor;
import procesamiento.filtro.Filtro;

import java.io.*;
import java.util.Set;

import static constantes.ConstantesDeEjecucion.*;
import static procesamiento.enumeradores.Columna.*;

/**
 *
 * @author 93004
 */
public class Worker implements Runnable{
    
    //private String nombreA;
    //private File file;
   // private File fileResultado;
    private final File[] paqueteArchivos;
    
    public Worker(File[] paqueteArchivos){
        
        //System.out.println(f.getAbsolutePath());
        //System.out.println(fr.getAbsolutePath());
        
        //nombreA = nombreArchivo;
        //file = f;
        //fileResultado = fr;

        this.paqueteArchivos = paqueteArchivos;
        
    }
    
    @Override
    public void run() {
        
        Set<Columna> columnasRequeridas1 = Set.of(C84, C05, C06, C83, C00);
        
        int         posicion1   = C02.getPosicion();
        Operador    operador1   = Operador.MORETHAN;
        String      valor1      = "40000"; // Valor aceptado
        Tipo        tipo1       = C02.getTipo();
        
        Filtro[] filtros1 = {
            new Filtro(
                posicion1,
                operador1,
                valor1,
                tipo1
            )
        };

        for (File archivo : paqueteArchivos){
            BufferedReader bufferedReader;
            BufferedWriter bufferedWriter = null;

            try {
                FileReader fileReader = new FileReader(archivo);
                FileWriter fileWriter = new FileWriter(getRutaArchivoSalida());

                bufferedReader = new BufferedReader(fileReader);
                bufferedWriter = new BufferedWriter(fileWriter);

                String lineaEntrada;

                while ((lineaEntrada = bufferedReader.readLine()) != null) {
                    StringBuilder lineaSalida = new StringBuilder();

                    String[]  lineaSeparada    = lineaEntrada.trim().split(",");
                    Extractor extractor        = new Extractor(lineaSeparada);
                    String[]  extractorValores = extractor.getValores(columnasRequeridas1, filtros1);
                    int       indiceSiguiente  = 0;

                    for (String elemento : extractorValores) {
                        lineaSalida.append(elemento);

                        if (++indiceSiguiente < extractorValores.length) {
                            lineaSalida.append(",");
                        }
                    }
                    if (!lineaSalida.isEmpty()) {
                        bufferedWriter.write(lineaSalida.toString());
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }

                    bufferedWriter.flush();
                }
            } catch (IOException e) {
                System.out.println("Error en la lectura/escritura de archivos" + e);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        System.out.println("No pudo cerrarse el BufferedWriter" + e);
                    }
                }
            }

        }

        /*
        try{
            //System.out.println(fileResultado.getAbsoluteFile());
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

         */
    }
        
}

                
             
