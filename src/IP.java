

import java.util.ArrayList;
import java.util.List;

public class IP {
	private String ip;
	private boolean dataInIP = false;
	private boolean options = false;
	

	public String getAdress(String adr) {
		int one = ReadFile.getDecimal(adr.subSequence(0, 3).toString());;
		int two  =  ReadFile.getDecimal(adr.subSequence(3, 6).toString());;
		int three =  ReadFile.getDecimal(adr.subSequence(7, 10).toString());;
		int four =  ReadFile.getDecimal(adr.subSequence(8, 11).toString());;
		System.out.println();
		return one+"."+two+"."+three+"."+four;
	}
	
	public IP(String string, int size) {
		ip = takeIP(string, size);
	}
	
	
	public String takeIP(String t, int size) {
	    //System.out.println(t);

	    String res = "IP \n\tVersion: 4 ";
	    //System.out.println(t);
	    res+="\n\tHeader Length: "+  size*4+ " bytes ("+size+")";
	    res+="\n\tDifferentiated Services Field: 0x00 (DSCP: CS0, ECN: Not-ECT)\n";
	    String totLength = t.subSequence(0, 5).toString();
	    String ident = t.subSequence(6, 12).toString();
	    String flags = t.subSequence(14, 17).toString();
	    String ttl  = t.subSequence(17, 20).toString();
	    String proto = t.subSequence(21, 24).toString();
	    String check= t.subSequence(24, 29).toString();
	    String src= t.subSequence(30, 41).toString();
	    String dest= t.subSequence(41, 53).toString();
	    res+= "\n\tTotal Length: " +  ReadFile.getDecimal(totLength);
	    res+= "\n\tIdentification: 0x" + ident+ "("+ ReadFile.getDecimal(ident) +")";
	    res+= "\n\tFlags: 0x" + flags;
	    res+= "\n\t0... .... .... .... = Reserved bit: Not set";
	    res+= "\n\t.0.. .... .... .... = Don't fragment: Not set";
	    res+= "\n\t..0. .... .... .... = More fragments: Not set";
	    res+="\n\tFragment offset: 0";
	    res+="\n\tTime to live: "+ttl;

		res+="\n\tProtocol: "+proto;

		res+="\n\tHeader checksum: "+check;
		res+="\n\tSource: "+getAdress(src);

		res+="\n\tDestination: "+getAdress(dest);



	   
	    return res;
	}
	
	public String toString() {
		return ip;
	}
	
	
	public boolean dataInIP() {
		return dataInIP;
	}

}

