package procesamiento.filtro;

import Errores.ErrorFiltro;

import static procesamiento.enumeradores.Operador.EQUALS;

public class Filtrado {
    public static boolean esAceptadaLinea(String[] linea, Filtro[] filtros) throws ErrorFiltro {
        if (linea == null) {
            return false;
        }
        for (Filtro filtro: filtros) {
            switch (filtro.getTipo()) {
                case STRING:
                    if (filtro.getOperador().equals(EQUALS)) {
                        if (!linea[filtro.getPosicion()].equals(filtro.getValor()))
                            // Negating equals
                            return false;
                    } else {
                        throw new ErrorFiltro("Valor de operador no esperado para String");
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
                            throw new ErrorFiltro("Valor de operador no esperado para Double");
                    }
                    break;

                default:
                    throw new ErrorFiltro("Tipo de variable no contemplado");

            }
        }
        return true;
    }

}
