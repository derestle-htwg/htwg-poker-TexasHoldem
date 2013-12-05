package de.htwg.se.poker.model;

public class Player {
	/* Eigenschaften eines einzelnen Spielers*/
	public String name;
	private String namePlayer;
	private double playerInitCapital;
	Table playerTable;
		
	/* Hier hat der Spieler die Möglichkeit Sein Guthaben zu erhöhen,
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
		System.out.printf("Ihr aktuellen ChipStand beträgt: %d €\n\n", capital);
	}
}
