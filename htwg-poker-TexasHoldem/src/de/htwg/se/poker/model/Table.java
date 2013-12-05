package de.htwg.se.poker.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import de.htwg.se.poker.view.Tui;
public class Table {

	//static List<Karten> middleCard;
	
	Deck deck;
	Tui tui;
	int cardNbr;
	Player player;
	List<Player> playersList;
	
	private Cards flop;
	private List<Cards> flopList;
	
	public Cards flopCard1;
	public Cards flopCard2;
	public Cards flopCard3;
	
	public Cards turnCard;
	public Cards riverCard;
	
	private List<Cards> middleCards;
	
	public Cards userHoldCard1;
	public Cards userHoldCard2;
	
	public Cards compHoldCard1;
	public Cards compHoldCard2;
	
	List<Cards> playerHoldCards;
			
	double startCapital = 500.00;
	double pot = 0.0;
	
	String dealButton;
	String bigBlind = "bB";
	String smallBlind = "sB";
	int bigBlindWert = 4;
	int smallBlindWert = bigBlindWert/2;
	String userName = "USER";
	String compName = "MacPro";
	
	//Optionen
	boolean fold = false; // aussteigen
	boolean call = false; // mitgehen
	boolean raise = false;// erhoehen
	boolean check = false;// passen
	int callValue;
	int raiseValue;
			
	int roundNbr;
	String[][] tableArrayPattern;
	TableElementsInterface[][] table;
	
	
	// Konstruktor
	public Table() {
		this.tableArrayPattern = 
			      new String[][] {
			         { "x","xx","xx","xxxxxxxxxxxxx","xx","xx","xx","xxxxxxxxxxxxx","xx","xxxxxxxx","xx","xxxxxxxxxxxxx","xx","xx","xx","xxxxxxxxxxxxx","xx","xxxxxx","xxxx","xxxxxxxxxxxxx","xx","xx","xx","xxxxxxxxxxxxx","xx","xxx" }, 
			         { "x","  ","  ","             ","  ","  ","  ","             ","  ","        ","  ","             ","  ","  ","  ","             ","  ","      ","    ","             ","  ","  ","  ","             ","  ","  x" },
			         { "x","  ","**","*************","**","  ","**","*************","**","        ","**","*************","**","  ","**","*************","**","        ","**","*************","**","  ","**","*************","**","  x" },
			         { "x","  ","* ","Pl1-HoldCard1"," *","  ","* ","Pl1-HoldCard2"," *","        ","* ","Pl2-HoldCard1"," *","  ","* ","Pl2-HoldCard2"," *","        ","* ","Pl3-HoldCard1"," *","  ","* ","Pl3-HoldCard2"," *","  x" },
			         { "x","  ","**","*************","**","  ","**","*************","**","        ","**","*************","**","  ","**","*************","**","        ","**","*************","**","  ","**","*************","**","  x" },
			         { "x","    ","Player1-Name","   ","Capital:"," ","500,00"," ","Û","            ","Player2-Name","   ","Capital:"," ","500,00"," ","Û","            ","Player3-Name","   ","Capital:"," ","500,00"," ","Û","    x" }, 
			         { "x     ","-","----","-  -","----","-  -","-----","-    ","                 ","-","----","-  -","----","-  -","-----","-    ","                 ","-","----","-  -","----","-  -","-----","-    ","        ","x" },
			         { "x     ","|","Fold","|  |","Call","|  |","raise","|    ","DB               ","|","Fold","|  |","Call","|  |","raise","|    ","DB               ","|","Fold","|  |","Call","|  |","raise","|    ","DB      ","x" },
			         { "x     ","-","----","-  -","----","-  -","-----","-    ","                 ","-","----","-  -","----","-  -","-----","-    ","                 ","-","----","-  -","----","-  -","-----","-    ","        ","x" },
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","       ","         ","x" },
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","       ","         ","x" },
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","       ","         ","x" },
			         { "x","      ","     ","    ","**","*************","**","   ","**","*************","**","   ","**","*************","**","   ","**","*************","**","   ","**","*************","**","       ","         ","x" },
			         { "x","      ","     ","    ","* "," FlopCard 1  "," *","   ","* "," FlopCard 2  "," *","   ","* "," FlopCard 3  "," *","   ","* ","  TurnCard   "," *","   ","* ","  RiverCard  "," *","       ","         ","x" },
			         { "x","      ","     ","    ","**","*************","**","   ","**","*************","**","   ","**","*************","**","   ","**","*************","**","   ","**","*************","**","       ","         ","x" },
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","       ","         ","x" },
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","Pot: ","0000,00"," Û","      ","             ","  ","   ","  ","             ","  ","       ","         ","x" }, 
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","       ","         ","x" },
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","       ","         ","x" },
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","       ","         ","x" },
			         { "x","      ","     ","    ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","   ","  ","             ","  ","       ","         ","x" },
			         { "x     ","-","----","-  -","----","-  -","-----","-    ","                 ","-","----","-  -","----","-  -","-----","-    ","                 ","-","----","-  -","----","-  -","-----","-    ","        ","x" },
			         { "x     ","|","Fold","|  |","Call","|  |","raise","|    ","DB               ","|","Fold","|  |","Call","|  |","raise","|    ","DB               ","|","Fold","|  |","Call","|  |","raise","|    ","DB      ","x" },
			         { "x     ","-","----","-  -","----","-  -","-----","-    ","                 ","-","----","-  -","----","-  -","-----","-    ","                 ","-","----","-  -","----","-  -","-----","-    ","        ","x" },
			         { "x","    ","Player4-Name","   ","Capital:"," ","500,00"," ","Û","            ","Player5-Name","   ","Capital:"," ","500,00"," ","Û","            ","Player6-Name","   ","Capital:"," ","500,00"," ","Û","    x" },
			         { "x","  ","**","*************","**","  ","**","*************","**","        ","**","*************","**","  ","**","*************","**","        ","**","*************","**","  ","**","*************","**","  x" },
			         { "x","  ","* ","Pl4-HoldCard1"," *","  ","* ","Pl4-HoldCard2"," *","        ","* ","Pl5-HoldCard1"," *","  ","* ","Pl5-HoldCard2"," *","        ","* ","Pl6-HoldCard1"," *","  ","* ","Pl6-HoldCard2"," *","  x" },
			         { "x","  ","**","*************","**","  ","**","*************","**","        ","**","*************","**","  ","**","*************","**","        ","**","*************","**","  ","**","*************","**","  x" },
			         { "x","  ","  ","             ","  ","  ","  ","             ","  ","        ","  ","             ","  ","  ","  ","             ","  ","      ","    ","             ","  ","  ","  ","             ","  ","  x" },
			         { "x","xx","xx","xxxxxxxxxxxxx","xx","xx","xx","xxxxxxxxxxxxx","xx","xxxxxxxx","xx","xxxxxxxxxxxxx","xx","xx","xx","xxxxxxxxxxxxx","xx","xxxxxx","xxxx","xxxxxxxxxxxxx","xx","xx","xx","xxxxxxxxxxxxx","xx","xxx" },
			       };
		
		this.deck = new Deck(); // create a Deck with 52 Cards
		this.player = new Player(); // create a player with name and initCapital
		this.playerHoldCards = new LinkedList<Cards>();
		this.middleCards = new LinkedList<Cards>();
		this.tui = new Tui();
		this.playersList = new LinkedList<Player>();
		this.flopList = new LinkedList<Cards>();
	}
	
