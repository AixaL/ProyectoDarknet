
package procesamiento.worker;

import Errores.ErrorFiltro;
import procesamiento.enumeradores.Columna;
import procesamiento.enumeradores.Operador;
import procesamiento.enumeradores.Tipo;
import procesamiento.extractor.Extractor;
import procesamiento.filtro.Filtro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import static procesamiento.enumeradores.Columna.*;
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
        // Set<Columna> columnasRequeridas1 = Set.of(C84, C05, C06, C83, C00);
        
        // int         posicion1   = C02.getPosicion();
        // Operador    operador1   = Operador.MORETHAN;
        // String      valor1      = "40000"; // Valor aceptado
        // Tipo        tipo1       = C02.getTipo();
        
        // Filtro[] filtros1 = {
        //     new Filtro(
        //         posicion1,
        //         operador1,
        //         valor1,
        //         tipo1
        //     )
        // };

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

                    // if (!lineaSalida.isEmpty()) {
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

                
             
