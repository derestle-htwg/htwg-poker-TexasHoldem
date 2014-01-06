package de.htwg.se.poker.view;

import java.util.AbstractMap;

import de.htwg.se.poker.model.Table;

public interface PlayerInterface {
	
	public enum action{call,raise,fold}

	public void updateTable(Table inTable);
	
	public AbstractMap.SimpleEntry<action, Integer> getPlayerAction();
}
