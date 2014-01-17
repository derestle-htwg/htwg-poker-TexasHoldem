package de.htwg.se.poker.model;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private List<Card> deck;
	
	
	// Create the Deck with 52 cards
	public Deck() {
		deck = new LinkedList<Card>();
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Rank rank : Card.Rank.values()) {
				getDeckCards().add(new Card(rank, suit));
			}
		}
		shuffleDeck();
	}
	
	public void shuffleDeck() 
	{
		Collections.shuffle(deck);
	}
	
	// The Flop contains the first tree Cards on the play
	public List<Card> getDeckCards() 
	{
		return deck;
	}
	
	public int getDeckSize() 
	{
		return deck.size();
	}
	
	
	/* delete one Card from Deck and return this */
	public Card deal()
	{
		return deck.remove(0);
	}
}