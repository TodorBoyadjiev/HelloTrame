
public class DNS {
	String e;

	public DNS(String g){
		e=takeDNS(g);
	}
	
	public String readQuery(String query) {
		StringBuilder res = new StringBuilder();
		int j = 0;
		int length =0;
		String otheroptions = query;
		while(!otheroptions.substring(j,j+2).equals("00")) {
			
			String nOsOlength = otheroptions.substring(j,j+2);
			//System.out.println(nOsOlength);
			length = ReadFile.getDecimal(nOsOlength);
			//System.out.println(length);
			String newOption = otheroptions.substring(j+2,j+2+2*length );
			res.append(AnalyseTrame.hexToAscii(newOption)+".");
			//System.out.println(newOption);
			j+=length*2+2;
		}
		res.deleteCharAt(res.length()-1);


		return res.toString();
	}
	
	public String readAnswer(String answer) {
		return answer;
		
	}
	public String takeDNS(String g) {
		StringBuilder res = new StringBuilder();
	    res.append("\r\nDNS \r\n\t ");
	    String transID = g.substring(0, 4);
	    String flags = g.substring(4,8);
	    String questions  = g.substring(8, 12);
	    String answers  = g.substring(12, 16);
	    String authority  = g.substring(16, 20);
	    String additional  = g.substring(20, 24);
	    String queries  = readQuery(g.substring(24, g.length()));

	    
	    res.append("\r\n\tTransaction ID : "+transID) ;
	    res.append("\r\n\tFlags: 0x"+flags) ;
	    res.append("\r\n\tQuestions: "+ReadFile.getDecimal(questions));
	    res.append("\r\n\tAnswer RRs: "+ReadFile.getDecimal(answers)) ;
	    res.append("\r\n\tAuthority RRs: "+ReadFile.getDecimal(authority) );
	    res.append("\r\n\tAdditional RRs: "+ReadFile.getDecimal(additional) );
	    res.append("\r\n\tQueries: ") ;

	    res.append("\r\n\t" + queries);
	    
	    /*
	    res.append("\r\n\tAnswers: "+flags) ;
	    res.append("\r\n\tAdditional Records: "+flags );*/



		return res.toString();
	}
	
	
	public String toString() {
		return e;
	}
}
