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

public class Deck {
	
	private final int DECK_SIZE = 52; // Number of Cards on the Deck
	private List<Cards> deck;
	private Cards flop;
	private List<Cards> flopList;
	private final int FLOP_SIZE = 3;
	
	// Hier wird das Deck mit 52 Karten erzeugt
	public Deck() {
		deck = new ArrayList<Cards>(DECK_SIZE);
		for (Cards.Suit suit : Cards.Suit.values()) {
			for (Cards.Rank rank : Cards.Rank.values()) {
				getCard().add(new Cards(rank, suit));
			}
		}
		// Der Flop wird hiermit angelegt, aber leer
		flopList = new ArrayList<Cards>(FLOP_SIZE);
	}
	/* mischt das Deck */
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	// Gibt den Flop aus
	public List<Cards> getFlop() {
		shuffleDeck();
		
		for (int i = 0; i < 3; i++)
		{
			flop=deal();
			flopList.add(flop);
			
			
		}
		return flopList;
	}

	public List<Cards> getCard() {
		return deck;
	}
	
	
	
	/* nimmt eine Karte vom Deck, gibt diese aus 
	 * und entfernt diese vom Deck */
	public Cards deal(){
		Cards card = deck.remove(0);
		return card;
	}
}