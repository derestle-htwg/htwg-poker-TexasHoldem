package de.htwg.se.poker.controller;

import de.htwg.se.poker.model.*;

public class Poker {
		
	public static void main(String[] args) 
	{
		Table table = new Table();
		
		table.tableElem.cardsElements.setMiddleCards();
		
		int round = 0;
		round++;
		
		table.setTableComponents(round);
	}
		
}
