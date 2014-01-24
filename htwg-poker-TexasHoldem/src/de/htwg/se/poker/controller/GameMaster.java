package de.htwg.se.poker.controller;

import java.util.HashMap;
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
	double smallBlind = 5.0;
	double bigBlind = 10.0;


	public GameMaster(List<Player> inPlayers){
		myTable = new Table(inPlayers);
	}

	private void bet()
	{
		int playersNotRaisCount = 0;
		int actualPos = myTable.getDealerPos()+1;
		actualPos = actualPos%myTable.getPlayers().size();
		double actualBet = 0;
		int PlayersInGame = (myTable.getPlayers().size() - myTable.getPlayersOut().size());
		while( (PlayersInGame > playersNotRaisCount) && (PlayersInGame > 1))
		{
			for(Player p :myTable.getPlayers())
			{
				if(!myTable.getPlayersOut().contains(p) && !myTable.PlayerIsAllIn(p)){
					if(myTable.getPot(p) > actualBet)
						actualBet = myTable.getPot(p); 
				}
			}

			myTable.notifyObservers();
			double moneyToReachPot = 0.0;
			Player p = myTable.getPlayers().get(actualPos);
			moneyToReachPot = actualBet - myTable.getPot(p);

			action PlayerAction = askPlayerAction(moneyToReachPot, p);

			if(doPlayerAction(moneyToReachPot, p, PlayerAction))
				playersNotRaisCount = 0;
			else
				playersNotRaisCount++;

			actualPos++;
			actualPos = actualPos%myTable.getPlayers().size();
			PlayersInGame = (myTable.getPlayers().size() - myTable.getPlayersOut().size());
			System.out.println("pnrc" + playersNotRaisCount + " " + PlayersInGame);
		}

	}

	/**
	 * return wert sagt ob der Spieler erhöht hat
	 * */
	private boolean doPlayerAction(double moneyToReachPot, Player p, action PlayerAction) {
		if(PlayerAction == action.quitGame)
		{
			quitPlayer(p);	
		}
		else if(PlayerAction == action.fold)
		{
			myTable.getPlayersOut().add(p);
			for(Player p2 : myTable.getPlayers())
				p2.getPlayersInterface().sendInfo("Der Spieler " + p.getName() + " steigt aus.");
		}
		else if(PlayerAction == action.call){
			for(Player p2 : myTable.getPlayers())
				p2.getPlayersInterface().sendInfo("Der Spieler " + p.getName() + " geht mit.");
			myTable.addPot(p, moneyToReachPot);
			p.subPlayerCapital(moneyToReachPot);
		}
		else if(PlayerAction == action.raise){
			int value = 0;
			while(value <= 0 && (moneyToReachPot + value) <= p.getPlayerCapital())
			{
				value = (int)p.getPlayersInterface().getActionValue();
				if(value < moneyToReachPot){
					p.getPlayersInterface().sendInfo("Fehler, der wert muss größer als 0 sein!");
				}
				else if((moneyToReachPot + value) > p.getPlayerCapital()){
					p.getPlayersInterface().sendInfo("Fehler, eigenes Kapital wurde überschritten!");
				}
			}

			for(Player p2 : myTable.getPlayers())
				p2.getPlayersInterface().sendInfo("Der Spieler " + p.getName() + " erhöht um " +value);
			p.subPlayerCapital(moneyToReachPot+value);
			myTable.addPot(p, moneyToReachPot+value);
			return true;
		}else if(PlayerAction == action.allIn){
			for(Player p2 : myTable.getPlayers())
				p2.getPlayersInterface().sendInfo("Der Spieler " + p.getName() + " geht all in.");
			myTable.addPot(p, p.getPlayerCapital());
			p.subPlayerCapital(p.getPlayerCapital());
			myTable.setPlayerAllIn(p);
			return true;
		}
		return false;
	}

	private action askPlayerAction(double moneyToReachPot, Player p) {
		List<action> possibleActions = new LinkedList<action>();


		possibleActions.add(action.fold);
		possibleActions.add(action.quitGame);
		possibleActions.add(action.allIn);
		if(moneyToReachPot < p.getPlayerCapital()){
			possibleActions.add(action.raise);
		}
		if(moneyToReachPot <= p.getPlayerCapital()){
			possibleActions.add(action.call);
		}

		action PlayerAction = p.getPlayersInterface().getPlayerAction(possibleActions,moneyToReachPot);
		return PlayerAction;
	}

	private void quitPlayer(Player p)
	{
		myTable.getPlayers().remove(p);
		if(myTable.getPlayers().indexOf(p) < myTable.getDealerPos())
			myTable.setDealerPos(myTable.getDealerPos()-1);
		sendPlayerInfoMessages("Der Spieler " + p.getName() + " hat das Spiel verlassen");
	}

	public void StartGame(){

		while(myTable.getPlayers().size() > 1)
		{//Spiele solange es Spieler gibt
			//Tisch herstellen
			resetTableforNextRound();
			//Blinds holen
			getBlind(myTable.getPlayers().get((myTable.getDealerPos()+1)%myTable.getPlayers().size()),smallBlind);
			getBlind(myTable.getPlayers().get((myTable.getDealerPos()+2)%myTable.getPlayers().size()),bigBlind);

			roundOne();
			roundTwo();
			roundThree();
		}
	}

	private void getBlind(Player p, double Blind)
	{
		List<action> possibleActions = new LinkedList<action>();

		if(p.getPlayerCapital() < Blind){
			p.getPlayersInterface().sendInfo("Nicht genug Geld für den Blind, du bist raus!");
			quitPlayer(p);
		}
		else{
			p.getPlayersInterface().sendInfo("Sie müssen den Blind(" + Blind + ") setzen oder aus dem Spiel aussteigen.");
			possibleActions.add(action.call);
			possibleActions.add(action.quitGame);
			action PlayerAction = p.getPlayersInterface().getPlayerAction(possibleActions,Blind);

			if(PlayerAction == action.quitGame){
				quitPlayer(p);
			}
			else{//set Blind
				myTable.setPot(p, Blind);
				p.subPlayerCapital(Blind);
			}
		}
	}

	private void resetTableforNextRound()
	{
		myTable.resetForNextRound();
	}

	private void roundOne(){
		for(Player p :myTable.getPlayers())
		{
			List<Card> PlayerCards = new LinkedList<Card>();
			PlayerCards.add(myTable.getMyDeck().deal());
			PlayerCards.add(myTable.getMyDeck().deal());
			p.setCards(PlayerCards);
		}
		bet();
		myTable.setMiddleCards(0,myTable.getMyDeck().deal());
		myTable.setMiddleCards(1,myTable.getMyDeck().deal());
		myTable.setMiddleCards(2,myTable.getMyDeck().deal());
	}

	private void roundTwo(){
		bet();
		myTable.setMiddleCards(3,myTable.getMyDeck().deal());
		myTable.notifyObservers();
	}

	private void roundThree()
	{
		bet();
		myTable.setMiddleCards(4,myTable.getMyDeck().deal());
		myTable.notifyObservers();
		//showdown
		for(HashMap<Player, Double> pot : myTable.getAllPots()){
			List<Player> potPlayers = new LinkedList<Player>();
			for(Player p : pot.keySet()){
				if(!myTable.getPlayersOut().contains(p) && myTable.getPlayers().contains(p)){
					potPlayers.add(p);
				}
			}

			List<Player> winners = patternRecognation.ComparePlayers(potPlayers,myTable.getAllMiddleCards());

			double totalPot = 0.0;
			for(Player p : potPlayers){
				totalPot += pot.get(p);
			}

			for(Player p : winners)
			{
				sendPlayerInfoMessages("Spieler " + p.getName() + " bekommt " + totalPot/((double)winners.size()));
				p.addPlayerCapital(totalPot/((double)winners.size()));
			}
		}
	}

	private void sendPlayerInfoMessages(String infomsg){
		for(Player p2 : myTable.getPlayers())
			p2.getPlayersInterface().sendInfo(infomsg);
	}


}
