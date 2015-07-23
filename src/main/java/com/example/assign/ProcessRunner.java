package com.example.assign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessRunner {

	public static String runCommand(String command)  throws IOException, InterruptedException{
		
		System.out.println("Running command "+command);
		StringBuffer output = new StringBuffer();
		Process p = Runtime.getRuntime().exec(command);		 
		    BufferedReader reader = 
		         new BufferedReader(new InputStreamReader(p.getInputStream()));
		 
		    String line = "";			
		    while ((line = reader.readLine())!= null) {
			output.append(line + "\n");
		    }
		   return output.toString();
	}
	
	/*public static void main(String[] args) throws IOException, InterruptedException{
	
		String command = "df -h";
		runCommand(command);
	}*/
}
