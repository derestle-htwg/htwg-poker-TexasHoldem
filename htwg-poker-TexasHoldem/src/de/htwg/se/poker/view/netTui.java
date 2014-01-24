package de.htwg.se.poker.view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Observable;

import de.htwg.se.poker.model.Player;
import de.htwg.se.poker.model.Table;
import de.htwg.se.poker.view.PlayerInterface.action;

public class netTui implements PlayerInterface {

	static java.net.ServerSocket serverSocket;
	java.net.Socket mySocket;
	PlayerTui myTui;
	

	public netTui()
	{
		try {
			if(serverSocket == null)
				serverSocket = new java.net.ServerSocket(55455);
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
	public action getPlayerAction(List<action> possibileActions,double minimalBet) {
		return myTui.getPlayerAction(possibileActions,minimalBet);
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

	@Override
	public void update(Observable o, Object arg) {
		myTui.update(o, arg);
		
	}

	@Override
	public void sendInfo(String info) {
		// TODO Auto-generated method stub
		myTui.sendInfo(info);
	}

	@Override
	public double getActionValue() {
		// TODO Auto-generated method stub
		return myTui.getActionValue();
	}

}