	public List<Cards> getDeckOfKonsole() {
		return deck.getDeckCards();
	}
	
	public void getDeckSize() {
		System.out.println(deck.getDeckSize());
	}
	
	public void setPlayerOfKonsole() {
		System.out.println(player.name);
		System.out.println(player.getPlayerName());
		System.out.println(player.getPlayerInitCapital());
	}
	
	public void fillTable() {
				
		for (int row = 0; row < tableArrayPattern.length; row++ )
	    {
	      for (int col = 0; col < tableArrayPattern[row].length; col++ )
	      {
	    	 System.out.print(tableArrayPattern[row][col]);
	      }
	      System.out.println(); 
	    }	
	}
	
	@SuppressWarnings("unchecked")
	public void setFlop() {
		deck.shuffleDeck();
		if (flopList.isEmpty() && middleCards.isEmpty())
		{
			for (int i = 0; i < 3; i++)
			{
				flop=deck.deal();
				flopList.add(flop);
				if (i == 0) flopCard1 = flop;
				else if (i == 1) flopCard2 = flop;
				else flopCard3 = flop;
			}
			middleCards = (List<Cards>) ((LinkedList<Cards>) flopList).clone();
		}
		else
			System.out.println("flop already exits!");
	}
	
	public List<Cards> getFlop() {
		
		if (flopList.isEmpty())
		{
			System.out.println("Flop is empty!");
			return null;
		}
		
		return flopList;
	}
	
	public void setTurn() {
		if (middleCards.isEmpty())
		{
			System.out.println("Not possible to create the Turn! middleCards is empty!!");
		}
		else if (middleCards.size() == 3)
		{
			deck.shuffleDeck();
			middleCards.add(turnCard = deck.deal());
		}
		else
			System.out.println("The turn already exists!!");

	}
	public Cards getTurn() {
		
		if (!middleCards.contains(turnCard))
		{
			System.out.printf("MiddleCards contains turn: %o \n", turnCard);
			return null;
		}
		else
			return turnCard;
	}
	
	public void setRiver() {
		
	if (middleCards.isEmpty())
	{
		System.out.println("Not possible to create the River! middleCards is empty!!");
	}
	else if (middleCards.size() == 4)
	{
		deck.shuffleDeck();
		middleCards.add(riverCard = deck.deal());
	}
	else
		System.out.println("The river already exists!!");
}

public Cards getRiver() {
		
		if (!middleCards.contains(riverCard))
		{
			System.out.printf("MiddleCards contains turn: %o \n", riverCard);
			return null;
		}
		else
			return riverCard;
	}
	
	public List<Cards> getMiddleCards() {
		
		if (middleCards.isEmpty())
			System.out.println("The middlecards are not created!!");
		return middleCards;
	}
	
	 public List<Cards> getPlayerHoldCards() {
		 
		 for (int i = 0; i > 2; i++)
		 {
			 playerHoldCards.add(deck.deal());
			 System.out.println(playerHoldCards);
		 }
		 
		 return playerHoldCards;
	 }
	 
	 public List<Player> getPlayerList() {
		 playersList = tui.getNewPlayers();
		 for (Iterator<Player> iterator = tui.getNewPlayers().iterator(); iterator.hasNext();)
			{
				System.out.println(iterator.next());
			}
			System.out.println();
		 return playersList; // contains allocation of list with players names
	 }
	 
	public void getCell() {
		System.out.print(tableArrayPattern[13][5]);
	}
	
	public void setPotvalue() {
		
	}
	
	public void setUserStartCapital() {
		
	}
	
}


