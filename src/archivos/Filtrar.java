package archivos;
import java.io.*;

/**
 *
 * @author 93004
 */
public class Filtrar {
    String line = "";
    final String delimiter = ",";
    
    public Filtrar(String ruta){
        try{
            FileReader fileReader = new FileReader(ruta);  
            System.out.println(ruta);
            BufferedReader reader = new BufferedReader(fileReader);
            int numLineas = 0;
            while ((line = reader.readLine()) != null)   //loops through every line until null found
            {
                String[] token = line.split(delimiter);    // separate every token by comma
                // System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+ " | "+ token[3]);
                numLineas++;
            }
        }catch(IOException e){
            System.out.println(e);
        }
        
    }
}
