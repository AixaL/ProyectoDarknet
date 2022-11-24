package procesamiento;

public abstract class ColumnasLinea {
    public String	flow_id;
    public String	src_ip;
    public int		src_port;
    public String	dst_ip;
    public int		dst_port;
    public int		protocol;
    public String	timestamp;

    public long		flow_duration;

    public int		total_fwd_packet;
    public int		total_bwd_packets;
    public int		total_length_of_fwd_packet;
    public int		total_length_of_bwd_packet;

    public int		fwd_packet_length_max;
    public int		fwd_packet_length_min;
    public int		fwd_packet_length_mean;
    public int		fwd_packet_length_std;

    public int		bwd_packet_length_max;
    public int		bwd_packet_length_min;
    public int		bwd_packet_length_mean;
    public int		bwd_packet_length_std;

    public double	flow_bytes_s;
    public double	flow_packets_s;
    public long		flow_iat_mean;
    public long		flow_iat_std;
    public long		flow_iat_max;
    public long		flow_iat_min;

    public long		fwd_iat_total;
    public long		fwd_iat_mean;
    public long		fwd_iat_std;
    public long		fwd_iat_max;
    public long		fwd_iat_min;

    public long		bwd_iat_total;
    public long		bwd_iat_mean;
    public long		bwd_iat_std;
    public long		bwd_iat_max;
    public long		bwd_iat_min;

    public int		fwd_psh_flags;
    public int		bwd_psh_flags;
    public int		fwd_urg_flags;
    public int		bwd_urg_flags;

    public int		fwd_header_length;
    public int		bwd_header_length;
    public double	fwd_packets_s;
    public double	bwd_packets_s;

    public int		packet_length_min;
    public int		packet_length_max;
    public int		packet_length_mean;
    public int		packet_length_std;
    public int		packet_length_variance;

    public int		fin_flag_count;
    public int		syn_flag_count;
    public int		rst_flag_count;
    public int		psh_flag_count;
    public int		ack_flag_count;
    public int		urg_flag_count;
    public int		cwe_flag_count;
    public int		ece_flag_count;

    public double	down_up_ratio;

    public int		average_packet_size;
    public int		fwd_segment_size_avg;
    public int		bwd_segment_size_avg;

    public double	fwd_bytes_bulk_avg;
    public double	fwd_packet_bulk_avg;
    public double	fwd_bulk_rate_avg;

    public double	bwd_bytes_bulk_avg;
    public double	bwd_packet_bulk_avg;
    public double	bwd_bulk_rate_avg;

    public int		subflow_fwd_packets;
    public int		subflow_fwd_bytes;
    public int		subflow_bwd_packets;
    public int		subflow_bwd_bytes;

    public int		fwd_init_win_bytes;
    public int		bwd_init_win_bytes;

    public int		fwd_act_data_pkts;
    public int		fwd_seg_size_min;

    public long		active_mean;
    public long		active_std;
    public long		active_max;
    public long		active_min;

    public long		idle_mean;
    public long		idle_std;
    public long		idle_max;
    public long		idle_min;

    public String	label1;
    public String	label2;
}
