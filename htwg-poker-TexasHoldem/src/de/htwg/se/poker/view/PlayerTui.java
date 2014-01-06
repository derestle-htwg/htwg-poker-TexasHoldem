package de.htwg.se.poker.view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;
import de.htwg.se.poker.model.*;

public class PlayerTui implements PlayerInterface{
	
	TuiHelper tuiHelper;
	
	public PlayerTui()
	{
		this(System.in,System.out);
	}
	
	public PlayerTui(InputStream inStr, PrintStream outStr)
	{
		tuiHelper = new TuiHelper(inStr, outStr);
	}

	
	/**
	 * show Table zeigt den aktuellen Tisch an. Wenn der Player null ist wird der gesammte Tisch angezeigt.
	 * Wenn ein Player übergeben wird, wird der Tisch aus seiner Sicht angezeigt.
	 * */
	public void showTable(Table inTable, Player inPlayer)
	{
		
	}


	private List<Player> getNewPlayers()
	{
		List<Player> players = new LinkedList<Player>();
		
		do
		{
			Player tmpPly = new Player("",0.0);
			dataOutput.println("Name des " + (players.size()+1) + ". Spielers: ");
			
			tmpPly.setName(readLine());
			players.add(tmpPly);
			

			dataOutput.println("\nZus�tzlichen Spieler? [j/n]");
			
		} 
		while(readLine().equalsIgnoreCase("j"));
		
		return players;
	}
	
	

	public void updateTable(Table inTable) {
		// TODO Auto-generated method stub
		
	}

	public SimpleEntry<action, Integer> getPlayerAction() {
		// frage den Spieler, welche Aktion er machen will.
		return null;
	}
}
