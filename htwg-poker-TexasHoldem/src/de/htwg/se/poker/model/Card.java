package de.htwg.se.poker.model;

public class Card {
	
	private Suit suit;
	private Rank rank;
	
	public enum Suit
	{
		SPADE,
		DIAMOND,
		HEART,
		CLUB
	}
	
	public enum Rank
	{
		TWO, THREE, FOUR, 
		FIVE, SIX, SEVEN,
		EIGHT, NINE, TEN,
		JACK, QUEEN, KING,
		ACE
	}
	
	public Card(Rank rank, Suit suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	public Rank getRank()
	{
		return rank;
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	@Override
	public String toString()
	{
		return String.format("%13s", suit + " " + rank);
	}
}
