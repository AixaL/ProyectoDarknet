package archivos;
import java.io.*;
import Errores.*;
import java.io.File;
import java.nio.file.FileSystems;


/**
 *
 * @author 93004
 */
public class Archivo {
    String line = "";
    static String rutaDir = "";
    //final String delimiter = ",";
    static String CSVFile = "C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\Darknet.csv";
    
    public Archivo(String ruta){
        try{
            File f = new File(ruta);
            ValidarArchivo(f);
            crearDirectorios(f , f);
            Separar(ruta);
        }catch(ErrorArchivo e){
            System.out.println(e.getMessage());
            //System.out.println(ex);
        }
    }
    
    public static void ValidarArchivo(File f) throws ErrorArchivo {
        if(!f.exists() && !f.isFile()){
            throw new ErrorArchivo("Hubo un error en el archivo. Revisa su existencia");
        }
        if(f.length()==0){
            throw new ErrorArchivo("El archivo es muy pequeño");
        }
        if(f.isDirectory()){
            throw new ErrorArchivo("La ruta introducida fue de un directorio. Por favor ingresa la ruta del archivo");
        }
        if(!f.canWrite() && !f.canRead()){
            throw new ErrorArchivo("Revisa los permisos del archivo para poder continuar");
        }
       
    }
    
    public void Separar(String ruta){
       try{   
            FileReader fileReader = new FileReader(ruta);  
            BufferedReader reader = new BufferedReader(fileReader);
            int numLineas = 0;
            while ((line = reader.readLine()) != null)   //loops through every line until null found
            {
                numLineas++;
            }
            
            int CPUs = Runtime.getRuntime().availableProcessors();
            int dividir = numLineas / (CPUs * 4);
            System.out.println(numLineas);
            System.out.println(dividir);
            
            BufferedReader br = new BufferedReader(new FileReader(ruta)); 
            //create thje first file which will have 1000 lines
            File file = new File(rutaDir + File.separator + "FileNumber_"+1+".csv");
            FileWriter fstream1 = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream1);
            
            String line = "";
            int count=1;
            int file_Number=2;
            while ((line = br.readLine()) != null) 
            {
                //if the line is divided by 1000 then create a new file with file count
                if(count % (dividir + 1) == 0)
                {
                    File newFile = new File(rutaDir + File.separator +"FileNumber_"+file_Number+".csv");
                    fstream1 = new FileWriter(newFile);
                    file_Number++;
                    out = new BufferedWriter(fstream1); 
                }
                 //line=line.substring(2, line.indexOf(","));
                 out.write(line);
                 out.newLine();
                count++;
            }
       }catch(IOException e){
           System.out.println(e);
       }
    }
    
    
    
    public static void crearDirectorios(File rutaAbsoluta, File rutaRelativa) {        
        System.out.println("\t# Creacion de Directorios #");      
        
        rutaDir = rutaAbsoluta.getPath().replaceAll(rutaAbsoluta.getName(), "");
        rutaDir = rutaDir + "cut";
        System.out.println(rutaDir);
        
        
        File X = new File(rutaDir);
        if(X.exists()){
            System.out.println("existe");
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
}
