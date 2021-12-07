
public class UDP {
	String e;
	private boolean dhcp = false;
	private boolean dns = false;

	
	public UDP(String g){
		e=takeUDP(g);
	}
	
	public String takeUDP(String g) {
	    StringBuilder res = new StringBuilder();
	    res.append("\r\nUDP \r\n\t ");
	    int srcPort = ReadFile.getDecimal(g.substring(0, 5));
	    int destPort = ReadFile.getDecimal(g.substring(6,11));
	    String length  = g.substring(11, 18);
	    String checksum  = g.substring(18, 23);
	    if(srcPort == 67 || destPort == 67 ) {
	    	dhcp = true;
	    }
	    if(srcPort == 53 || destPort == 53 ) {
	    	dns = true;
	    }
	    
	    res.append("\r\n\tSource Port : "+ srcPort);
	    res.append("\r\n\tDestination Port : "+ destPort);
	    res.append("\r\n\tLength: " + ReadFile.getDecimal(length));
	    res.append("\r\n\tChecksum: 0x" + checksum.replace(" ", ""));

		return res.toString();
	}
	
	
	public String toString() {
		return e;
	}
	
	public boolean getDHCP() {
		return dhcp;
	}
	
	public boolean getDNS() {
		return dns;
	}
}
