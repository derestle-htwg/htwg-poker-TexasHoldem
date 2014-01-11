package de.htwg.se.poker.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class tuiHelper {
	PrintStream dataOut;
	BufferedReader br;
	
	public tuiHelper(InputStream inStr, PrintStream outStr){
		br = new BufferedReader(new InputStreamReader(inStr));
		dataOut = outStr;
	}

	public String readLine() {
		// TODO Auto-generated method stub
		String retVal = "";
		try {
			retVal = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

	public int readInt(){
		return Integer.parseInt(readLine());
	}
	
	
}
