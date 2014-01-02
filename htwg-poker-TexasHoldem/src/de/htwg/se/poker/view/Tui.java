package de.htwg.se.poker.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.poker.model.*;

public class Tui implements GameInterface{
	
	private InputStream dataInput;
	private PrintStream dataOutput;
	
	private BufferedReader br;
	
	public Tui()
	{
		this(System.in,System.out);
	}
	
	public Tui(InputStream inStr, PrintStream outStr)
	{
		dataInput = inStr;
		dataOutput = outStr;
		br = new BufferedReader(new InputStreamReader(dataInput));
	}

	public List<Player> getNewPlayers()
	{
		List<Player> players = new LinkedList<Player>();
		
		do
		{
			Player tmpPly = new Player();
			dataOutput.println("Name des " + (players.size()+1) + ". Spielers: ");
			
			tmpPly.setName(readLine());
			players.add(tmpPly);
			
			dataOutput.println("\nZusätzlichen Spieler? [j/n]");
			
		} 
		while(readLine().equalsIgnoreCase("j"));
		
		return players;
	}
	
	public int readInt()
	{
		return Integer.parseInt(readLine());
	}
	
	public String readLine()
	{
		try {
			return br.readLine();
		} catch (IOException ioe) {
		System.out.println("IO error!");
		System.exit(1);}
		return null;
	}
}
