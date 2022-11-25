package procesamiento;

import java.util.ArrayList;

import static procesamiento.Operador.*;
import static procesamiento.Tipo.*;

public class Extractor extends ColumnasLinea {
    public Extractor(String[] linea) {
        setLinea(linea);

        /*
        flow_id     = linea[0];
        src_ip      = linea[1];
        src_port    = Double.parseDouble(linea[2]);
        dst_ip      = linea[3];
        dst_port    = Double.parseDouble(linea[4]);
        protocol    = Double.parseDouble(linea[5]);
        timestamp   = linea[6];

        flow_duration   = Double.parseDouble(linea[7]);

        total_fwd_packet            = Double.parseDouble(linea[8]);
        total_bwd_packets           = Double.parseDouble(linea[9]);
        total_length_of_fwd_packet  = Double.parseDouble(linea[10]);
        total_length_of_bwd_packet  = Double.parseDouble(linea[11]);

        fwd_packet_length_max   = Double.parseDouble(linea[12]);
        fwd_packet_length_min   = Double.parseDouble(linea[13]);
        fwd_packet_length_mean  = Double.parseDouble(linea[14]);
        fwd_packet_length_std   = Double.parseDouble(linea[15]);

        bwd_packet_length_max   = Double.parseDouble(linea[16]);
        bwd_packet_length_min   = Double.parseDouble(linea[17]);
        bwd_packet_length_mean  = Double.parseDouble(linea[18]);
        bwd_packet_length_std   = Double.parseDouble(linea[19]);

        flow_bytes_s    = Double.parseDouble(linea[20]);
        flow_packets_s  = Double.parseDouble(linea[21]);
        flow_iat_mean   = Double.parseDouble(linea[22]);
        flow_iat_std    = Double.parseDouble(linea[23]);
        flow_iat_max    = Double.parseDouble(linea[24]);
        flow_iat_min    = Double.parseDouble(linea[25]);

        fwd_iat_total   = Double.parseDouble(linea[26]);
        fwd_iat_mean    = Double.parseDouble(linea[27]);
        fwd_iat_std     = Double.parseDouble(linea[28]);
        fwd_iat_max     = Double.parseDouble(linea[29]);
        fwd_iat_min     = Double.parseDouble(linea[30]);

        bwd_iat_total   = Double.parseDouble(linea[31]);
        bwd_iat_mean    = Double.parseDouble(linea[32]);
        bwd_iat_std     = Double.parseDouble(linea[33]);
        bwd_iat_max     = Double.parseDouble(linea[34]);
        bwd_iat_min     = Double.parseDouble(linea[35]);

        fwd_psh_flags  = Double.parseDouble(linea[36]);
        bwd_psh_flags  = Double.parseDouble(linea[37]);
        fwd_urg_flags  = Double.parseDouble(linea[38]);
        bwd_urg_flags  = Double.parseDouble(linea[39]);

        fwd_header_length   = Double.parseDouble(linea[40]);
        bwd_header_length   = Double.parseDouble(linea[41]);
        fwd_packets_s       = Double.parseDouble(linea[42]);
        bwd_packets_s       = Double.parseDouble(linea[43]);

        packet_length_min       = Double.parseDouble(linea[44]);
        packet_length_max       = Double.parseDouble(linea[45]);
        packet_length_mean      = Double.parseDouble(linea[46]);
        packet_length_std       = Double.parseDouble(linea[47]);
        packet_length_variance  = Double.parseDouble(linea[48]);

        fin_flag_count  = Double.parseDouble(linea[49]);
        syn_flag_count  = Double.parseDouble(linea[50]);
        rst_flag_count  = Double.parseDouble(linea[51]);
        psh_flag_count  = Double.parseDouble(linea[52]);
        ack_flag_count  = Double.parseDouble(linea[53]);
        urg_flag_count  = Double.parseDouble(linea[54]);
        cwe_flag_count  = Double.parseDouble(linea[55]);
        ece_flag_count  = Double.parseDouble(linea[56]);

        down_up_ratio   = Double.parseDouble(linea[57]);

        average_packet_size     = Double.parseDouble(linea[58]);
        fwd_segment_size_avg    = Double.parseDouble(linea[59]);
        bwd_segment_size_avg    = Double.parseDouble(linea[60]);

        fwd_bytes_bulk_avg  = Double.parseDouble(linea[61]);
        fwd_packet_bulk_avg = Double.parseDouble(linea[62]);
        fwd_bulk_rate_avg   = Double.parseDouble(linea[63]);

        bwd_bytes_bulk_avg  = Double.parseDouble(linea[64]);
        bwd_packet_bulk_avg = Double.parseDouble(linea[65]);
        bwd_bulk_rate_avg   = Double.parseDouble(linea[66]);

        subflow_fwd_packets = Double.parseDouble(linea[67]);
        subflow_fwd_bytes   = Double.parseDouble(linea[68]);
        subflow_bwd_packets = Double.parseDouble(linea[69]);
        subflow_bwd_bytes   = Double.parseDouble(linea[70]);

        fwd_init_win_bytes  = Double.parseDouble(linea[71]);
        bwd_init_win_bytes  = Double.parseDouble(linea[72]);

        fwd_act_data_pkts   = Double.parseDouble(linea[73]);
        fwd_seg_size_min    = Double.parseDouble(linea[74]);

        active_mean = Double.parseDouble(linea[75]);
        active_std  = Double.parseDouble(linea[76]);
        active_max  = Double.parseDouble(linea[77]);
        active_min  = Double.parseDouble(linea[78]);

        idle_mean   = Double.parseDouble(linea[79]);
        idle_std    = Double.parseDouble(linea[80]);
        idle_max    = Double.parseDouble(linea[81]);
        idle_min    = Double.parseDouble(linea[82]);

        label1  = linea[83];
        label2  = linea[84];

         */


    }

    public Extractor getValores(Boolean[] columnasRequeridas, Filtro[] filtros) throws Exception {

        String[] linea      = getLinea();
        Boolean  aceptada   = false;

        for (Filtro filtro: filtros) {
            switch (filtro.getTipo()) {
                case STRING -> {
                    if (filtro.getOperador() == EQUALS) {
                        if (linea[filtro.getPosicion()].equals(filtro.getValor()))
                            aceptada = true;
                    } else {
                        throw new Exception("Valoe de operador no esperado para String");
                    }
                }
                case DOUBLE -> {
                    Double valorLinea   = Double.parseDouble(linea[filtro.getPosicion()]);
                    Double valorFiltro  = Double.parseDouble(filtro.getValor());

                    switch (filtro.getOperador()) {
                        case EQUALS -> {
                            if(valorLinea.equals(valorFiltro))
                                aceptada = true;
                        }
                        case MORETHAN -> {
                            if(valorLinea > valorFiltro)
                                aceptada = true;
                        }
                        case LESSTHAN  -> {
                            if(valorLinea < valorFiltro)
                                aceptada = true;
                        }
                    }
                }
            }
        }

        ArrayList<String> al = new ArrayList<>();
        for (Columnas columna: Columnas.values()) {
            if (columnasRequeridas[columna.getPosicion()]) {

            }

        }

        return new Extractor(new String[]{"f", "s"});
    }
}
