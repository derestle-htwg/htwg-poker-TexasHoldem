package de.htwg.se.poker.model;

import java.util.Comparator;

public class Card {
	
	public static class RankComperator implements Comparator<Card>
	{
		@Override
		public int compare(Card o1, Card o2) {
			if(o1.getRank().ordinal()>o2.getRank().ordinal()){
				return 1;
			}
			if(o1.getRank().ordinal()==o2.getRank().ordinal()){
				return 0;
			}
			return -1;
		}
	}
	
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
