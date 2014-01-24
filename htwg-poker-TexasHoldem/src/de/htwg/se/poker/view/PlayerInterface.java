package de.htwg.se.poker.view;

import java.util.AbstractMap;
import java.util.List;
import java.util.Observer;
import java.util.AbstractMap.SimpleEntry;

import de.htwg.se.poker.model.Player;
import de.htwg.se.poker.model.Table;

public interface PlayerInterface extends Observer{
	
	public String InterfaceName = "UnknownInterface";
	
	public enum action{call,raise,fold,quitGame,allIn}

	public void updateTable(Table inTable);
	
	public action getPlayerAction(List<action> possibileActions,double minimalRaise);
	
	public Player getPlayer();
	
	public void setPlayer(Player inPlayer);
	
	public String getPlayerName();
	
	public void sendInfo(String info);
	
	public double getActionValue();
}
