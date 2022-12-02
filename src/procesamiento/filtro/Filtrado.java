package procesamiento.filtro;

import static procesamiento.enumeradores.Operador.EQUALS;

public class Filtrado {

    public static boolean esAceptadaLinea(String[] linea, Filtro[] filtros) throws Exception {

        for (Filtro filtro: filtros) {
            switch (filtro.getTipo()) {
                case STRING:
                    if (filtro.getOperador().equals(EQUALS)) {
                        if (!linea[filtro.getPosicion()].equals(filtro.getValor()))
                            // Negating equals
                            return false;
                    } else {
                        System.out.println("Valor de operador no esperado para String");
                        throw new Exception("Valor de operador no esperado para String");
                    }
                    break;

                case DOUBLE:
                    Double valorLinea   = Double.parseDouble(linea[filtro.getPosicion()]);
                    Double valorFiltro  = Double.parseDouble(filtro.getValor());

                    switch (filtro.getOperador()) {
                        case EQUALS:
                            if(!valorLinea.equals(valorFiltro))
                                // Negating equals
                                return false;
                            break;
                        case MORETHAN:
                            if(valorLinea <= valorFiltro)
                                // Logic oposite of >: <=
                                return false;
                            break;
                        case LESSTHAN:
                            if(valorLinea >= valorFiltro)
                                // Logic oposite of <: >=
                                return false;
                            break;
                        default:
                            System.out.println("Valor de operador no esperado para Double");
                            throw new Exception("Valor de operador no esperado para Double");
                    }
                    break;

                default:
                    System.out.println("Tipo de variable no contemplado");
                    throw new Exception("Tipo de variable no contemplado");

            }
        }
        return true;
    }

}
