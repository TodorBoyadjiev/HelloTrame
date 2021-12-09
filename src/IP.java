

import java.util.ArrayList;
import java.util.List;

public class IP {
	private String ip;
	private boolean dataInIP = false;
	private boolean options = false;
	

	public static String getAdress(String adr) {
		int one = ReadFile.getDecimal(adr.substring(0, 3));
		int two  =  ReadFile.getDecimal(adr.substring(3, 6));
		int three =  ReadFile.getDecimal(adr.substring(6, 8));
		int four =  ReadFile.getDecimal(adr.substring(8, 11));
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

		StringBuilder res = new StringBuilder();
	    res.append("\r\nIP \r\n\tVersion: 4 \r\n\tHeader Length: "+  iplength*4+ " bytes ("+iplength+")"
	    		 + "\r\n\tDifferentiated Services Field: 0x00 (DSCP: CS0, ECN: Not-ECT)\r\n");

	    
	    String totLength = t.substring(6, 12);
	    String ident = t.substring(12, 18);
	    String flags = t.substring(20, 23);
	    String ttl  = t.substring(23, 26);
	    String proto = t.substring(27, 29);
	    if(proto.equals(11)) {
	    	dataInIP=true;
	    }
	    String check= t.substring(30, 35);
	    String src= t.substring(36, 47);
	    String dest= t.substring(48, 59);
	    res.append("\r\n\tTotal Length: " +  ReadFile.getDecimal(totLength));
	    res.append("\r\n\tIdentification: 0x" + ident.replace(" ", "")+ "("+ ReadFile.getDecimal(ident) +")");

	    res.append("\r\n\tFlags: 0x" + flags.replace(" ", ""));

	    res.append("\r\n\t0... .... .... .... = Reserved bit: Not set");

	    res.append("\r\n\t.0.. .... .... .... = Don't fragment: Not set");


	    res.append("\r\n\t..0. .... .... .... = More fragments: Not set");

	    res.append("\r\n\tFragment offset: 0");
	    res.append("\r\n\tTime to live: "+ttl);

	    res.append("\r\n\tProtocol: "+proto);

	    res.append("\r\n\tHeader checksum: 0x"+check.replace(" ", ""));

	    res.append("\r\n\tSource: "+getAdress(src));

	    res.append("\r\n\tDestination: "+getAdress(dest));
	   
	    return res.toString();
	}
	
	public String toString() {
		return ip;
	}
	
	
	public boolean dataInIP() {
		return dataInIP;
	}

}

