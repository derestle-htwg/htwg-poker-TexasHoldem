package de.htwg.se.poker.model;

import java.util.LinkedList;
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

public class Deck implements TableElementsInterface{
	
	private List<Cards> deck;
	
	
	// Create the Deck with 52 cards
	public Deck() {
		deck = new LinkedList<Cards>();
		for (Cards.Suit suit : Cards.Suit.values()) {
			for (Cards.Rank rank : Cards.Rank.values()) {
				getDeckCards().add(new Cards(rank, suit));
			}
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	// The Flop contains the first tree Cards on the play
	public List<Cards> getDeckCards() {
		return deck;
	}
	
	public int getDeckSize() {
		return deck.size();
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
	public Object getTableElement() {
		// TODO Auto-generated method stub
		return null;
	}
	
}