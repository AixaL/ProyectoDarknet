package archivos;
import java.io.*;
import Errores.*;
import archivos.Herramientas.Herramientas;
import constantes.Constantes;
import constantes.ConstantesDeEjecucion;

import java.io.File;
import java.util.ArrayList;

import static archivos.Herramientas.Herramientas.*;

public class Archivo implements Constantes {
    private static File[] archivosProcesados = new File[ArchivosTotales];

    public static File[] getArchivosProcesados() {
        return archivosProcesados;
    }

    private static void setArchivosProcesados(File[] archivosProcesados) {
        Archivo.archivosProcesados = archivosProcesados;
    }

    public static void procesarArchivo(String archivoRutaEntrada) throws ErrorArchivo {
        try {
            validarArchivo(archivoRutaEntrada);
            separarArchivo(archivoRutaEntrada);
        } catch(ErrorArchivo | ErrorEscritura e) {
            throw new ErrorArchivo("Error de archivo/escritura");
        }
    }
    
    private static void validarArchivo(String rutaArchivo) throws ErrorArchivo {
        File archivo = new File(rutaArchivo);

        if(!archivo.exists()){
            throw new ErrorArchivo("Hubo un error en el archivo. Revisa su existencia");
        }
        if(!archivo.isFile()){
            throw new ErrorArchivo("La ruta introducida no es un archivo. Por favor ingresa la ruta del archivo");
        }
        if(archivo.length() == 0){
            throw new ErrorArchivo("El archivo es muy pequeño");
        }
        if(!archivo.canWrite() && !archivo.canRead()){
            throw new ErrorArchivo("Revisa los permisos del archivo para poder continuar");
        }
    }
    
    private static void separarArchivo(String rutaArchivo) throws ErrorEscritura {
        int    numeroLineas     = Herramientas.getNumeroDeLineas(rutaArchivo);
        int    lineasPorArchivo = numeroLineas / ArchivosTotales;
        String rutaProceso      = ConstantesDeEjecucion.getRutaDirectorioProceso();

        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter = null;

        ArrayList<File> listaArchivosProcesados = new ArrayList<>();
        File archivoInicial = new File(rutaProceso + File.separator + getNombreSubArchivo(1));

        try {
            FileReader fileReader = new FileReader(rutaArchivo);
            FileWriter fileWriter = new FileWriter(archivoInicial);

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            
            String linea;
            bufferedReader.readLine(); // Borrar encabezado

            int contadorLineas = 0;
            int numeroArchivo  = 1;

            while ((linea = bufferedReader.readLine()) != null) {
                if(contadorLineas % (lineasPorArchivo + 1) == 0) {
                    File nuevoArchivo = new File(rutaProceso + File.separator + getNombreSubArchivo(numeroArchivo));
                    listaArchivosProcesados.add(nuevoArchivo);
                    fileWriter        = new FileWriter(nuevoArchivo);
                    bufferedWriter    = new BufferedWriter(fileWriter);

                    numeroArchivo++;
                }

                bufferedWriter.write(linea);
                bufferedWriter.newLine();
                contadorLineas++;

                bufferedWriter.flush();
            }

        } catch(IOException e) {
            System.out.println("Error en lectura/escritura de archivos "+ e);
        } finally {
            setArchivosProcesados(listaArchivosProcesados.toArray(new File[0]));
        }

        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new ErrorEscritura("No pudo cerrarse el BufferedWriter" + e);
            }
        }
    }
}
