
public class DHCP {
	String e;

	public DHCP(String g){
		e=takeDHCP(g);
	}
	
	public String takeDHCP(String g) {
		System.out.println(g);

	    String res = "\n\t Dynamic Host Configuration Protocol";
	    //System.out.println(t);
	    
	    String mesType = g.subSequence(1, 6).toString();
	    String hardwareType= g.substring(7,12).toString();
	    String hardwareLength  = g.subSequence(12, 19).toString();
	    String checksum  = g.subSequence(19, 25).toString();
	    
	    res+="\n\tMessage Type : ";
	    res+="\n\tHardware Type: ";
	    res+= "\n\tHardware address length: " + ReadFile.getDecimal(hardwareLength);
	    res+= "\n\tChecksum: 0x" + checksum;
        
	    
		return res;
	}
	
	
	public String toString() {
		return e;
	}
	
	
	
	
}
