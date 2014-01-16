package de.htwg.se.poker.model;

import java.util.List;

import de.htwg.se.poker.view.PlayerInterface;

public class Player {
	
	private String name;
	private double playerCapital;
	private List<Card> cards;
	private PlayerInterface pi;
	
	public Player(double inPlayerInitCapital, PlayerInterface inPi)
	{
		name = inPi.getPlayerName();
		playerCapital = inPlayerInitCapital;
		pi = inPi;
	}
	
	public PlayerInterface getPlayersInterface()
	{
		return pi;
	}
	
	public double getPlayerCapital()
	{
		return playerCapital;
	}
	
	public void setPlayerInitCapital(double capital)
	{
		playerCapital = capital;
	}
	

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	
	public List<Card> getCards() {
		return cards;
	}

	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
}
