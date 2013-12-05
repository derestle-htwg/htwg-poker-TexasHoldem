package de.htwg.se.poker.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* A deck consists of 52 cards 
 * 
 * These cards are divided into four suits:
 * 	(HEARTH, CLUB, DIAMOND, SPADE)
 * 
 * each of which contains 13 ranks:
 * 	TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
 * 	JACK, QUEEN, KING, ACE
 * 
 * The suits are all of equal value.
 * That is to say, no suit is higher than any other suit.
 * 
 */

public class Deck implements TableElements{
	
	private final int DECK_SIZE = 52; // Number of Cards on the Deck
	private List<Cards> deck;
	private Cards flop;
	private List<Cards> flopList;
	private final int FLOP_SIZE = 3;
	
	// Create the Deck with 52 cards
	public Deck() {
		deck = new ArrayList<Cards>(DECK_SIZE);
		for (Cards.Suit suit : Cards.Suit.values()) {
			for (Cards.Rank rank : Cards.Rank.values()) {
				getDeckCards().add(new Cards(rank, suit));
			}
		}
		// Create a empty Flop
		flopList = new ArrayList<Cards>(FLOP_SIZE);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	// The Flop contains the first tree Cards on the play
	public List<Cards> getFlop() {
		
		shuffleDeck();
		
		for (int i = 0; i < 3; i++)
		{
			flop=deal();
			flopList.add(flop);
		}
		return flopList;
	}

	public List<Cards> getDeckCards() {
		return deck;
	}
	
	
	/* delete one Card from Deck and return this */
	public Cards deal(){
		Cards card = deck.remove(0);
		return card;
	}

	@Override
	public void setElementOnTable(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getElementFromTable() {
		// TODO Auto-generated method stub
		return null;
	}
	
}