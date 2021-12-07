
public class DHCP {
	String e;

	public DHCP(String g){
		e=takeDHCP(g);
	}
	
	public String getMessageType(String type) {
		switch(type){
    		case "01" : return "DHCP Discover" ; 
    		case "02" : return "DHCP Offer" ;
    		case "03" : return "DHCP Request" ;
    		case "05" : return "DHCP ACK" ; 
    		case "07" : return "DHCP Release" ; 

    	default:
    		break;
		}
		return "";
	}

	public String getOption(String option) {
		StringBuilder parameters = new StringBuilder();
		String messType = option.substring(0, 2);
				
		switch(messType){
    		case "35" : parameters.append("\r\n\tOption: DHCP Message Type = "+ getMessageType(option.substring(4,6))+"\r\n\tValue:"+option); break;
    		case "36" : parameters.append("\r\n\tOption: DHCP Server Identifier =\r\n\tValue:"+option); break;
    		case "74" : parameters.append("\r\n\tOption: DHCP Auto-Configuration = AutoConfigure"+ "\r\n\tValue:"+option); break;
    		case "3d" : parameters.append("\r\n\tOption: Client identifier : "+"\r\n\tValue:"+ option); break;

    		case "32" : parameters.append("\r\n\tOption: Requested IP Address = "+ "\r\n\tValue:"+option); break;

    		case "0c" : parameters.append("\r\n\tOption: Host Name  = "+"\r\n\tValue:"+ option); break;

    		case "3c" : parameters.append("\r\n\tOption: Vendor class identifier = "+"\r\n\tValue:"+ option); break;
    		case "37" : parameters.append("\r\n\tOption: Parameter Request List = "+"\r\n\tValue:"+ option); break;
    		case "01" : parameters.append("\r\n\tOption: Subnet Mask = "+ "\r\n\tValue:"+option); break;
    		case "03" : parameters.append("\r\n\tOption: Router = "+ "\r\n\tValue:"+option); break;
    		case "06" : parameters.append("\r\n\tOption: Domain Name Server = "+"\r\n\tValue:"+ option); break;
    		case "0f" : parameters.append("\r\n\tOption: Domain Name = "+"\r\n\tValue:"+ option); break;
    		case "33" : parameters.append("\r\n\tOption: IP Address Lease Time =  "+ "\r\n\tValue:"+ option); break;    		
    		

    	default:   
    		break;
    	
		}
		return parameters.toString();
		
	}
	
	public String takeDHCP(String g) {
		//System.out.println(g);
		StringBuilder res = new StringBuilder();
	    res.append("\r\nDynamic Host Configuration Protocol \r\n\t");	    
	    String mesType = g.substring(0, 2);
	    if(mesType == "01") {
		    res.append("\r\n\tMessage Type : Boot Request(1) ");
	    }
	    if(mesType == "02") {
		    res.append("\r\n\tMessage Type : Boot Response(2) ");
	    }
	    String hardwareType= g.substring(3,5);
	    String hardwareLength  = g.substring(6, 8);
	    String hops  = g.substring(9, 11);
	    String transactionID  = g.substring(12, 23);
	    String secElapsed  = g.substring(24, 28);
	    String bootpFlags  = g.substring(29, 34);
	    String clientIP  = g.substring(35, 46);
	    String yourClientIP  = g.substring(47, 58);
	    String nextServerIP  = g.substring(59, 70);
	    String relayAgentIP  = g.substring(71, 82);
	    String clientMac  = g.substring(84, 101);
	    String hardwarePadding = "00000000000000000000";
	    

	    
	    res.append("\r\n\tHardware Type: Ethernet ") ;
	    res.append( "\r\n\tHardware address length: " + ReadFile.getDecimal(hardwareLength));
        res.append( "\r\n\tHops: " + ReadFile.getDecimal(hops));
        res.append( "\r\n\tTransaction ID: 0x" + transactionID.replace(" ", ""));
        res.append( "\r\n\tSeconds elapsed: " + ReadFile.getDecimal(secElapsed));
        res.append( "\r\n\tBootp flags: 0x" + bootpFlags.replace(" ", ""));
	    res.append("\r\n\tClient IP adress: " + IP.getAdress(clientIP)) ;
	    res.append("\r\n\tYour (client) IP adress: "+IP.getAdress(yourClientIP)) ;
	    res.append("\r\n\tNext server IP adress: " +IP.getAdress(nextServerIP));
	    res.append("\r\n\tRelay agent IP adress: "+ IP.getAdress(relayAgentIP));
	    res.append("\r\n\tClient MAC adress: " + clientMac.replace(" ",":")) ;
	    res.append("\r\n\tClient hardware adress padding : " +hardwarePadding) ;
	    res.append("\r\n\tServer host name not given");
	    res.append("\r\n\tBoot file name not given");
	    res.append("\r\n\tMagic cookie: DHCP");

	    res.append("\r\n\tDHCP Options ")  ;
	    res.append(takeDHCPOptions(g.substring(720, g.length())));
	    
		return res.toString();
	}

	
	public String takeDHCPOptions(String options) {
		StringBuilder res=new StringBuilder();
		String temp = options.replace(" ", "");
		String firstoption = temp.substring(0, 6);		
		int SOlength = ReadFile.getDecimal(temp.substring(8, 10));
		String secondoption = temp.substring(6,10+2*SOlength);
		res.append(getOption(firstoption));
		res.append( getOption(secondoption));
		int j = 0;
		int length =0;
		String otheroptions = temp.substring(10+2*SOlength,temp.length());
		while(!otheroptions.substring(j,j+2).equals("ff")) {
			
			String nOsOlength = otheroptions.substring(j+2,j+4);
			//System.out.println(nOsOlength);
			length = ReadFile.getDecimal(nOsOlength);
			String newOption = otheroptions.substring(j,j+4+2*length );
			res.append(getOption(newOption));
			//System.out.println(newOption);
			j+=length*2+4;

		}

		return res.toString();
	}

	
	public String toString() {
		return e;
	}
	
	
	
	
}
