package de.htwg.se.poker.controller;

import de.htwg.se.poker.model.Cards;

public class Player {
	/* Eigenschaften eines einzelnen Spielers*/
	public String name;
	final double CAPITAL = 400.00;
	
	/* reserviert Variable f�r die HoldCards, die er sp�ter vom GameMaster bekommt */
	public Cards playerHoldCards;
	
	/* F�r das auswerten in patternRecognation, wenn das Spiel zu Ende ist*/
	public Cards playerBlat;
	
	double initCapital;
	
	/* Hier hat der Spieler die M�glichkeit Sein Guthaben zu erh�hen,
	 * falls er kein Geld mehr hat */
	public void increaseCapital() {
		
	}
}
