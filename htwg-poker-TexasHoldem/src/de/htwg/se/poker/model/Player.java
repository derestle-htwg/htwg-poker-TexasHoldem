package de.htwg.se.poker.model;

public class Player {
	
	private String name;
	private String namePlayer;
	private double playerInitCapital;
		
	public String getPlayerName() 
	{
		namePlayer = "robert";
		return namePlayer;
	}
	
	public Double getPlayerInitCapital()
	{
		playerInitCapital = 500.00;
		return playerInitCapital;
	}
	
	public void setPlayerInitCapital(double capital)
	{
		System.out.printf("Ihr aktuellen ChipStand beträgt: %d €\n\n", capital);
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
