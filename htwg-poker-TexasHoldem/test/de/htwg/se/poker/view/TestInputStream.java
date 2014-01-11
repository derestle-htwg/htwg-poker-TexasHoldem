package de.htwg.se.poker.view;

import java.io.IOException;
import java.io.InputStream;

public class TestInputStream extends InputStream {

	public void setText(String Text){
		MyText = Text.getBytes();
		position = 0;
	}
	
	byte[] MyText;
	int position = 0;
	
	@Override
	public int read() throws IOException {
		
		if(position >= MyText.length)
		throw new IOException();
		return (int)MyText[position++];
	}

}
