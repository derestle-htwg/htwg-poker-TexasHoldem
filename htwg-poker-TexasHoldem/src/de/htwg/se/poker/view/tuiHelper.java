package de.htwg.se.poker.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class tuiHelper {
	InputStream dataIn;
	PrintStream dataOut;
	public tuiHelper(InputStream inStr, PrintStream outStr){
		dataIn = inStr;
		dataOut = outStr;
	}
}
