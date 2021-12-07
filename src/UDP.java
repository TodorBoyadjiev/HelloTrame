
public class UDP {
	String e;

	public UDP(String g){
		e=takeUDP(g);
	}
	
	public String takeUDP(String g) {
	    String res = "\r\nUDP \r\n\t ";
	    String srcPort = g.subSequence(0, 5).toString();
	    String destPort = g.substring(6,11).toString();
	    String length  = g.subSequence(11, 18).toString();
	    String checksum  = g.subSequence(18, 24).toString();


	    res+="\r\n\tSource Port : "+ReadFile.getDecimal(srcPort) ;
	    res+="\r\n\tDestination Port : "+ReadFile.getDecimal(destPort) ;
	    res+= "\r\n\tLength: " + ReadFile.getDecimal(length);
	    res+= "\r\n\tChecksum: 0x" + checksum.replace(" ", "");

		return res;
	}
	
	
	public String toString() {
		return e;
	}
}
