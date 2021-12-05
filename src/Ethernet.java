

public class Ethernet {
	private String ethernet;
	private boolean dataInEthernet = false;
	
	public Ethernet(String t) {
		ethernet = takeEthernet(t);
	}
	
	public String takeEthernet(String t) {
	    //System.out.println(t);
	    String dest = t.subSequence(3, 20).toString().replace(" ",":");
	    String src = t.subSequence(21, 38).toString().replace(" ",":");
	    String type = t.subSequence(39, 44).toString().replace(" ","");
	    String res = "Ethernet \n\tDestination MAC Adress: " + dest;
	    res+="\n\tSource MAC Adress: "+ src;



	    /*
	    for(int i = 1;i<6;i++) {
		    res+=t[i]+ ":";
		    if(i==5) {
		    	res+=t[6];
		    }
		    
	    }
	    res+="\n\tSource MAC Adress: ";
	    for(int i = 7;i<12;i++) {
		    res+=t[i]+ ":";
		    if(i==11) {
		    	res+=t[12];
		    }
		    */
	    switch(type){
	    	case "0800" :  dataInEthernet = true; res+="\n\tType: 0x"+ type+ " (IPv4)"; break;
	
	    	default:   
	    		res+="\n\tType: "+ type;
	    		dataInEthernet = false;
	    		break;
	    	
	    }
	    return res;
	}
	
	public String toString() {
		return ethernet;
	}
	
	public boolean dataEthernet() {
		return dataInEthernet;
	}

}
