package procesamiento.manager;

import static archivos.Archivo.rutaDir;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import procesamiento.worker.*;

public class Manager {
    private Thread poolWorkers[];
    public void manager(int CPUs, int hilos) {
        
//        ExecutorService poolWorkers = Executors.newFixedThreadPool(CPUs);
        this.poolWorkers = new Thread[CPUs];
        File fileT = new File(rutaDir + File.separator + "Resultados.csv");

        for (int i = 1; i < CPUs; i++) {
            File file = new File(rutaDir + File.separator + "FileNumber_"+i+".csv");
            this.poolWorkers[i] = new Thread(new Worker(rutaDir + File.separator + "FileNumber_"+i+".csv" ,file , fileT));
            this.poolWorkers[i].start();
            //poolWorkers.execute(new Worker());
        }
        
        for (int i = 1; i < CPUs; i++) {
            try {
                this.poolWorkers[i].join();
            } catch (InterruptedException e) {
            }
        }

//        poolWorkers.shutdown();

    }

}
