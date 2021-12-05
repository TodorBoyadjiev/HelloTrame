

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
		char[] rea = new char[100];
		char[] offset = new char[4];	
		char[] ipSize = new char[1];

		char[] dea = new char[60];
		char[] fea = new char[6];
		char [] udp = new char[100];
		char [] dhcp = new char[100];

		int IPsize = 0;
        try{
            in = new BufferedReader(new FileReader(fichier));
		    in.read(offset,0,4);
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
		    System.out.println(dhcpP);


		    
		    

		    /*while((value = in.read()) != -1) {
		         
	            // converts int to character
	            char c = (char)value;
	            
	            // prints character
	            System.out.println(c);
	        }*/

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
