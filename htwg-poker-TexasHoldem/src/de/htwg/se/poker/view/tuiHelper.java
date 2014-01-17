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
		while(true)
		{
			try {
				return Integer.parseInt(readLine());
			} catch (NumberFormatException e) {
				dataOut.println("Die eingabe konnte nicht in eine Zahl umgewandelt werden!");
			}
		}
	}
	
	public int readInt(int Min, int Max){
		int retVal = 0;
		do
		{
			dataOut.println("Geben sie eine Zahl zwischen " + Min + " und " + Max + " ein.");
			retVal = Integer.parseInt(readLine());
		}
		while(retVal < Min || retVal > Max);
		return retVal;
	}
	
	
}
