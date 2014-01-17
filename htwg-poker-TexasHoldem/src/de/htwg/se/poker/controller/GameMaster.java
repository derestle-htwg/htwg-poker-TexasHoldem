package de.htwg.se.poker.controller;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.poker.model.Card;
import de.htwg.se.poker.model.Player;
import de.htwg.se.poker.model.Table;
import de.htwg.se.poker.view.PlayerInterface.action;

/*
 * Der Gamemaster Steuert das Spiel.
 * 	er verteilt Karten,
 * 	er beachtet die Regeln
 * 	er Fragt die Mitglieder nach ihren Zügen
 * */
public class GameMaster {
	
	Table myTable;
	List<Player> playersOut;
	
	public GameMaster(List<Player> inPlayers){
		myTable = new Table(inPlayers);
	}
	
	private void bet()
	{
		int lastBetPos = myTable.getDealerPos();
		int actualPos = lastBetPos;
		do
		{
			myTable.notifyObservers();
			Player p = myTable.getPlayers().get(actualPos);
			List<action> possibleActions = new LinkedList<action>();
			possibleActions.add(action.call);
			possibleActions.add(action.fold);
			possibleActions.add(action.raise);
			possibleActions.add(action.quitGame);
			
			action PlayerAction = p.getPlayersInterface().getPlayerAction(possibleActions,10.0);
			
			if(PlayerAction == action.quitGame)
			{
				myTable.getPlayers().remove(p);
				
			}
			
			actualPos++;
			actualPos = actualPos%myTable.getPlayers().size();
		}
		while(actualPos != lastBetPos);
	}
	
	public void StartGame(){
			
		while(myTable.getPlayers().size() > 1)
		{
			resetTableforNextRound();
			roundOne();
			roundTwo();
			roundThree();
		}
	}
	
	private void resetTableforNextRound()
	{
		playersOut = new LinkedList<Player>();
		myTable.resetForNextRound();
	}
	
	private void roundOne(){
		myTable.getMiddleCards()[0] = myTable.getMyDeck().deal();
		myTable.getMiddleCards()[1] = myTable.getMyDeck().deal();
		myTable.getMiddleCards()[2] = myTable.getMyDeck().deal();
		for(Player p :myTable.getPlayers())
		{
			List<Card> PlayerCards = new LinkedList<Card>();
			PlayerCards.add(myTable.getMyDeck().deal());
			PlayerCards.add(myTable.getMyDeck().deal());
			p.setCards(PlayerCards);
		}
		bet();
	}
	
	private void roundTwo(){
		myTable.getMiddleCards()[3] = myTable.getMyDeck().deal();
		myTable.notifyObservers();
	}
		
	private void roundThree()
	{
		myTable.getMiddleCards()[4] = myTable.getMyDeck().deal();
		myTable.notifyObservers();
		//showdown
		
	}
	

}
