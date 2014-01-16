package de.htwg.se.poker.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.AbstractMap.SimpleEntry;

import de.htwg.se.poker.model.Player;
import de.htwg.se.poker.model.Table;

public class netTui implements PlayerInterface {

	java.net.ServerSocket serverSocket;
	java.net.Socket mySocket;
	PlayerTui myTui;
	
	public netTui()
	{
		this(55455);
	}
	
	public netTui(int Port)
	{
		try {
			serverSocket = new java.net.ServerSocket(Port);
			mySocket = serverSocket.accept();
			InputStream is = mySocket.getInputStream();
			OutputStream os = mySocket.getOutputStream();
			myTui = new PlayerTui(is, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateTable(Table inTable) {
		myTui.updateTable(inTable);
	}

	@Override
	public SimpleEntry<action, Integer> getPlayerAction() {
		return myTui.getPlayerAction();
	}

	@Override
	public Player getPlayer() {
		return myTui.getPlayer();
	}

	@Override
	public void setPlayer(Player inPlayer) {
		myTui.setPlayer(inPlayer);
	}

	@Override
	public String getPlayerName() {
		return myTui.getPlayerName();
	}

}
