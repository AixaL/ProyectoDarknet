package procesamiento.manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Manager {

    public void manager(int CPUs, int hilos) {

        ExecutorService poolWorkers = Executors.newFixedThreadPool(CPUs);

        for (int i = 0; i < hilos; i++) {
            //poolWorkers.execute(new Worker());
        }

        poolWorkers.shutdown();

    }

}
