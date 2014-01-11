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
		players = inPlayers;
		myDeck = new Deck();
	}

	private Deck myDeck;
	private Card[] middleCards = new Card[5];
	private List<Player> players;
	
}
