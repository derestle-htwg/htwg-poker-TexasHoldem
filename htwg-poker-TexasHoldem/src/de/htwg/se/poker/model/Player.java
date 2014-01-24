package de.htwg.se.poker.model;

import java.util.LinkedList;
import java.util.List;

import de.htwg.se.poker.view.PlayerInterface;

public class Player {
	
	private String name;
	private double playerCapital;
	private List<Card> cards;
	private PlayerInterface pi;
	
	public Player(double inPlayerInitCapital, PlayerInterface inPi)
	{
		playerCapital = inPlayerInitCapital;
		pi = inPi;
		cards = new LinkedList<Card>();
	}
	
	public PlayerInterface getPlayersInterface()
	{
		return pi;
	}
	
	public double getPlayerCapital()
	{
		return playerCapital;
	}
	
	public void addPlayerCapital(double money)
	{
		playerCapital += money;
	}
	
	public void subPlayerCapital(double money)
	{
		playerCapital -= money;
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
