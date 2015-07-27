package Week3;

import java.io.IOException;

public class BandwidthManager {

	public enum marks {
			ICMP, UDP, RTM, IGMP, DNS, TCP
	};
	
	public static class Packet{
		public String payload;
		public String protocol;
	
		public Packet(String protocol, String payload){
			this.protocol = protocol;
			this.payload = payload;
		}
	}
	
	private Heap<Packet> queue;
	private static final String Error = "Nothing to send!";
	
	public BandwidthManager(){
		queue = new Heap<Packet> ((r1, r2) -> marks.valueOf(r1.protocol).ordinal() - marks.valueOf(r2.protocol).ordinal());
	}
	
	public void rcv(String protocol, String payload) {
		queue.insert(new Packet(protocol, payload));
	}
	
	public String send(){
		return (queue.size() == 0 ? Error : queue.remove().payload);
	}
	
	public static void main(String[] args) throws IOException {
		BandwidthManager bm = new BandwidthManager();
		bm.rcv("UDP", "zxchzrkljhklzrjlkhklzr");
		bm.rcv("TCP", "ghljkajklhgjklare");
		bm.rcv("ICMP", "ping87.129.54.123");
		System.out.println(bm.send());
		System.out.println(bm.send());
		System.out.println(bm.send());
	}

}
