
package procesamiento.worker;

import Errores.ErrorFiltro;
import procesamiento.enumeradores.Columna;
import procesamiento.extractor.Extractor;
import procesamiento.filtro.Filtro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import static procesamiento.manager.Manager.getBufferedWriter;

/**
 *
 * @author 93004
 */
public class Worker implements Runnable {
    private final File[] paqueteArchivos;
    private final Filtro[] filtro;
    private final Set<Columna> columnas;
    
    public Worker(File[] paqueteArchivos, Filtro[] filtro, Set<Columna> columnas){
        this.paqueteArchivos = paqueteArchivos;
        this.filtro = filtro;
        this.columnas = columnas;
    }
    
    @Override
    public void run() {
        for (File archivo : paqueteArchivos) {
            BufferedReader bufferedReader;

            try {
                FileReader fileReader = new FileReader(archivo);
                bufferedReader = new BufferedReader(fileReader);

                String lineaEntrada;

                while ((lineaEntrada = bufferedReader.readLine()) != null) {
                    StringBuilder lineaSalida = new StringBuilder();

                    String[]  lineaSeparada    = lineaEntrada.trim().split(",");
                    Extractor extractor        = new Extractor(lineaSeparada);
                    String[]  extractorValores = extractor.getValores(columnas, filtro);
                    int       indiceSiguiente  = 0;

                    for (String elemento : extractorValores) {
                        lineaSalida.append(elemento);

                        if (++indiceSiguiente < extractorValores.length) {
                            lineaSalida.append(",");
                        }
                    }

                    if (lineaSalida.toString().length()>1) {
                        getBufferedWriter().write(lineaSalida.toString().concat(System.lineSeparator()));
                    }

                    getBufferedWriter().flush();
                }
            } catch (IOException e) {
                System.out.println("Error en la lectura/escritura de archivos" + e);
            } catch (ErrorFiltro e) {
                System.out.println("Valor nulo. Final del archivo encontrado.");
            }

        }
    }
}

                
             
