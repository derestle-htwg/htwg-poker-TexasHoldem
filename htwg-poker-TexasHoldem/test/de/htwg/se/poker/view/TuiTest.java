package de.htwg.se.poker.view;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import de.htwg.se.poker.view.*;

public class TuiTest {

	private class TestInputStream extends InputStream
	{
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
	
	private class TestOutputStream extends OutputStream
	{
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
	
	private TestInputStream inStr;
	private TestOutputStream outStr;
	
	Tui testClass;
	@Before
	public void setUp() throws Exception {
		inStr = new TestInputStream();
		outStr = new TestOutputStream();
		
		testClass = new Tui(inStr, new PrintStream(outStr));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTui() {
		
	}

	@Test
	public void testTuiInputStreamPrintStream() {
		
	}

	@Test
	public void testShowTable() {
		
	}

	@Test
	public void testGetNewPlayers() {
		
	}

	@Test
	public void testReadInt() {
		inStr.setText("486321\n");
		assertTrue(testClass.readInt() == 486321);
	}

	@Test
	public void testReadLine() {
		inStr.setText("TestSatz\n123\nTest\n");
		assertTrue(testClass.readLine().equals("TestSatz"));
		assertTrue(testClass.readLine().equals("123"));
		assertTrue(testClass.readLine().equals("Test"));
	}

}
