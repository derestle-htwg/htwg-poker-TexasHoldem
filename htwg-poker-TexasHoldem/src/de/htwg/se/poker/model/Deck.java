package de.htwg.se.poker.model;

import java.util.ArrayList;
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

public class Deck {
	
	private final int DECK_SIZE = 52;
	private final List<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>(DECK_SIZE);
		
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Rank rank : Card.Rank.values()) {
				getCards().add(new Card(rank, suit));
			}
		}
	}
	
	//public void shuffleDeck() {
		//Collections.shuffle(getCards());
	//}

	public List<Card> getCards() {
		return cards;
	}
	
	public Card deal(){
		return cards.remove(0);
	}
	
	public void burn() {
		cards.remove(0);
	}

}