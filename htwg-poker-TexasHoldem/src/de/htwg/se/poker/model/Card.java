package de.htwg.se.poker.model;

public class Card {
	
	private final Suit SUIT;
	private final Rank RANK;
	
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
		this.RANK = rank;
		this.SUIT = suit;
	}
	
	public Rank getRank()
	{
		return RANK;
	}
	
	public Suit getSuit()
	{
		return SUIT;
	}
	
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder (SUIT + " " + RANK);
		for (@SuppressWarnings("unused") int i = 0; s.length() < 13; i++)
		{
			s.append(" ");
		}
		return s.toString();
	}
}
