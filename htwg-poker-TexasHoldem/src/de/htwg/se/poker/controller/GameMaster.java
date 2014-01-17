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
				if(actualPos < myTable.getDealerPos())
					myTable.setDealerPos(myTable.getDealerPos()-1);
				for(Player p2 : myTable.getPlayers())
					p2.getPlayersInterface().sendInfo("Der Spieler " + p.getName() + " hat das Spiel verlassen");
			}
			else if(PlayerAction == action.fold)
			{
				myTable.getPlayersOut().add(p);
			}
			else if(PlayerAction == action.call){}
			else if(PlayerAction == action.raise){}
			
			actualPos++;
			actualPos = actualPos%myTable.getPlayers().size();
		}
		while(actualPos != lastBetPos && (myTable.getPlayers().size() - myTable.getPlayersOut().size()) > 1);
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
		myTable.setPlayersOut(new LinkedList<Player>());
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
