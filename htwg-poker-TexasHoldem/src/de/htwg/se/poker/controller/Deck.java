package de.htwg.se.poker.controller;

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
	private final List<CreateCard> cards;

	public Deck() {
		cards = new ArrayList<CreateCard>(DECK_SIZE);
		
		for (CreateCard.Suit suit : CreateCard.Suit.values()) {
			for (CreateCard.Rank rank : CreateCard.Rank.values()) {
				getCards().add(new CreateCard(rank, suit));
			}
		}
	}
	
	//public void shuffleDeck() {
		//Collections.shuffle(getCards());
	//}

	public List<CreateCard> getCards() {
		return cards;
	}
	
	public CreateCard deal(){
		return cards.remove(0);
	}
	
	public void burn() {
		cards.remove(0);
	}

}