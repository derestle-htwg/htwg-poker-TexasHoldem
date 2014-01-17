package de.htwg.se.poker.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Table extends Observable{
/*
 * Konstruktor: Anzahl der Spieler
 * 
 * Liste mit den Spielern
 * 
 * Das Deck mit unbenutzten karten
 * 
 * */
	
	public Table(List<Player> inPlayers)
	{
		middleCards = new Card[5];
		this.players = inPlayers;
		
		for(Player p : players)
		{
			addObserver(p.getPlayersInterface());
		}
	}
	
	public Deck getMyDeck() {
		return myDeck;
	}
	
	public void setMyDeck(Deck myDeck) {
		this.myDeck = myDeck;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Card[] getMiddleCards() {
		return middleCards;
	}

	public void setMiddleCards(Card[] middleCards) {
		this.middleCards = middleCards;
	}
	
	/**
	 * @return the dealer
	 */
	public int getDealerPos() {
		return dealerPos;
	}

	/**
	 * @param dealer the dealer to set
	 */
	public void setDealerPos(int dealerPos) {
		this.dealerPos = dealerPos;
	}
	
	public void notifyObservers()
	{
		setChanged();
		super.notifyObservers();
	}
	
	public double getPot()
	{
		return pot;
	}
	
	public void setPot(double inPot)
	{
		pot = inPot;
	}
	
	public double getPlayersPot(Player inPlayer)
	{
		return playerPot.get(inPlayer);
	}
	
	public void setPlayersPot(Player inPlayer, double Value)
	{
		playerPot.put(inPlayer, Value);
	}
	
	public void resetForNextRound() {
		
		for(int i = 0;i<5;i++)
			middleCards[i] = null;
		
		setMyDeck(new Deck()); 
		dealerPos = (dealerPos+1)%players.size();
		
		playerPot = new HashMap<Player, Double>();
		
		for(Player p : players)
		{
			setPlayersPot(p, 0.0);
		}
		
	}

	private Deck myDeck;
	private Card[] middleCards;
	private List<Player> players;
	private int dealerPos;
	private double pot;
	private Map<Player,Double> playerPot;
	
	
}
