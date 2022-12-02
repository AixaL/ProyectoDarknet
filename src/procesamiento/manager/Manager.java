package procesamiento.manager;

import static constantes.ConstantesDeEjecucion.*;

import java.io.*;
import java.util.Arrays;

import procesamiento.worker.*;
import constantes.Constantes;

public class Manager extends ManagementInfo implements Constantes {
    public Manager() {
        this.poolWorkers = new Thread[Hilos];

        File   directorioProceso = new File(getRutaDirectorioProceso());
        File[] archivosProceso   = directorioProceso.listFiles();

        try {
            fileWriter     = new FileWriter(getRutaArchivoSalida());
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            throw new RuntimeException("No puede usarse el archivo de salida" + e);
        }

        if (archivosProceso != null) {
            int numeroWorker = 0;

            for (int contador = 1; contador <= ArchivosTotales; contador = contador + ArchivosPorHilo) {
                File[] paqueteArchivos = Arrays.copyOfRange(archivosProceso, contador, contador + ArchivosPorHilo);

                this.poolWorkers[numeroWorker] =
                    new Thread(
                        new Worker(paqueteArchivos)
                    );
                poolWorkers[numeroWorker].start();
                numeroWorker++;
            }


        } else {
            System.out.println("No existen archivos a ser procesados.");
        }
/*
        for (int i = 1; i < Hilos; i++) {
            File file = new File(getRutaProceso() + File.separator + getNombreSubArchivo(i));

            this.poolWorkers[i] =
                new Thread(
                    new Worker(
                        getRutaProceso() + File.separator + getNombreSubArchivo(i),
                        file,
                        getFileT())
                );

            this.poolWorkers[i].start();
        }

 */
        
        for (int i = 1; i < Hilos; i++) {
            try {
                this.poolWorkers[i].join();
            } catch (InterruptedException e) {
                System.out.println("El hilo +" + i + " ha sido interrumpido");
            }
        }

        try {
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        poolWorkers.shutdown();

    }

    public static BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }


}
