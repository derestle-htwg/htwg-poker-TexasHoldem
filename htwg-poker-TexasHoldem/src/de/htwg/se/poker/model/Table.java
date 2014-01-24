package de.htwg.se.poker.model;

import java.util.HashMap;
import java.util.LinkedList;
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
		pots = new LinkedList<HashMap<Player,Double>>();
		pots.add(new HashMap<Player,Double>());
		dealerPos = 0;
		playersOut = new LinkedList<Player>();
		playersAllIn = new LinkedList<Player>();

		for(Player p : players)
		{
			addObserver(p.getPlayersInterface());
			actualPot().put(p, 0.0);
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

	public Card getMiddleCard(int i) {
		return middleCards[i];
	}

	public void setMiddleCards(int i,Card inCard) {
		this.middleCards[i] = inCard;
	}

	public double getPot(Player p)
	{
		return actualPot().get(p);
	}

	public void setPot(Player p, double inPot)
	{
		actualPot().put(p,inPot);
	}
	
	public void addPot(Player p, double inPot){
		actualPot().put(p,actualPot().get(p)+inPot);
	}

	public void resetForNextRound() {

		for(int i = 0;i<5;i++)
			middleCards[i] = null;

		setMyDeck(new Deck()); 
		dealerPos = (dealerPos+1)%players.size();

		playersAllIn = new LinkedList<Player>();

		pots.clear();
		pots.add(new HashMap<Player, Double>());
		
		for(Player p : players)
		{
			setPot(p, 0.0);
		}
	}

	public List<Player> getPlayersOut() {
		return playersOut;
	}

	public void setPlayersOut(List<Player> playersOut) {
		this.playersOut = playersOut;
		notifyObservers();
	}

	public int getDealerPos() {
		return dealerPos;
	}

	public void setDealerPos(int dealerPos) {
		this.dealerPos = dealerPos;
	}

	public void notifyObservers()
	{
		setChanged();
		super.notifyObservers();
	}

	public void setPlayerAllIn(Player p){
		if(!PlayerIsAllIn(p))
			playersAllIn.add(p);
		
		pots.add(new HashMap<Player, Double>());
		for(Player p1 :players){
			if(!PlayerIsAllIn(p1) && !playersOut.contains(p1)){
				actualPot().put(p1, 0.0);
			}
		}
	}

	public boolean PlayerIsAllIn(Player p){
		return playersAllIn.contains(p);
	}

	public List<Card> getAllMiddleCards() {
		List<Card> retVal = new LinkedList<Card>();
		for(Card c : middleCards){
			if(c != null){
				retVal.add(c);
			}
		}
		return retVal;
	}
	
	public double getTotalPot() {
		double totalPot = 0.0;
		for(Double v : actualPot().values()){
			totalPot += v;
		}
		return totalPot;
	}
	
	private Map<Player,Double> actualPot(){
		return pots.get(pots.size()-1);
	}
	
	public List<HashMap<Player,Double>> getAllPots(){
		return pots;
	}

	private Deck myDeck;
	private Card[] middleCards;
	private List<Player> players;
	private int dealerPos;
	private List<Player> playersOut;
	private List<Player> playersAllIn;
	private List<HashMap<Player,Double>> pots;
	

}
