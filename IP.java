

import java.util.ArrayList;
import java.util.List;

public class IP {
	List l = new ArrayList<>();
	private String ip;
	private boolean dataInIP = false;
	
	
	public IP(ArrayList<String> t) {
		ip = takeIP(t);
	}
	
	
	public String takeIP(ArrayList<String> t) {
	    String res = "IP \n\tVersion: 4 ";
	    //System.out.println(t);
	    int ipLength = ReadFile.getDecimal(t.get(0).subSequence(1, 2).toString());
	    res+="\n\tHeader Length: "+  ipLength*4+ " bytes ("+ipLength+")";
	    //int ipTotalLength = ReadFile.getDecimal(t.get(3).subSequence(3, 5).toString());
		//res+="\n\tTotal Length: "+  ipTotalLength *4+ " bytes ("+ipTotalLength+")";

	    /*for(int i = 1;i<6;i++) {
		    res+=t[i]+ ":";
		    if(i==5) {
		    	res+=t[6];
		    }
		    
	    }
	    res+="\n\tSource IP Adress: ";
	    for(int i = 7;i<12;i++) {
		    res+=t[i]+ ":";
		    if(i==11) {
		    	res+=t[12];
		    }
	    }
	    res+="\n\tType: ";
	    String type = t[13]+t[14];
	    switch(type){
	    	//case "0800" :  dataInEthernet = true; res+="0x"+type+ " (IPv4)"; break;
	    	default:   
	    		//dataInEthernet = false;
	    		break;
	    }*/
	    return res;
	}
	
	public String toString() {
		return ip;
	}
	
	public boolean dataEthernet() {
		return dataInIP;
	}

}

