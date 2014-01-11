package de.htwg.se.poker.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class tuiHelperTest extends TestCase{

	tuiHelper myHelper;
	TestInputStream inStr;
	TestOutputstream outStr;
	
	@Before
	public void setUp() throws Exception {
		inStr = new TestInputStream();
		outStr = new TestOutputstream(); 
		
		myHelper = new tuiHelper(inStr, new PrintStream(outStr));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTuiHelperReadLine() {
		inStr.setText("Meine\nneue\nZeile\n");
		assertTrue(myHelper.readLine().equals("Meine"));
		assertTrue(myHelper.readLine().equals("neue"));
		assertTrue(myHelper.readLine().equals("Zeile"));
	}
	
	@Test
	public void testTuiHelperReadInt() {
		inStr.setText("256\n783541\n");
		assertTrue(myHelper.readInt() == 256);
		assertTrue(myHelper.readInt() == 783541);
		
	}

}
