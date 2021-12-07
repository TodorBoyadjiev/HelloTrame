

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
	
	public static void openandprint(File fichier) throws IOException {
		BufferedReader in = null;
		BufferedWriter output = null;

		int counter = 0;
		String line;
		StringBuilder text = new StringBuilder();
		int octetParLigne = 0;
		int nbOctets=0;
    	int prevOffset = 0;
    	
        try{
        	in = new BufferedReader(new FileReader(fichier));
	        File file = new File("result.txt");
	        output = new BufferedWriter(new FileWriter(file));

	        while((line = in.readLine()) != null){
	        	if(Pattern.compile("0000").matcher(line).find()) {
	        		if(!text.isEmpty()) {

	        			String singleString = text.toString();
	        			AnalyseTrame at = new AnalyseTrame(singleString);
	        			System.out.println(at.analyse());
	        			output.write("\r\nTrame "+ counter+"\r\n");
	        			output.write(at.analyse());

	        		}
	        		//System.out.println(text.toString());
	        		text = new StringBuilder();
        			counter++;
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


	        	//System.out.println(octetParLigne);
	        	for(int i=1;i<parts.length;i++) {
	        		String [] souspartie = parts[i].split(" ");
	        		nbOctets = souspartie.length;
	        		text.append(parts[i]);
	        	}
	        	text.append(" ");

	        	prevOffset = octetParLigne;
	        }
	        if(counter==1) {
    			String singleString = text.toString();
    			AnalyseTrame at = new AnalyseTrame(singleString);
    			System.out.println(at.analyse());
    			output.write("\r\nTrame 1 \r\n");
    			output.write(at.analyse());
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
