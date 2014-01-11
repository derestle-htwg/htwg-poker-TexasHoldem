package de.htwg.se.poker.view;

import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.*;

public class TestOutputstream extends OutputStream {

	public void setText(String Text){
		MyText = Text.getBytes();
		position = 0;
	}
		     
	byte[] MyText;
	int position = 0;
	
	@Override
	public void write(int arg0) throws IOException {
		// TODO Auto-generated method stub
		assertTrue(position < MyText.length);
		assertTrue(MyText[position++] == (byte)arg0);
	}

}
