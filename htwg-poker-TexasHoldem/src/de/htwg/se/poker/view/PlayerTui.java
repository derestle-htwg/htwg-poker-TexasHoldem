package de.htwg.se.poker.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.poker.model.*;

public class PlayerTui implements PlayerInterface{
	
	public static String InterfaceName = "TextUserInterface";
	
	private InputStream dataInput;
	private PrintStream dataOutput;
	
	tuiHelper myTuiHelper;
	
	public PlayerTui()
	{
		this(System.in,System.out);
	}
	
	public PlayerTui(InputStream inStr, PrintStream outStr)
	{
		myTuiHelper = new tuiHelper(inStr, outStr);
	}
	
	public PlayerTui(InputStream inStr, OutputStream outStr)
	{
		this(inStr,new PrintStream(outStr));
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
			
			tmpPly.setName(myTuiHelper.readLine());
			players.add(tmpPly);
			

			dataOutput.println("\nZus�tzlichen Spieler? [j/n]");
			
		} 
		while(myTuiHelper.readLine().equalsIgnoreCase("j"));
		
		return players;
	}
	
	

	public void updateTable(Table inTable) {
		// TODO Auto-generated method stub
		
	}

	public SimpleEntry<action, Integer> getPlayerAction() {
		// frage den Spieler, welche Aktion er machen will.
		return null;
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayer(Player inPlayer) {
		// TODO Auto-generated method stub
		
	}
	
	public String getPlayerName() {
		System.out.println("Geben sie ihren Namen ein:");
		return myTuiHelper.readLine();
	}
}
