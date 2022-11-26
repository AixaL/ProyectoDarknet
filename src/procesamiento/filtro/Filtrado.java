package procesamiento.filtro;

import static procesamiento.enumeradores.Operador.EQUALS;

public class Filtrado {
    public static boolean esAceptadaLinea(String[] linea, Filtro[] filtros) throws Exception {
        for (Filtro filtro: filtros) {
            switch (filtro.getTipo()) {
                case STRING -> {
                    if (filtro.getOperador() == EQUALS) {
                        if (!linea[filtro.getPosicion()].equals(filtro.getValor()))
                            // Negating equals
                            return false;
                    } else {
                        throw new Exception("Valor de operador no esperado para String");
                    }
                }
                case DOUBLE -> {
                    Double valorLinea   = Double.parseDouble(linea[filtro.getPosicion()]);
                    Double valorFiltro  = Double.parseDouble(filtro.getValor());

                    switch (filtro.getOperador()) {
                        case EQUALS -> {
                            if(!valorLinea.equals(valorFiltro))
                                // Negating equals
                                return false;
                        }
                        case MORETHAN -> {
                            if(valorLinea <= valorFiltro)
                                // Logic oposite of >: <=
                                return false;
                        }
                        case LESSTHAN  -> {
                            if(valorLinea >= valorFiltro)
                                // Logic oposite of <: >=
                                return false;
                        }
                        default -> throw new Exception("Valor de operador no esperado para Double");
                    }
                }
                default -> {
                    return true;
                }

            }
        }
        return true;
    }
}
