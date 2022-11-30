package archivos;
import Errores.*;

public class Inputs {
    
    
    
    public static boolean validarCampos(String campos){
        
        return true;
    }
    public static boolean validarCriterio(String criterio){
        
        return true;
    }
    
    public static String limpiarRuta(String ruta){
       String[] caracteresMalos = {" ","|","<","*","?",">","\""};

        for (String letraMala : caracteresMalos) {
            if(ruta.contains(letraMala)){
                ruta = ruta.replace(letraMala,"");
            }
        }

       try{
        if(validarRuta(ruta)){
            return ruta;
        }else{
            return "Error";
        }
       }catch(ErrorInput e){
           System.out.println(e.getMessage());
       }
       
       return "Error" ;
    }
    
    
    public static boolean validarRuta(String ruta) throws ErrorInput{
        if(ruta.length() == 0 || ruta.length() < 4){
            
            throw new ErrorInput("Hubo un error en la ruta.");
            
        }else{
            
            return true;
        }
        
    }
    
    
}
