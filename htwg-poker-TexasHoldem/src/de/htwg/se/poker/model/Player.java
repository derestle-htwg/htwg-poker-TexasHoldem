package de.htwg.se.poker.model;

public class Player {
	/* Eigenschaften eines einzelnen Spielers*/
	public String name;
	private String namePlayer;
	private double playerInitCapital;
	Table playerTable;
		
	/* Hier hat der Spieler die M�glichkeit Sein Guthaben zu erh�hen,
	 * falls er kein Geld mehr hat */
	
	
	public String getPlayerName() {
		namePlayer = "robert";
		return namePlayer;
	}
	
	public Double getPlayerInitCapital() {
		playerInitCapital = 500.00;
		return playerInitCapital;
	}
	
	public void setPlayerInitCapital(double capital) {
		System.out.printf("Ihr aktuellen ChipStand betr�gt: %d �\n\n", capital);
	}
}
