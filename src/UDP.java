
public class UDP {
	String e;

	public UDP(String g){
		e=takeUDP(g);
	}
	
	public String takeUDP(String g) {
		System.out.println(g);

	    String res = "UDP \n\t ";
	    String srcPort = g.subSequence(1, 6).toString();
	    String destPort = g.substring(7,12).toString();
	    String length  = g.subSequence(12, 19).toString();
	    String checksum  = g.subSequence(19, 25).toString();


	    res+="\n\tSource Port : "+ReadFile.getDecimal(srcPort) ;
	    res+="\n\tDestination Port : "+ReadFile.getDecimal(destPort) ;
	    res+= "\n\tLength: " + ReadFile.getDecimal(length);
	    res+= "\n\tChecksum: 0x" + checksum;
	    
	   

		return res;
	}
	
	
	public String toString() {
		return e;
	}
}
