package procesamiento;

public class Filtro {
    private int         posicion;
    private Operador    operador;
    private String      valor;
    private Tipo        tipo;

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
