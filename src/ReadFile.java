

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadFile {

	public static int getDecimal(String hex){  
		String digits = "0123456789ABCDEF";  
		hex = hex.toUpperCase();  
		int val = 0;  
		for (int i = 0; i < hex.length(); i++)  
		{  
			char c = hex.charAt(i);  
			if(c==' ') {
				continue;
			}
			int d = digits.indexOf(c);  
			val = 16*val + d;  
		}  
		return val;  
	} 
	public static void readn(BufferedReader bf, int n) throws IOException {
		for(int i = 0; i<n;i++) {
	        bf.read();
		}
	}
	public static void openandprint(File fichier) throws IOException {
		BufferedReader in = null;
		BufferedWriter output = null;

		String line;
		StringBuilder text = new StringBuilder();
		int octetParLigne = 0;
		int prevLength = 0;
		int nbOctets=0;
    	int prevOffset = 0;
    	int prevNbOctets = 0;
    	
        try{
           
        	in = new BufferedReader(new FileReader(fichier));
	         File file = new File("result.txt");
	         output = new BufferedWriter(new FileWriter(file));



        	//Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.txt"), "utf-8"));
		    ///    NOT USED
        	/*in.read(offset,0,4);
		    String str = new String(offset);
		    in.read(rea,0,44);
		 	Ethernet t = new Ethernet(new String(rea));
		    System.out.println(t);
		    rea = new char[rea.length];
	        int value = 0;
	        in.read();
	        in.read();
		    in.read(ipSize,0,1);
	        readn(in, 12);
		    String ddd = new String(ipSize);
		    IPsize=  getDecimal(ddd);
		    
		    in.read(dea,0,16*3);
		    
	        readn(in,8);
		    in.read(dea,16*3,5);
		 
		    IP ip = new IP(new String(dea), IPsize);
		    System.out.println(ip);
		    in.read(udp,0,25);
		    in.read(dhcp,0,25);


		    String udpString = new String(udp);
		    String dhcpString = new String(dhcp);

		    UDP udpP = new UDP(new String(udpString));
		    DHCP dhcpP = new DHCP(new String(dhcpString));

		    System.out.println(udpP);
		    System.out.println(dhcpP);*/


		    while((line = in.readLine()) != null){
		    	if(Pattern.compile("0000").matcher(line).find()) {
		    		if(!text.isEmpty()) {
		    			String singleString = text.toString();
		    			AnalyseTrame at = new AnalyseTrame(singleString);
    		        	System.out.println(at.analyse());
    		        	output.write("\r\nTrame \r\n");
		    		    output.write(at.analyse());
		    		
		    		}
				    System.out.println(text.toString());
		    		text = new StringBuilder();
		    		prevOffset=0;
		    	}
		    	
		    	if(!(Pattern.compile("^[0-9A-Fa-f]{4}").matcher(line).find()) && (!line.isBlank())) {
		    		continue;
		    	}
		    	
		    	String[] parts = line.split("   ");
		    	octetParLigne = getDecimal(parts[0]);
		    	if(octetParLigne-prevOffset != nbOctets && octetParLigne!=0 && !parts[0].equals("0000")&& !parts[0].equals("0")) {
		    		System.out.println("ERROR IN FILE : OFFSET " + octetParLigne);
		    	}
		        
		    	
		    	System.out.println(octetParLigne);
    		    for(int i=1;i<parts.length;i++) {
    		    	String [] souspartie = parts[i].split(" ");
    		    	nbOctets = souspartie.length;
	    		    text.append(parts[i]);
	    		}
	    		text.append(" ");

		    	prevOffset = octetParLigne;
			    	
		    	
    		    //System.out.println(line);
    		    /*String word = line.split("\\s+")[0];
    		    int decimal=getDecimal(word); 
    		    System.out.println(decimal);*/
    		    
   		     	
    		    
    		    // ONE FLE
    		    
    		    // second file
    		    
    		    // third file...

    		    /*if(++lineIndex > 3) {

    		    }
    		    if(!eth) {
    		    	eth=true;
        		    //Ethernet t = new Ethernet(parts);
        		    //System.out.println(t);
    		    }
    		    
    		   
    		    if(IPsize==0) {
        		    IPsize=getDecimal(parts[15].subSequence(1, 2).toString())*4; 
        		    //System.out.println(IPsize*4);
    		    }    		  
    		    int res = in.read(rea,0,5);
    		    System.out.println(res);	
    		    for(int i =0;i<rea.length;i++) {
    		    	System.out.print(rea[i]);
    		    }
    		    int i =15;
    		    while(i<17) {
    		    	ipData.add(parts[i]);
    		    	i++;
    		    }
    		    IP ip = new IP(ipData);
    		    System.out.println(ip);*/
    		   
    		}



        }
        finally{
            if(in != null){
                in.close();
            }
            if ( output != null ) {
	            output.close();
	         }
        }
		
	}
	
	
	
	
}
