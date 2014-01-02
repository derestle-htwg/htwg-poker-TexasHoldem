package de.htwg.se.poker.model;

public class DealButton {

	static int limit=2;
	static int smallBlind=0;
	static int bigBlind=0;
	
	DealButton() {
		limit = 2;
		smallBlind = 0;
		bigBlind = 0;
	}
	
	public static void setSmallBlind() {
		smallBlind = limit/2;
	}
	
	public void setBigBlind() {
		bigBlind = limit;
	}
	
	public int getSmallBlind() {
		setSmallBlind();
		return smallBlind;
	}
	
	public int getBigBlind() {
		setBigBlind();
		return bigBlind;
	}
}
