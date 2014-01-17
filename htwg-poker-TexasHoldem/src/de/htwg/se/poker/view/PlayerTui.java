package de.htwg.se.poker.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.AbstractMap.SimpleEntry;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import de.htwg.se.poker.model.*;

public class PlayerTui implements PlayerInterface{
	
	public static String InterfaceName = "TextUserInterface";
	
	private InputStream dataInput;
	private PrintStream dataOutput;
	
	tuiHelper myTuiHelper;
	Player me;
	
	public PlayerTui()
	{
		this(System.in,System.out);
	}
	
	public PlayerTui(InputStream inStr, PrintStream outStr)
	{
		myTuiHelper = new tuiHelper(inStr, outStr);
		dataInput = inStr;
		dataOutput = outStr;
	}
	
	public PlayerTui(InputStream inStr, OutputStream outStr)
	{		
		this(inStr,new PrintStream(outStr));
	}

	public action getPlayerAction(List<action> possibileActions,double minimalBet) {
		// frage den Spieler, welche Aktion er machen will.
		dataOutput.println("Sie sind dran, was wollen sie machen?");
		dataOutput.printf("sie müssen mit mindestens [%8.2f] mitgehen",minimalBet);
		int i = 1;
		HashMap<Integer,action> menu = new HashMap<Integer, PlayerInterface.action>();
		
		for(action a : possibileActions)
		{
			menu.put(i, a);
			dataOutput.printf("[%2d] - %s\n", i,a);
			i++;
		}
		
		int choice = myTuiHelper.readInt(1, i);
		
		return menu.get(choice);
	}

	@Override
	public Player getPlayer() {
		return me;
	}

	@Override
	public void setPlayer(Player inPlayer) {
		me= inPlayer;
	}
	
	public String getPlayerName() {
		dataOutput.println("Geben sie ihren Namen ein:");
		return myTuiHelper.readLine();
	}

	@Override
	public void update(Observable o, Object arg) {
		updateTable((Table)o);
	}
	
	private void clearScreen()
	{
		dataOutput.print("\033[2J");//vt100 Commando das den Bildschirm löscht
	}
	/**
	 * Update Table zeigt den aktuellen Tisch an. Wenn der Player null ist wird der gesammte Tisch angezeigt.
	 * Wenn ein Player übergeben wird, wird der Tisch aus seiner Sicht angezeigt.
	 * */
	@Override
	public void updateTable(Table inTable) {
		clearScreen();
		dataOutput.println(new SimpleDateFormat("\ndd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
		dataOutput.println("Tisch: " + inTable.getPot());
		dataOutput.printf("[ %13s I %13s I %13s I %13s I %13s ]\n",inTable.getMiddleCards()[0],inTable.getMiddleCards()[1],inTable.getMiddleCards()[2],inTable.getMiddleCards()[3],inTable.getMiddleCards()[4]);
		dataOutput.printf("[%13s] : %s\n","Spielername","Anteil am Pot");
		for(Player p : inTable.getPlayers())
		{
			dataOutput.printf("[%13s] : %8.2f\n",p.getName(),inTable.getPlayersPot(p));
			if(p.equals(me))
				dataOutput.printf("\tmeine Karten: [ %13s I %13s ]\n",p.getCards().get(0),p.getCards().get(1));
				
		}
	}

	@Override
	public void sendInfo(String info) {
		// TODO Auto-generated method stub
		dataOutput.println(info);
	}
}
