package archivos;
import java.io.*;

public class Leer {
    String line = "";
    final String delimiter = ",";
    
    public Leer(String ruta){
        try{
            FileReader fileReader = new FileReader(ruta);  
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null)   //loops through every line until null found
            {
               String[] token = line.split(delimiter);    // separate every token by comma
             System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+ " | "+ token[3]);
            }
        }catch(IOException e){
             e.printStackTrace();
        }
      
    }
}
