package procesamiento;

public class Extractor extends ColumnasLinea {
    public Extractor(String[] linea) {
        flow_id     = linea[0];
        src_ip      = linea[1];
        src_port    = Integer.parseInt(linea[2]);
        dst_ip      = linea[3];
        dst_port    = Integer.parseInt(linea[4]);
        protocol    = Integer.parseInt(linea[5]);
        timestamp   = linea[6];

        flow_duration   = Long.parseLong(linea[7]);

        total_fwd_packet            = Integer.parseInt(linea[8]);
        total_bwd_packets           = Integer.parseInt(linea[9]);
        total_length_of_fwd_packet  = Integer.parseInt(linea[10]);
        total_length_of_bwd_packet  = Integer.parseInt(linea[11]);

        fwd_packet_length_max   = Integer.parseInt(linea[12]);
        fwd_packet_length_min   = Integer.parseInt(linea[13]);
        fwd_packet_length_mean  = Integer.parseInt(linea[14]);
        fwd_packet_length_std   = Integer.parseInt(linea[15]);

        bwd_packet_length_max   = Integer.parseInt(linea[16]);
        bwd_packet_length_min   = Integer.parseInt(linea[17]);
        bwd_packet_length_mean  = Integer.parseInt(linea[18]);
        bwd_packet_length_std   = Integer.parseInt(linea[19]);

        flow_bytes_s    = Double.parseDouble(linea[20]);
        flow_packets_s  = Double.parseDouble(linea[21]);
        flow_iat_mean   = Long.parseLong(linea[22]);
        flow_iat_std    = Long.parseLong(linea[23]);
        flow_iat_max    = Long.parseLong(linea[24]);
        flow_iat_min    = Long.parseLong(linea[25]);

        fwd_iat_total   = Long.parseLong(linea[26]);
        fwd_iat_mean    = Long.parseLong(linea[27]);
        fwd_iat_std     = Long.parseLong(linea[28]);
        fwd_iat_max     = Long.parseLong(linea[29]);
        fwd_iat_min     = Long.parseLong(linea[30]);

        bwd_iat_total   = Long.parseLong(linea[31]);
        bwd_iat_mean    = Long.parseLong(linea[32]);
        bwd_iat_std     = Long.parseLong(linea[33]);
        bwd_iat_max     = Long.parseLong(linea[34]);
        bwd_iat_min     = Long.parseLong(linea[35]);

        fwd_psh_flags  = Integer.parseInt(linea[36]);
        bwd_psh_flags  = Integer.parseInt(linea[37]);
        fwd_urg_flags  = Integer.parseInt(linea[38]);
        bwd_urg_flags  = Integer.parseInt(linea[39]);

        fwd_header_length   = Integer.parseInt(linea[40]);
        bwd_header_length   = Integer.parseInt(linea[41]);
        fwd_packets_s       = Double.parseDouble(linea[42]);
        bwd_packets_s       = Double.parseDouble(linea[43]);

        packet_length_min       = Integer.parseInt(linea[44]);
        packet_length_max       = Integer.parseInt(linea[45]);
        packet_length_mean      = Integer.parseInt(linea[46]);
        packet_length_std       = Integer.parseInt(linea[47]);
        packet_length_variance  = Integer.parseInt(linea[48]);

        fin_flag_count  = Integer.parseInt(linea[49]);
        syn_flag_count  = Integer.parseInt(linea[50]);
        rst_flag_count  = Integer.parseInt(linea[51]);
        psh_flag_count  = Integer.parseInt(linea[52]);
        ack_flag_count  = Integer.parseInt(linea[53]);
        urg_flag_count  = Integer.parseInt(linea[54]);
        cwe_flag_count  = Integer.parseInt(linea[55]);
        ece_flag_count  = Integer.parseInt(linea[56]);

        down_up_ratio   = Double.parseDouble(linea[57]);

        average_packet_size     = Integer.parseInt(linea[58]);
        fwd_segment_size_avg    = Integer.parseInt(linea[59]);
        bwd_segment_size_avg    = Integer.parseInt(linea[60]);

        fwd_bytes_bulk_avg  = Double.parseDouble(linea[61]);
        fwd_packet_bulk_avg = Double.parseDouble(linea[62]);
        fwd_bulk_rate_avg   = Double.parseDouble(linea[63]);

        bwd_bytes_bulk_avg  = Double.parseDouble(linea[64]);
        bwd_packet_bulk_avg = Double.parseDouble(linea[65]);
        bwd_bulk_rate_avg   = Double.parseDouble(linea[66]);

        subflow_fwd_packets = Integer.parseInt(linea[67]);
        subflow_fwd_bytes   = Integer.parseInt(linea[68]);
        subflow_bwd_packets = Integer.parseInt(linea[69]);
        subflow_bwd_bytes   = Integer.parseInt(linea[70]);

        fwd_init_win_bytes  = Integer.parseInt(linea[71]);
        bwd_init_win_bytes  = Integer.parseInt(linea[72]);

        fwd_act_data_pkts   = Integer.parseInt(linea[73]);
        fwd_seg_size_min    = Integer.parseInt(linea[74]);

        active_mean = Long.parseLong(linea[75]);
        active_std  = Long.parseLong(linea[76]);
        active_max  = Long.parseLong(linea[77]);
        active_min  = Long.parseLong(linea[78]);

        idle_mean   = Long.parseLong(linea[79]);
        idle_std    = Long.parseLong(linea[80]);
        idle_max    = Long.parseLong(linea[81]);
        idle_min    = Long.parseLong(linea[82]);

        label1  = linea[83];
        label2  = linea[84];

    }

    public Extractor getValores(Boolean[] columnasRequeridas, String[] filtro) {
        String[] salida = {"salida"};
        return new Extractor(salida);
    }
}
