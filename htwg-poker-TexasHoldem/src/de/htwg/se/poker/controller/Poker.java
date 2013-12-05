package de.htwg.se.poker.controller;


import de.htwg.se.poker.model.*;

public class Poker {
		
	public static void main(String[] args) {
		
		Table table = new Table();
		//table.fillTable();
		//System.out.println(table.getDeckOfKonsole());
		//table.getDeckSize();
		//table.setPlayerOfKonsole();
		
		table.setFlop();
		table.setTurn();
		table.setRiver();
		
		System.out.println(table.getMiddleCards());
		
		System.out.println(table.getFlop());
		System.out.println(table.flopCard1);
		System.out.println(table.flopCard2);
		System.out.println(table.flopCard3);
		
		
		System.out.println(table.getMiddleCards());
	
		System.out.println(table.turnCard);
		System.out.println(table.getMiddleCards());
		table.setRiver();
		System.out.println(table.getMiddleCards());
		System.out.println(table.riverCard);
		System.out.println(table.getFlop());
		table.setTurn();
		table.setFlop();
		
	}
}
