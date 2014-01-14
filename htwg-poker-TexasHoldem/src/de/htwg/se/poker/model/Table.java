package de.htwg.se.poker.model;

import java.util.List;

public class Table {
/*
 * Konstruktor: Anzahl der Spieler
 * 
 * Liste mit den Spielern
 * 
 * Das Deck mit unbenutzten karten
 * 
 * 
 * 
 * */
	public Table(List<Player> inPlayers)
	{
		setPlayers(inPlayers);
		for(int i = 0;i<5;i++)
			middleCards[i] = null;
		setMyDeck(new Deck()); 
	}

	public Deck getMyDeck() {
		return myDeck;
	}
	public void setMyDeck(Deck myDeck) {
		this.myDeck = myDeck;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Card[] getMiddleCards() {
		return middleCards;
	}

	public void setMiddleCards(Card[] middleCards) {
		this.middleCards = middleCards;
	}

	private Deck myDeck;
	private Card[] middleCards = new Card[5];
	private List<Player> players;
	
}
