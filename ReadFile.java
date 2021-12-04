

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

	public static int getDecimal(String hex){  
	    String digits = "0123456789ABCDEF";  
	             hex = hex.toUpperCase();  
	             int val = 0;  
	             for (int i = 0; i < hex.length(); i++)  
	             {  
	                 char c = hex.charAt(i);  
	                 int d = digits.indexOf(c);  
	                 val = 16*val + d;  
	             }  
	             return val;  
	}  
	public static void openandprint(File fichier) throws IOException {
		BufferedReader in = null;
		String line;
		char[] rea = new char[100];
		char[] offset = new char[4];

		boolean eth = false;
		int IPsize = 0;
		int lineIndex = 0;
		int reading;
		ArrayList<String> ipData = new ArrayList<>();
        try{
            in = new BufferedReader(new FileReader(fichier));
		    in.read(offset,0,4);
		    String str = new String(offset);
		    in.read(rea,1,44);
		 	Ethernet t = new Ethernet(new String(rea));
		    System.out.println(t);
		    rea = new char[rea.length];

		    in.read(rea,0,3);
		    String ddd = new String(rea);
		    System.out.println(ddd);
		    System.out.print(ddd);

		    IPsize=  getDecimal(ddd);
		    System.out.println(IPsize);
		   // while(in.read(rea,0,99) != -1){
		    	
		   // }
		    /*while((line = in.readLine()) != null){
    		     System.out.println(line);
    		    String word = line.split("\\s+")[0];
    		    int decimal=getDecimal(word); 
    		    System.out.println(decimal);
    		   String[] parts = line.split(" ");
    		    String ethernet = "";
    		    for(int i=1;i<parts.length;i++) {
        		    System.out.println("next: " + parts[i]);
    		    }

    		    if(++lineIndex > 3) {

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
    		    System.out.println(ip);
    		   
    		}*/
        }
        finally{
            if(in != null){
                in.close();
            }
        }
		
	}
	
	
	
	
}
