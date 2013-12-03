package de.htwg.se.poker.controller;

import java.util.ArrayList;
import java.util.List;

import de.htwg.se.poker.model.*;

public class Poker {
	static Cards river;
	static Cards turn;
	static List<Cards> middleCard;
	static Deck play;
	static int cardNbr;
	static DealButton dealB;
	static int bigB;
	static int smallB;
	
	
	
	public static void main(String[] args) {
		middleCard = new ArrayList<Cards>(5);
		play = new Deck();
		System.out.println("Ist leer\n" + middleCard);
		System.out.println(play.getCard());
				
		middleCard = play.getFlop();
		System.out.println(middleCard);
		river=play.deal();
		turn=play.deal();
		middleCard.add(river);
		System.out.println(middleCard);
		middleCard.add(turn);
		cardNbr=middleCard.size();
		System.out.println(cardNbr);
		System.out.println(middleCard);
		System.out.println("\n"+ play.getCard());
		System.out.println(play.getCard().size());
		bigB=dealB.getBigBlind();
		System.out.println("big blind: " + bigB );
		System.out.println("small blind: " + dealB.getSmallBlind());
		
		
		
	}

}
