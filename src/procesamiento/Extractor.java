package procesamiento;

import procesamiento.filtro.Filtro;

import java.util.ArrayList;

public class Extractor extends ColumnasLinea {
    public Extractor(String[] linea) {
        setLinea(linea);
    }

    public Extractor getValores(Boolean[] columnasRequeridas, Filtro[] filtros) throws Exception {

        String[] linea      = getLinea();
        //Filtrado.pasaFiltro(linea, filtros);

        ArrayList<String> al = new ArrayList<>();
        for (Columnas columna: Columnas.values()) {
            if (columnasRequeridas[columna.getPosicion()]) {

            }

        }

        return new Extractor(new String[]{"f", "s"});
    }
}
