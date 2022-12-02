package procesamiento.manager;

import java.io.BufferedWriter;
import java.io.FileWriter;

public abstract class ManagementInfo {
    protected static FileWriter     fileWriter     = null;
    protected static BufferedWriter bufferedWriter = null;

    protected Thread[] poolWorkers;

    public static FileWriter getBufferedWriter;
}
