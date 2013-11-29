package de.htwg.se.poker.controller;

import de.htwg.se.poker.model.Cards;

public class Player {
	/* Eigenschaften eines einzelnen Spielers*/
	public String name;
	final double CAPITAL = 400.00;
	
	/* reserviert Variable für die HoldCards, die er später vom GameMaster bekommt */
	public Cards playerHoldCards;
	
	/* Für das auswerten in patternRecognation, wenn das Spiel zu Ende ist*/
	public Cards playerBlat;
	
	double initCapital;
	
	/* Hier hat der Spieler die Möglichkeit Sein Guthaben zu erhöhen,
	 * falls er kein Geld mehr hat */
	public void increaseCapital() {
		
	}
}
