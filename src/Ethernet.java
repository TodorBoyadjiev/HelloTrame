

public class Ethernet {
	private String ethernet;
	private boolean dataInEthernet = false;
	
	public Ethernet(String t) {
		ethernet = takeEthernet(t);
	}
	
	public String takeEthernet(String t) {
	    //System.out.println(t);
		StringBuilder res = new StringBuilder();
	    String dest = t.substring(0, 17).replace(" ",":");
	    String src = t.substring(18, 35).replace(" ",":");
	    String type = t.substring(36, 41).replace(" ","");
	    res.append("Ethernet \r\n\tDestination MAC Adress: " + dest+"\r\n\tSource MAC Adress: "+ src);

	    switch(type){
	    	case "0800" :  dataInEthernet = true; res.append("\r\n\tType: 0x"+ type+ " (IPv4)"); break;
	
	    	default:   
	    		res.append("\n\tType: "+ type);
	    		dataInEthernet = false;
	    		break;
	    	
	    }
	    return res.toString();
	}
	
	public String toString() {
		return ethernet;
	}
	
	public boolean dataEthernet() {
		return dataInEthernet;
	}

}
