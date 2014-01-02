package de.htwg.se.poker.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardsElements {
	private List<Card> deck;
	
	private Card flopCard;
	private List<Card> flopList;
	
	private Card turnCard;
	private Card riverCard;
	
	private List<Card> middleCards;
	
	public CardsElements() {
		deck = new LinkedList<Card>();
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Rank rank : Card.Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		
		flopList = new LinkedList<Card>();
		middleCards = new LinkedList<Card>();
	}
	
	public int getDeckSize()
	{
		return deck.size();
	}
	
	private void shuffleDeck()
	{
		Collections.shuffle(deck);
	}
	
	public List<Card> getDeck()
	{
		return deck;
	}
	
	/* return the top card from the deck
	 * the deck has one less card*/
	public Card getCard()
	{
		shuffleDeck();
		return deck.remove(0);
	}
	
	private void setFlop()
	{
		if (flopList.isEmpty())
		{
			for (int i = 0; i < 3; i++)
			{
				flopCard = getCard();
				flopList.add(flopCard);
			}
		}
		else
		{
			System.out.println("flop already exits!");
		}
	}
	
	public List<Card> getFlop()
	{
		if (flopList.isEmpty())
		{
			setFlop();
		}
			
		return flopList;
	}
	
	private void setTurn()
	{
		turnCard = getCard();
	}
	

	public Card getTurn()
	{
		return turnCard;
	}
	
	
	private void setRiver()
	{
		riverCard = getCard();
	}

	
	public Card getRiver()
	{
		return riverCard;
	}
	
	public void setMiddleCards()
	{
		setFlop();
		setTurn();
		setRiver();
		
		if (middleCards.isEmpty())
		{
			for (Iterator<Card> i = flopList.iterator(); i.hasNext();)
			{
				middleCards.add(i.next());
			}
			middleCards.add(getTurn());
			middleCards.add(getRiver());
		}
		else
		{
			System.out.println("MiddleCard is already full!!");
		}
	}
	
	public List<Card> getMiddleCards() {
		
		if (middleCards.isEmpty())
		{
			System.out.println("MiddleCard is empty!");
			return null;
		}

		return middleCards;
	}
}
