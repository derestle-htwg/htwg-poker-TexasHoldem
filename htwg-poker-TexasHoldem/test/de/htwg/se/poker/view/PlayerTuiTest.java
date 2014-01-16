package de.htwg.se.poker.view;


import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.htwg.se.poker.model.Card;
import de.htwg.se.poker.model.Card.Rank;
import de.htwg.se.poker.model.Card.Suit;
import de.htwg.se.poker.model.Player;
import de.htwg.se.poker.model.Table;


public class PlayerTuiTest extends TestCase {
	
	PlayerTui myTui;
	TestInputStream myInput;
	TestOutputstream myOutput;
	LinkedList<Player> myPlayers;
	Table myTable;
	
	Player p1;
	Player p2;
	Player p3;
	Player p4;
	
	Card[] myCards;
	@Before
	public void setUp() throws Exception {
		myInput = new TestInputStream();
		myOutput = new TestOutputstream();
		myTui = new PlayerTui(myInput,System.out);//myOutput);
		myPlayers = new LinkedList<Player>();
		p1 = new Player("p1",100.0);
		p2 = new Player("p2",100.0);
		p3 = new Player("p3",100.0);
		p4 = new Player("p4",100.0);
		
		myPlayers.add(p1);
		myPlayers.add(p2);
		myPlayers.add(p3);
		myPlayers.add(p4);
		
		myTable = new Table(myPlayers);
		myCards = new Card[5];
		
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
		myCards[0] = new Card(Rank.THREE,Suit.HEART);
		myCards[1] = new Card(Rank.FIVE,Suit.DIAMOND);
		myCards[2] = new Card(Rank.SIX,Suit.CLUB);
		myTable.setMiddleCards(myCards);
		
		myOutput.setText("");
		
		myTui.showTable(myTable, null);
	}

	@Test
	public void testGetNewPlayers() {
		
	}

	
}
