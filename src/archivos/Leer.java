package archivos;
import java.io.*;

public class Leer {
    String line = "";
    final String delimiter = ",";
    static String CSVFile = "C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\Darknet.csv";
    static String CSVFile2 ="Darknet.csv";
    static String row;
    static BufferedReader csvReader;
    static PrintWriter csvWriter;
    
    public Leer(String ruta){
        try{
            FileReader fileReader = new FileReader(ruta);  
            System.out.println(ruta);
            BufferedReader reader = new BufferedReader(fileReader);
            while ((line = reader.readLine()) != null)   //loops through every line until null found
            {
               String[] token = line.split(delimiter);    // separate every token by comma
             // System.out.println(token[0] + " | "+ token[1]+ " | "+ token[2]+ " | "+ token[3]);
            }
            
            
            String inputfile = "C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\Darknet.csv";
           BufferedReader br = new BufferedReader(new FileReader(inputfile)); 
           //create thje first file which will have 1000 lines
           File file = new File("C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\FileNumber_"+1+".csv");
            FileWriter fstream1 = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream1);  
               String line="";
               //count the number of line
               int count=1;
               int file_Number=2;
               while ((line = br.readLine()) != null) 
               {
                   //if the line is divided by 1000 then create a new file with file count
                   if(count % 1000 == 0)
                   {
                       File newFile = new File("C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\FileNumber_"+file_Number+".csv");
                       fstream1 = new FileWriter(newFile);
                       file_Number++;
                       out = new BufferedWriter(fstream1); 
                   }
                    if(line.indexOf(",")!=-1)
                    //line=line.substring(2, line.indexOf(","));
                    out.write(line);
                    out.newLine();
                   count++;
               }
            
        }catch(IOException e){
             //e.printStackTrace();
        }
      
    }
    
    
    public void Partir(){
        
    }
}
