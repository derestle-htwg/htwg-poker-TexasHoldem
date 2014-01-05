package de.htwg.se.poker.model;

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
	public Table()
	{
		for(int i = 0;i<5;i++)
			middleCards[i] = null;
	}

	private Card[] middleCards = new Card[5];
	
}
