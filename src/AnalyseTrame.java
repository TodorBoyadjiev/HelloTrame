
public class AnalyseTrame {
	private String s;
	public AnalyseTrame(String ss) {
		s=ss;
	}
	
	public String analyse() {
		StringBuilder sb = new StringBuilder();
		System.out.println("RESULT");
		String ethernet = s.subSequence(0,41).toString();
		System.out.println(ethernet);
		Ethernet et = new Ethernet(ethernet);
		sb.append(et.toString());
		String ipLength = s.subSequence(43, 44).toString();
		//System.out.println(ipLength);
		String ipp = s.subSequence(42,101).toString();
		IP ip = new IP(ipp,ipLength);
		sb.append(ip.toString());
		String udpp = s.subSequence(102,150).toString();
		UDP udp = new UDP(udpp);
		sb.append(udp.toString());
		sb.append(ip.toString());
		String result = sb.toString();
		return result;

	}
}
