package procesamiento.filtro;

import procesamiento.enumeradores.Operador;
import procesamiento.enumeradores.Tipo;

import static procesamiento.enumeradores.Columna.*;

public class TestFiltro {
    public static void main(String[] args) {

        String lineaEjemplo =
                "10.152.152.11-52.71.139.178-40621-80-6,10.152.152.11,40621,52.71.139.178,80,6,24/02/2016 11:59:04 AM," +
                        "62340425,12,12,2193,1122,1136,0,182.75,427.1442433,559,0,93.5,204.45115,53.17576837,0.384982938," +
                        "2710453.261,4407381.835,10031674,16,52777534,4797957.636,5016685.459,10031867,160,62340296,5667299.636," +
                        "4929939.439,10031959,3807,0,0,0,0,252,252,0.192491469,0.192491469,0,1136,132.6,324.8644589,105536.9167," +
                        "1,2,0,5,23,0,0,0,1,138.125,182.75,93.5,0,0,0,0,4,1997,0,91,0,46,14600,1237,2,20,0,0,0,0,1.39013E+15," +
                        "3.10491E+14,1.45633E+15,9562467,Non-Tor,Browsing\n";

        String[] separacionEjemplo = lineaEjemplo.trim().split(",");
        
        

        int         posicion1   = C06.getPosicion();
        Operador    operador1   = Operador.EQUALS;
        String      valor1      = "24/02/2016 11:59:04 AM"; // Fecha igual
        Tipo        tipo1       = C06.getTipo();
        
        System.out.println(posicion1);
        System.out.println(operador1);
        System.out.println(valor1);
        System.out.println(tipo1);
         System.out.println("----------------");
        
        int         posicion2   = C06.getPosicion();
        Operador    operador2   = Operador.EQUALS;
        String      valor2      = "24/02/2016 12:00:00 AM"; // Fecha no igual
        Tipo        tipo2       = C06.getTipo();
        
        System.out.println(posicion2);
        System.out.println(operador2);
        System.out.println(valor2);
        System.out.println(tipo2);
        System.out.println("----------------");

        int         posicion3   = C02.getPosicion();
        Operador    operador3   = Operador.MORETHAN;
        String      valor3      = "40000"; // Valor aceptado
        Tipo        tipo3       = C02.getTipo();
        
        System.out.println(posicion3);
        System.out.println(operador3);
        System.out.println(valor3);
        System.out.println(tipo3);
        System.out.println("----------------");

        int         posicion4   = C04.getPosicion();
        Operador    operador4   = Operador.LESSTHAN;
        String      valor4      = "81"; // Valor aceptado
        Tipo        tipo4       = C04.getTipo();
        
        System.out.println(posicion4);
        System.out.println(operador4);
        System.out.println(valor4);
        System.out.println(tipo4);
        System.out.println("----------------");

        int         posicion5   = C04.getPosicion();
        Operador    operador5   = Operador.LESSTHAN;
        String      valor5      = "79"; // Valor no aceptado
        Tipo        tipo5       = C04.getTipo();
        
        System.out.println(posicion5);
        System.out.println(operador5);
        System.out.println(valor5);
        System.out.println(tipo5);
        System.out.println("----------------");

        
        
        Filtro[] filtros1 = {
            new Filtro(
                posicion1,
                operador1,
                valor1,
                tipo1
            )
        };

        Filtro[] filtros2 = {
                new Filtro(
                        posicion2,
                        operador2,
                        valor2,
                        tipo2
                )
        };

        Filtro[] filtros34 = {
                new Filtro(
                        posicion3,
                        operador3,
                        valor3,
                        tipo3
                ),
                new Filtro(
                        posicion4,
                        operador4,
                        valor4,
                        tipo4
                )
        };

        Filtro[] filtros35 = {
                new Filtro(
                        posicion3,
                        operador3,
                        valor3,
                        tipo3
                ),
                new Filtro(
                        posicion5,
                        operador5,
                        valor5,
                        tipo5
                )
        };

        try {
            
            System.out.println(
                    "Respuesta de filtrado positiva: " +
                            separacionEjemplo[posicion1]    + " " +
                            operador1                       + " " +
                            valor1                          + " -> " +
                            Filtrado.esAceptadaLinea(separacionEjemplo, filtros1)
            );

            System.out.println(
                    "Respuesta de filtrado negativa: " +
                            separacionEjemplo[posicion2]    + " " +
                            operador2                       + " " +
                            valor2                          + " -> " +
                            Filtrado.esAceptadaLinea(separacionEjemplo, filtros2)
            );

            System.out.println(
                    "Respuesta de filtrado multiple positiva: " +
                            separacionEjemplo[posicion3]    + " " +
                            operador3                       + " " +
                            valor3                          + " -> " +
                            separacionEjemplo[posicion4]    + " " +
                            operador4                       + " " +
                            valor4                          + " -> " +
                            Filtrado.esAceptadaLinea(separacionEjemplo, filtros34)
            );

            System.out.println(
                    "Respuesta de filtrado multiple negativa: " +
                            separacionEjemplo[posicion3]    + " " +
                            operador3                       + " " +
                            valor3                          + " -> " +
                            separacionEjemplo[posicion5]    + " " +
                            operador5                       + " " +
                            valor5                          + " -> " +
                            Filtrado.esAceptadaLinea(separacionEjemplo, filtros35)
            );
        } catch (Exception e) {
            throw new RuntimeException("Error en filtrado");
        }

    }
}
