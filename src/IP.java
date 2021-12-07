

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
	
	public IP(String string, String size) {
		ip = takeIP(string, size);
	}
	
	
	public String takeIP(String t, String size) {
	    //System.out.println(t);
		
		int iplength = ReadFile.getDecimal(size);
		if(iplength*4==60) {
			options=true;
		}
	    String res = "\r\nIP \r\n\tVersion: 4 ";
	    //System.out.println(t);
	    res+="\r\n\tHeader Length: "+  iplength*4+ " bytes ("+iplength+")";
	    res+="\r\n\tDifferentiated Services Field: 0x00 (DSCP: CS0, ECN: Not-ECT)\r\n";
	    String totLength = t.subSequence(6, 12).toString();
	    String ident = t.subSequence(12, 18).toString();
	    String flags = t.subSequence(20, 23).toString();
	    String ttl  = t.subSequence(23, 26).toString();
	    String proto = t.subSequence(27, 29).toString();
	    String check= t.subSequence(30, 35).toString();
	    String src= t.subSequence(36, 47).toString();
	    String dest= t.subSequence(48, 59).toString();
	    res+= "\r\n\tTotal Length: " +  ReadFile.getDecimal(totLength);
	    res+= "\r\n\tIdentification: 0x" + ident.replace(" ", "")+ "("+ ReadFile.getDecimal(ident) +")";
	    res+= "\r\n\tFlags: 0x" + flags.replace(" ", "");
	    res+= "\r\n\t0... .... .... .... = Reserved bit: Not set";
	    res+= "\r\n\t.0.. .... .... .... = Don't fragment: Not set";
	    res+= "\r\n\t..0. .... .... .... = More fragments: Not set";
	    res+="\r\n\tFragment offset: 0";
	    res+="\r\n\tTime to live: "+ttl;

		res+="\r\n\tProtocol: "+proto;

		res+="\r\n\tHeader checksum: 0x"+check.replace(" ", "");
		res+="\r\n\tSource: "+getAdress(src);

		res+="\r\n\tDestination: "+getAdress(dest);



	   
	    return res;
	}
	
	public String toString() {
		return ip;
	}
	
	
	public boolean dataInIP() {
		return dataInIP;
	}

}

