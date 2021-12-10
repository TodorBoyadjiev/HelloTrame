
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
	public static void main(String args[]) throws IOException{
		
		// Hello Trame
		if(args[0].isEmpty()) {
			System.out.println("Argument missing : Main <ProtocolTextFile>");
		}else {
			ReadFile.openandprint(new File(args[0]));

		}
		//ReadFile.openandprint(new File("tramedns.txt"));
		
		
	   
	}
}
