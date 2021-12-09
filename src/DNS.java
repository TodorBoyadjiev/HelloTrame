
public class DNS {
	String e;
	private int endQuery;

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
		endQuery=j;
		res.deleteCharAt(res.length()-1);


		return res.toString();
	}
	
	public String readAnswer(String answer) {
		StringBuilder res = new StringBuilder();
		res.append("\t");
		int j = 0;
		int length =0;
		String otheroptions = answer;
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
		j+=2;
		res.deleteCharAt(res.length()-1);
		String type = otheroptions.substring(j,j+4);
		String cLass = otheroptions.substring(j+4, j+8);
		//System.out.println(type);
		//System.out.println(cLass);
		res.append("\r\n\t\tType : 0x" + type);
		res.append("\r\n\t\tClass : 0x" + cLass);

		return res.toString();
		
	}
	
	public String readAdditRecords(String query) {
		StringBuilder res = new StringBuilder();
		int j = 0;
		int length =0;
		String otheroptions = query;
		res.append("<Root>: type OPT");
		res.append("<Root>: type OPT");

		
		endQuery=j;
		res.deleteCharAt(res.length()-1);


		return res.toString();
	}
	public String takeDNS(String g) {
		StringBuilder res = new StringBuilder();
	    res.append("\r\nDNS \r\n\t ");
	    String transID = g.substring(0, 4);
	    String flags = g.substring(4,8);
	    int questions  = ReadFile.getDecimal(g.substring(8, 12)) ;
	    int answerRR  = ReadFile.getDecimal(g.substring(12, 16));
	    int authority  = ReadFile.getDecimal(g.substring(16, 20));
	    int additional  = ReadFile.getDecimal(g.substring(20, 24));
	    String queries  = readQuery(g.substring(24, g.length()));
	    String answers  = readAnswer(g.substring(endQuery, g.length()));

	    
	    res.append("\r\n\tTransaction ID : "+transID) ;
	    res.append("\r\n\tFlags: 0x"+flags) ;
	    res.append("\r\n\tQuestions: "+questions);
	    res.append("\r\n\tAnswer RRs: "+answerRR) ;
	    res.append("\r\n\tAuthority RRs: "+ authority);
	    res.append("\r\n\tAdditional RRs: "+additional );
	    if(questions>0) {
		    res.append("\r\n\tQueries: ") ;
		    res.append("\r\n\t\t" + queries);

	    }
	    if(answerRR>0) {
		    res.append("\r\n\tAnswers: ") ;
		    res.append("\r\n\t" + answers);

	    }
	    if(authority>0) {
		    res.append("\r\n\tAuthority records: ") ;

	    }
	    if(additional>0) {
		    res.append("\r\n\tAdditional records: ") ;

	    }



		return res.toString();
	}
	
	
	public String toString() {
		return e;
	}
}
