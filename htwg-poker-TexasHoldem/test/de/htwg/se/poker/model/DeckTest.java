package de.htwg.se.poker.model;

import static org.junit.Assert.*;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import de.htwg.se.poker.model.Card.Rank;
import de.htwg.se.poker.model.Card.Suit;

public class DeckTest extends TestCase{

	@Test
	public void test() {
		Deck myDeck = new Deck();
		myDeck.getDeckCards();
		myDeck.getDeckSize();
		myDeck.shuffleDeck();
		
		HashMap<Rank, List<Suit>> myList = new HashMap<Rank,List<Suit>>();
		
		for(Card.Rank r : Rank.values())
		{
			myList.put(r, new LinkedList<Suit>());
			for(Card.Suit s : Suit.values())
			{
				myList.get(r).add(s);
			}
		}
		
		while(myDeck.getDeckSize() > 0)
		{
			Card c = myDeck.deal();
			assertTrue(myList.get(c.getRank()).remove(c.getSuit()));
		}
		
		for(List<Suit> l : myList.values())
		{
			assertTrue(l.isEmpty());
		}
	}

}
