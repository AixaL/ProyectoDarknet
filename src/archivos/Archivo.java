package archivos;
import java.io.*;
import Errores.*;
import archivos.Herramientas.Herramientas;
import constantes.Constantes;
import constantes.ConstantesDeEjecucion;

import java.io.File;

import static archivos.Herramientas.Herramientas.*;


/**
 *
 * @author 93004
 */
public class Archivo implements Constantes {
    //TODO Clean
    //static String line = "";
    //public static String rutaDir = "";
    //final String delimiter = ",";
    //static String CSVFile = "C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\Darknet.csv";

    /*
    public Archivo(){
        try{
            String archivoRutaEntrada = getRutaArchivoEntrada();
            validarArchivo(archivoRutaEntrada);
            //crearDirectorios(f , f);
            separarArchivo(archivoRutaEntrada);
        }catch(ErrorArchivo e){
            System.out.println(e.getMessage());
            //System.out.println(ex);
        }
    }
     */

    public static void procesarArchivo(String archivoRutaEntrada) {
        try {
            validarArchivo(archivoRutaEntrada);
            separarArchivo(archivoRutaEntrada);
        } catch(ErrorArchivo e) {
            System.out.println(e.getMessage());
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
    
    private static void separarArchivo(String rutaArchivo){
        int    numeroLineas     = Herramientas.getNumeroDeLineas(rutaArchivo);
        int    lineasPorArchivo = numeroLineas / ArchivosTotales;
        String rutaProceso      = ConstantesDeEjecucion.getRutaDirectorioProceso();

        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter = null;

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
                    fileWriter        = new FileWriter(nuevoArchivo);
                    bufferedWriter    = new BufferedWriter(fileWriter);

                    numeroArchivo++;
                }

                bufferedWriter.write(linea);
                bufferedWriter.newLine();
                contadorLineas++;

                bufferedWriter.flush();
            }
            System.out.println(contadorLineas);

        } catch(IOException e) {
            System.out.println("Error en lectura/escritura de archivos "+ e);
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
    public static void crearDirectorios(File rutaAbsoluta, File rutaRelativa) {        
        System.out.println("\t# Creacion de Directorios #");      
        
        rutaDir = rutaAbsoluta.getPath().replaceAll(rutaAbsoluta.getName(), "");
        rutaDir = rutaDir + "cut";
        System.out.println(rutaDir);
        
        
        File X = new File(rutaDir);
        if(X.exists()){
            if (X.isDirectory()) {
                File[] entries = X.listFiles();
                if (entries != null) {
                  for (File entry : entries) {
                    entry.delete();
                  }
                }
              }
            if (X.delete()){
                System.out.println("El directorio " + X + " ha sido borrado correctamente");
                if (X.mkdirs()) {
                    System.out.println("\t Se creo con exito el directorio: \t" + X.getAbsolutePath());
                }
                if (X.mkdir()) {
                    System.out.println("\t Se creo con exito el directorio: \t" + X.getAbsolutePath());
                }
            }else{
                System.out.println("El directorio " + X + " no se ha podido borrar");
            }
        }else{
            if (X.mkdirs()) {
            System.out.println("\t Se creo con exito el directorio: \t" + X.getAbsolutePath());
            }
            if (X.mkdir()) {
                System.out.println("\t Se creo con exito el directorio: \t" + X.getAbsolutePath());
            }
        }

        
    }
    
    public void Dividir(){
        
    }

     */
}
