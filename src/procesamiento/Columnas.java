package procesamiento;

import static procesamiento.Tipo.DOUBLE;
import static procesamiento.Tipo.STRING;

public enum Columnas {
    C00 ( 0, "flow_id",                     STRING ),
    C01 ( 1, "src_ip",                      STRING ),
    C02 ( 2, "src_port",                    DOUBLE ),
    C03 ( 3, "dst_ip",                      STRING ),
    C04 ( 4, "dst_port",                    DOUBLE ),
    C05 ( 5, "protocol",                    DOUBLE ),
    C06 ( 6, "timestamp",                   STRING ),
    C07 ( 7, "flow_duration",               DOUBLE ),
    C08 ( 8, "total_fwd_packet",            DOUBLE ),
    C09 ( 9, "total_bwd_packets",           DOUBLE ),
    C10 ( 10, "total_length_of_fwd_packet", DOUBLE ),
    C11 ( 11, "total_length_of_bwd_packet", DOUBLE ),
    C12 ( 12, "fwd_packet_length_max",      DOUBLE ),
    C13 ( 13, "fwd_packet_length_min",      DOUBLE ),
    C14 ( 14, "fwd_packet_length_mean",     DOUBLE ),
    C15 ( 15, "fwd_packet_length_std",      DOUBLE ),
    C16 ( 16, "bwd_packet_length_max",      DOUBLE ),
    C17 ( 17, "bwd_packet_length_min",      DOUBLE ),
    C18 ( 18, "bwd_packet_length_mean",     DOUBLE ),
    C19 ( 19, "bwd_packet_length_std",      DOUBLE ),
    C20 ( 20, "flow_bytes_s",               DOUBLE ),
    C21 ( 21, "flow_packets_s",             DOUBLE ),
    C22 ( 22, "flow_iat_mean",              DOUBLE ),
    C23 ( 23, "flow_iat_std",               DOUBLE ),
    C24 ( 24, "flow_iat_max",               DOUBLE ),
    C25 ( 25, "flow_iat_min",               DOUBLE ),
    C26 ( 26, "fwd_iat_total",              DOUBLE ),
    C27 ( 27, "fwd_iat_mean",               DOUBLE ),
    C28 ( 28, "fwd_iat_std",                DOUBLE ),
    C29 ( 29, "fwd_iat_max",                DOUBLE ),
    C30 ( 30, "fwd_iat_min",                DOUBLE ),
    C31 ( 31, "bwd_iat_total",              DOUBLE ),
    C32 ( 32, "bwd_iat_mean",               DOUBLE ),
    C33 ( 33, "bwd_iat_std",                DOUBLE ),
    C34 ( 34, "bwd_iat_max",                DOUBLE ),
    C35 ( 35, "bwd_iat_min",                DOUBLE ),
    C36 ( 36, "fwd_psh_flags",              DOUBLE ),
    C37 ( 37, "bwd_psh_flags",              DOUBLE ),
    C38 ( 38, "fwd_urg_flags",              DOUBLE ),
    C39 ( 39, "bwd_urg_flags",              DOUBLE ),
    C40 ( 40, "fwd_header_length",          DOUBLE ),
    C41 ( 41, "bwd_header_length",          DOUBLE ),
    C42 ( 42, "fwd_packets_s",              DOUBLE ),
    C43 ( 43, "bwd_packets_s",              DOUBLE ),
    C44 ( 44, "packet_length_min",          DOUBLE ),
    C45 ( 45, "packet_length_max",          DOUBLE ),
    C46 ( 46, "packet_length_mean",         DOUBLE ),
    C47 ( 47, "packet_length_std",          DOUBLE ),
    C48 ( 48, "packet_length_variance",     DOUBLE ),
    C49 ( 49, "fin_flag_count",             DOUBLE ),
    C51 ( 51, "rst_flag_count",             DOUBLE ),
    C52 ( 52, "psh_flag_count",             DOUBLE ),
    C50 ( 50, "syn_flag_count",             DOUBLE ),
    C53 ( 53, "ack_flag_count",             DOUBLE ),
    C54 ( 54, "urg_flag_count",             DOUBLE ),
    C55 ( 55, "cwe_flag_count",             DOUBLE ),
    C56 ( 56, "ece_flag_count",             DOUBLE ),
    C57 ( 57, "down_up_ratio",              DOUBLE ),
    C58 ( 58, "average_packet_size",        DOUBLE ),
    C59 ( 59, "fwd_segment_size_avg",       DOUBLE ),
    C60 ( 60, "bwd_segment_size_avg",       DOUBLE ),
    C61 ( 61, "fwd_bytes_bulk_avg",         DOUBLE ),
    C62 ( 62, "fwd_packet_bulk_avg",        DOUBLE ),
    C63 ( 63, "fwd_bulk_rate_avg",          DOUBLE ),
    C64 ( 64, "bwd_bytes_bulk_avg",         DOUBLE ),
    C65 ( 65, "bwd_packet_bulk_avg",        DOUBLE ),
    C66 ( 66, "bwd_bulk_rate_avg",          DOUBLE ),
    C67 ( 67, "subflow_fwd_packets",        DOUBLE ),
    C68 ( 68, "subflow_fwd_bytes",          DOUBLE ),
    C69 ( 69, "subflow_bwd_packets",        DOUBLE ),
    C70 ( 70, "subflow_bwd_bytes",          DOUBLE ),
    C71 ( 71, "fwd_init_win_bytes",         DOUBLE ),
    C72 ( 72, "bwd_init_win_bytes",         DOUBLE ),
    C73 ( 73, "fwd_act_data_pkts",          DOUBLE ),
    C74 ( 74, "fwd_seg_size_min",           DOUBLE ),
    C75 ( 75, "active_mean",                DOUBLE ),
    C76 ( 76, "active_std",                 DOUBLE ),
    C77 ( 77, "active_max",                 DOUBLE ),
    C78 ( 78, "active_min",                 DOUBLE ),
    C79 ( 79, "idle_mean",                  DOUBLE ),
    C80 ( 70, "idle_std",                   DOUBLE ),
    C81 ( 81, "idle_max",                   DOUBLE ),
    C82 ( 82, "idle_min",                   DOUBLE ),
    C83 ( 83, "label1",                     STRING ),
    C84 ( 84, "label2",                     STRING );

    private int     posicion;
    private String  nombre;
    private Tipo    tipo;

    Columnas(int posicion, String nombre, Tipo tipo) {
        this.setPosicion(posicion);
        this.setNombre(nombre);
        this.setTipo(tipo);
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
