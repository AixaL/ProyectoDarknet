package procesamiento.extractor;

import procesamiento.enumeradores.Columna;
import procesamiento.filtro.Filtrado;
import procesamiento.filtro.Filtro;

import java.util.ArrayList;
import java.util.Set;

public class Extractor extends Linea {
    public Extractor(String[] lineaSeparada) {
        setLinea(lineaSeparada);
    }

    public String[] getValores(Set<Columna> columnasRequeridas, Filtro[] filtros) throws Exception {

        String[] linea = getLinea();

        ArrayList<String> bufferColumnas = new ArrayList<>();

        if (Filtrado.esAceptadaLinea(linea, filtros)) {
            for (Columna columna: Columna.values()) {
                if (columnasRequeridas.contains(columna)) {
                    bufferColumnas.add(linea[columna.getPosicion()]);
                }
            }
        }

        return bufferColumnas.toArray(new String[0]);
    }
}
