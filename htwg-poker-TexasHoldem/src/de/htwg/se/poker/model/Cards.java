package de.htwg.se.poker.model;

/* One Card consists of: Suit + Rank 
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

public class Cards
{
	
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
	
	public Cards(Rank rank, Suit suit)
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
	
	public String toString()
	{
		return " " + SUIT + " " + RANK + "\n";
	}
}
