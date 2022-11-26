package procesamiento.extractor;

import procesamiento.enumeradores.Columna;
import procesamiento.enumeradores.Operador;
import procesamiento.enumeradores.Tipo;
import procesamiento.filtro.Filtro;

import java.util.Set;

import static procesamiento.enumeradores.Columna.*;

public class TestExtractor {
    public static void main(String[] args) throws Exception {

        String lineaEjemplo =
                "10.152.152.11-52.71.139.178-40621-80-6,10.152.152.11,40621,52.71.139.178,80,6,24/02/2016 11:59:04 AM," +
                "62340425,12,12,2193,1122,1136,0,182.75,427.1442433,559,0,93.5,204.45115,53.17576837,0.384982938," +
                "2710453.261,4407381.835,10031674,16,52777534,4797957.636,5016685.459,10031867,160,62340296,5667299.636," +
                "4929939.439,10031959,3807,0,0,0,0,252,252,0.192491469,0.192491469,0,1136,132.6,324.8644589,105536.9167," +
                "1,2,0,5,23,0,0,0,1,138.125,182.75,93.5,0,0,0,0,4,1997,0,91,0,46,14600,1237,2,20,0,0,0,0,1.39013E+15," +
                "3.10491E+14,1.45633E+15,9562467,Non-Tor,Browsing\n";

        String[] separacionEjemplo = lineaEjemplo.trim().split(",");

        Extractor extractorEjemplo = new Extractor(separacionEjemplo);

        Set<Columna> columnasRequeridas1 = Set.of(C84, C05, C06, C83, C00); // No importa el orden

        int         posicion1   = C06.getPosicion();
        Operador    operador1   = Operador.EQUALS;
        String      valor1      = "24/02/2016 11:59:04 AM"; // Fecha igual
        Tipo        tipo1       = C06.getTipo();

        Filtro[] filtros1 = {
                new Filtro(
                        posicion1,
                        operador1,
                        valor1,
                        tipo1
                )
        };

        System.out.print("Linea de salida: ");

        for (String element: extractorEjemplo.getValores(columnasRequeridas1, filtros1)) {
            System.out.print(element + ", ");
        }

    }
}
