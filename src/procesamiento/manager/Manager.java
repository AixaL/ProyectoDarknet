package procesamiento.manager;

import static archivos.Archivo.getArchivosProcesados;
import static constantes.ConstantesDeEjecucion.*;

import java.io.*;
import java.util.Arrays;

import Errores.ErrorArchivo;
import Errores.ErrorEscritura;
import procesamiento.worker.*;
import constantes.Constantes;

public class Manager extends ManagementInfo implements Constantes {
    public Manager() throws ErrorEscritura, InterruptedException, ErrorArchivo {
        this.poolWorkers = new Thread[Hilos];

        File[] archivosProceso = getArchivosProcesados();

        try {
            fileWriter     = new FileWriter(getRutaArchivoSalida());
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            throw new ErrorEscritura("No puede usarse el archivo de salida" + e);
        }

        if (archivosProceso != null) {
            int numeroWorker = 0;

            for (int contador = 0; contador < ArchivosTotales; contador = contador + ArchivosPorHilo) {
                File[] paqueteArchivos = Arrays.copyOfRange(archivosProceso, contador, contador + ArchivosPorHilo);

                this.poolWorkers[numeroWorker] =
                    new Thread(
                        new Worker(paqueteArchivos)
                    );
                poolWorkers[numeroWorker].start();
                numeroWorker++;
            }
        } else {
            throw new ErrorArchivo("No existen archivos a ser procesados.");
        }
        
        for (int i = 1; i < Hilos; i++) {
            try {
                this.poolWorkers[i].join();
            } catch (InterruptedException e) {
                throw new InterruptedException("El hilo +" + i + " ha sido interrumpido");
            }
        }

        try {
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new ErrorEscritura("Error de escritura a archivo de salida" + e);
        }
    }

    public static BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }
}
