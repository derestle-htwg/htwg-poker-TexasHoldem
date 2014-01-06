package de.htwg.se.poker.model;

import java.util.List;

public class Player {
	
	private String name;
	private double playerInitCapital;
	private List<Card> cards;
	
	public Player(String inName, double inPlayerInitCapital)
	{
		name = inName;
		playerInitCapital = inPlayerInitCapital;
	}
	
	public double getPlayerInitCapital()
	{
		return playerInitCapital;
	}
	
	public void setPlayerInitCapital(double capital)
	{
		System.out.printf("Ihr aktuellen ChipStand betr�gt: %d �\n\n", capital);
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
