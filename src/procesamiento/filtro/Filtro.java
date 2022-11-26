package procesamiento.filtro;

import procesamiento.Operador;
import procesamiento.Tipo;

public class Filtro {
    private final int       posicion;
    private final Operador operador;
    private final String    valor;
    private final Tipo tipo;

    public Filtro(int posicion, Operador operador, String valor, Tipo tipo) {
        this.posicion   = posicion;
        this.operador   = operador;
        this.valor      = valor;
        this.tipo       = tipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public Operador getOperador() {
        return operador;
    }

    public String getValor() {
        return valor;
    }

    public Tipo getTipo() {
        return tipo;
    }


}
