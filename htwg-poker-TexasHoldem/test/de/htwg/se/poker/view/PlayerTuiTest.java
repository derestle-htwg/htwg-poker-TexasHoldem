package de.htwg.se.poker.view;


import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.poker.controller.GameMaster;
import de.htwg.se.poker.model.Card;
import de.htwg.se.poker.model.Card.Rank;
import de.htwg.se.poker.model.Card.Suit;
import de.htwg.se.poker.model.Player;
import de.htwg.se.poker.model.Table;


public class PlayerTuiTest extends TestCase {
	
	PlayerTui myTui;
	TestInputStream myInput;
	TestOutputstream myOutput;

	@Before
	public void setUp() throws Exception {
		myInput = new TestInputStream();
		//myOutput = new TestOutputstream();
		
		myInput.setText("d1\n1\n5\n5\n5\n5\n5\n5\n5\n5\n3\n");
		myTui = new PlayerTui(myInput,System.out);
		Player p1 = new Player(100.0, myTui);
		myTui.setPlayer(p1);
		
		myInput.setText("d2\n1\n5\n5\n5\n5\n5\n5\n5\n5\n3\n");
		myTui = new PlayerTui(myInput,System.out);
		Player p2 = new Player(100.0, myTui);
		myTui.setPlayer(p2);
		
		myInput.setText("d3\n5\n5\n5\n5\n5\n5\n5\n5\n3\n");
		myTui = new PlayerTui(myInput,System.out);
		Player p3 = new Player(100.0, myTui);
		myTui.setPlayer(p3);
		
		LinkedList<Player> lp = new LinkedList<Player>();
		lp.add(p1);
		lp.add(p2);
		lp.add(p3);
		
		gm = new GameMaster(lp);
		
		
	}
	GameMaster gm;
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTui() {
		// myOutput);
		gm.StartGame();
	}
	
}
