package de.htwg.se.poker.controller;

import static org.junit.Assert.*;

import java.util.List;

import de.htwg.se.poker.model.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	Deck testDeck;
	@Before
	public void setUp() throws Exception {
		testDeck = new Deck();
	}

	@After
	public void tearDown() throws Exception {
		testDeck = null;
	}

	@Test
	public void testGetCards() {
		List<Card> myCards = testDeck.getCards();
		assertFalse(myCards == null);
	}

	@Test
	public void testDeal() {
		Card karte = testDeck.deal();
		assertFalse(karte == null);
	}

	@Test
	public void testBurn() {
		testDeck.burn();
	}

}
