package de.htwg.se.poker.model;

import java.util.ArrayList;
import java.util.List;

public class Table {
/*
 * Konstruktor: Anzahl der Spieler
 * 
 * Liste mit den Spielern
 * 
 * Places reservation for:
 *   Flop: die erste Drei Karten
 *	 River: die vierte Karte
 *   Turn: die fünfte Karte
 *   Players
 *   DealButton (BigBlind and SmallBlind)
 * 
 * */
	int roundNbr;
	int flopSize = 3;
	List<Deck> middleCards;
	List<Deck> flop;
	Deck River;
	Deck Turn;
	
	// Konstruktor
	public Table(int rn)
	{
		middleCards = new ArrayList<Deck>(5);
		flop = new ArrayList<Deck>(flopSize);
		//flop.
		this.roundNbr = rn;
		if (rn == 1)
		{
			//for(int i = 0; i < 3; i++)
		//		middleCards[i] = ;
		}
		
	}
	
}
