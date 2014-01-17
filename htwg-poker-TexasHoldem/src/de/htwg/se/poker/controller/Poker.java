package de.htwg.se.poker.controller;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.poker.model.*;
import de.htwg.se.poker.model.Card.Rank;
import de.htwg.se.poker.model.Card.Suit;
import de.htwg.se.poker.view.PlayerInterface;
import de.htwg.se.poker.view.PlayerTui;
import de.htwg.se.poker.view.netTui;

public class Poker {
	
	static int MIN_PLAYERS = 2;
	static int MAX_PLAYERS = 8;
	static double STARTCAPITAL = 100.0;
	/*Was wird für ein Spiel benötigt?
	 * Anzahl Spieler
	 * Interfaces d. Spieler
	 * */
	
	public static void main(String[] args) 
	{
		List<Class<? extends PlayerInterface>> interfaces = getAllInterfaces();
		List<Player> Players = new LinkedList<Player>();
		
		
		int PlayerCount = askPlayerCount();
		
		for(int i = 0; i<PlayerCount;i++)
		{
			PlayerInterface pi = askPlayerInterface(interfaces,i+1);
			
			Player p = new Player(STARTCAPITAL,pi);
			Players.add(p);
		}
		GameMaster myGame = new GameMaster(Players);
		
		
	}
	
	private static PlayerInterface askPlayerInterface(List<Class<? extends PlayerInterface>> myInterfaces, int PlayerNo)
	{
		System.out.println("Was für ein Interface benutzt Spieler " + PlayerNo + "?");
		
		HashMap<Integer, Class<? extends PlayerInterface>> Choices = new HashMap<Integer, Class<? extends PlayerInterface>>(); 
		
		int i = 0;
		for(Class<? extends PlayerInterface> c : myInterfaces)
		{
			i++;
			System.out.println("[" + i + "] " + c.getSimpleName());
			Choices.put(i, c);
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int InterfaceNr = 0;
		while(InterfaceNr < 1 || InterfaceNr > i)
		{
			String text = null;
			try {
				text = br.readLine();
				InterfaceNr = Integer.parseInt(text);
			} catch (NumberFormatException e) {
				System.out.println("\"" + text + "\"ist kein gültiges Interface!");
			} catch (IOException e) {
				System.out.println("Fehler bei der Eingabe,");			
			}
		}
		PlayerInterface retVal = null;
		
		try {
			retVal = Choices.get(InterfaceNr).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return retVal;
	}

	private static int askPlayerCount() {
		System.out.println("Anzhal der Spieler:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Players = 0;
		while(Players < MIN_PLAYERS || Players > MAX_PLAYERS)
		{
			String text = "";
			try {
				text = br.readLine();
				Players = Integer.parseInt(text);
			} catch (NumberFormatException e) {
				System.out.println("\"" + text + "\"ist keine gültige Anzahl spieler!");
				System.out.println("Es müssen mindestens " + MIN_PLAYERS + " und dürfen höchstens " + MAX_PLAYERS + " Spieler teilnehmen.");
			} catch (IOException e) {
				System.out.println("Fehler bei der Eingabe,");			
			}
		}
		return Players;
	}
	
	private static List<Class<? extends PlayerInterface>> getAllInterfaces()
	{
		LinkedList<Class<? extends PlayerInterface>> myInterfaces = new LinkedList<Class<? extends PlayerInterface>>();
		myInterfaces.add(PlayerTui.class);
		myInterfaces.add(netTui.class);
		return myInterfaces;
	}
		
}
