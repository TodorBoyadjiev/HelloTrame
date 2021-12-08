
public class AnalyseTrame {
	private String s;
	public AnalyseTrame(String ss) {
		s=ss;
	}
	

	public static String hexToAscii(String hex) {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < hex.length(); i+=2) {
		    String str = hex.substring(i, i+2);
		    output.append((char)Integer.parseInt(str, 16));
		}
		//System.out.println(output);
		return output.toString();
	}
	
	public String analyse() {
		StringBuilder sb = new StringBuilder();
		//System.out.println("RESULT");
		String ethernet = s.substring(0,41);
		//System.out.println(ethernet);
		Ethernet et = new Ethernet(ethernet);
		sb.append(et.toString());
		String ipLength = s.substring(43, 44);
		//System.out.println(ipLength);
		String ipp = s.substring(42,101);
		IP ip = new IP(ipp,ipLength);
		sb.append(ip.toString());
		String udpp = s.substring(102,125);
		//System.out.println(udpp);
		UDP udp = new UDP(udpp);
		sb.append(udp.toString());
		if(udp.getDNS()) {
			String dnspp = s.substring(126,s.length());
			DNS dns = new DNS(dnspp.replace(" ", ""));
			sb.append(dns.toString());
		}
		if(udp.getDHCP()) {
			String dhcpp = s.substring(126,s.length());
			DHCP dhcp = new DHCP(dhcpp);
			sb.append(dhcp.toString());
		}

		String result = sb.toString();
		return result;

	}
}
