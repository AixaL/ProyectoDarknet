package archivos;
import java.io.*;


/**
 *
 * @author 93004
 */
public class Archivo {
    
    String line = "";
    final String delimiter = ",";
    static String CSVFile = "C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\Darknet.csv";
    
    public Archivo(String ruta){
        try{
            FileReader fileReader = new FileReader(ruta);  
            System.out.println(ruta);
            BufferedReader reader = new BufferedReader(fileReader);
            int numLineas = 0;
            while ((line = reader.readLine()) != null)   //loops through every line until null found
            {
                numLineas++;
            }
           
            //String inputfile = "C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\Darknet.csv"; 
            
            File firstFile = new File("C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\FileNumber_"+1+".csv");
            FileWriter file = new FileWriter(firstFile);
            BufferedWriter out = new BufferedWriter(file);  
            
            int CPUs = Runtime.getRuntime().availableProcessors();
            System.out.println(CPUs);
            
            int dividir = numLineas / (CPUs * 4);
            
            System.out.println(dividir);
            
               //count the number of line
            int count=1;
            int file_Number=2;
            while ((line = reader.readLine()) != null){
  
                if(count % dividir == 0){
                    File newFile = new File("C:\\Users\\93004\\Documents\\NetBeansProjects\\ProyectoDarknet\\Files\\Cut\\FileNumber_"+file_Number+".csv");
                    file = new FileWriter(newFile);
                    file_Number++;
                    out = new BufferedWriter(file);
                    String line2= "Flow ID,Src IP,Src Port,Dst IP,Dst Port,Protocol,Timestamp,Flow Duration,Total Fwd Packet,Total Bwd packets,Total Length of Fwd Packet,Total Length of Bwd Packet,Fwd Packet Length Max,Fwd Packet Length Min,Fwd Packet Length Mean,Fwd Packet Length Std,Bwd Packet Length Max,Bwd Packet Length Min,Bwd Packet Length Mean,Bwd Packet Length Std,Flow Bytes/s,Flow Packets/s,Flow IAT Mean,Flow IAT Std,Flow IAT Max,Flow IAT Min,Fwd IAT Total,Fwd IAT Mean,Fwd IAT Std,Fwd IAT Max,Fwd IAT Min,Bwd IAT Total,Bwd IAT Mean,Bwd IAT Std,Bwd IAT Max,Bwd IAT Min,Fwd PSH Flags,Bwd PSH Flags,Fwd URG Flags,Bwd URG Flags,Fwd Header Length,Bwd Header Length,Fwd Packets/s,Bwd Packets/s,Packet Length Min,Packet Length Max,Packet Length Mean,Packet Length Std,Packet Length Variance,FIN Flag Count,SYN Flag Count,RST Flag Count,PSH Flag Count,ACK Flag Count,URG Flag Count,CWE Flag Count,ECE Flag Count,Down/Up Ratio,Average Packet Size,Fwd Segment Size Avg,Bwd Segment Size Avg,Fwd Bytes/Bulk Avg,Fwd Packet/Bulk Avg,Fwd Bulk Rate Avg,Bwd Bytes/Bulk Avg,Bwd Packet/Bulk Avg,Bwd Bulk Rate Avg,Subflow Fwd Packets,Subflow Fwd Bytes,Subflow Bwd Packets,Subflow Bwd Bytes,FWD Init Win Bytes,Bwd Init Win Bytes,Fwd Act Data Pkts,Fwd Seg Size Min,Active Mean,Active Std,Active Max,Active Min,Idle Mean,Idle Std,Idle Max,Idle Min,Label,Label";
                    out.write(line2);
                    out.newLine();
                 }
                   
                    out.write(line);
                    out.newLine();
                   count++;
                }
            
        }catch(IOException e){
             //e.printStackTrace();
        }
    }
    
    public void Dividir(){
        
    }
}
