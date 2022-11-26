package procesamiento.extractor;

import procesamiento.Columnas;
import procesamiento.ColumnasLinea;
import procesamiento.filtro.Filtrado;
import procesamiento.filtro.Filtro;

import java.util.ArrayList;
import java.util.Set;

public class Extractor extends ColumnasLinea {
    public Extractor(String[] linea) {
        setLinea(linea);
    }

    public String[] getValores(Set<Columnas> columnasRequeridas, Filtro[] filtros) throws Exception {

        String[] linea = getLinea();

        ArrayList<String> bufferColumnas = new ArrayList<>();

        if (Filtrado.esAceptadaLinea(linea, filtros)) {
            for (Columnas columna: Columnas.values()) {
                if (columnasRequeridas.contains(columna)) {
                    bufferColumnas.add(linea[columna.getPosicion()]);
                }
            }
        }

        return bufferColumnas.toArray(new String[0]);
    }
}
