package de.htwg.se.poker.model;

public class Player {
	
	private String name;
	private double playerInitCapital;
	
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
}
