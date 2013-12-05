package de.htwg.se.poker.model;

import java.util.List;

public class Table {

	//static List<Karten> middleCard;
	
	Deck deck;
	int cardNbr;
			
	Cards flopCard1;
	String flopC1;
	Cards flopCard2;
	String flopC2;
	Cards flopCard3;
	String flopC3;
	Cards turnCard;
	String turn;
	Cards riverCard;
	String river;
	Cards userHolleCard1;
	
	Cards userHolleCard2;
	Cards compHolleCard1;
	Cards compHolleCard2;
			
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
	TableElements[][] table;
	
	
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
			         { "x","      ","     ","    ","xx","xxxxxxxxxxxxx","xx","   ","xx","xxxxxxxxxxxxx","xx","   ","xx","xxxxxxxxxxxxx","xx","   ","xx","xxxxxxxxxxxxx","xx","   ","xx","xxxxxxxxxxxxx","xx","       ","         ","x" },
			         { "x","      ","     ","    ","| ","FlopCard 1   "," |","   ","| ","FlopCard 2   "," |","   ","| ","FlopCard 3   "," |","   ","| ","TurnCard     "," |","   ","| ","RiverCard    "," |","       ","         ","x" },
			         { "x","      ","     ","    ","xx","xxxxxxxxxxxxx","xx","   ","xx","xxxxxxxxxxxxx","xx","   ","xx","xxxxxxxxxxxxx","xx","   ","xx","xxxxxxxxxxxxx","xx","   ","xx","xxxxxxxxxxxxx","xx","       ","         ","x" },
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
		this.deck = new Deck();
		
		
	}
	
	public void fillTable() {
				
		setFlopTurnRiver();
		for (int row = 0; row < tableArrayPattern.length; row++ )
	    {
	      for (int col = 0; col < tableArrayPattern[row].length; col++ )
	      {
	    	 System.out.print(tableArrayPattern[row][col]);
	      }
	      System.out.println(); 
	    }	
		
		
	}
	
	
	public List<Cards> getDeck() {
		deck.shuffleDeck();
		return deck.getDeckCards();
	}
	
	public void setFlopTurnRiver() {
		deck.shuffleDeck();
		flopCard1 = deck.deal();
		flopC1 = flopCard1.toString();
		
		flopCard2 = deck.deal();
		flopC2 = flopCard2.toString();
		
		flopCard3 = deck.deal();
		flopC3 = flopCard3.toString();
		
		turnCard = deck.deal();
		turn = turnCard.toString();
		
		riverCard = deck.deal();
		river = riverCard.toString();
		
	}
	
	public void getCell() {
		System.out.print(tableArrayPattern[10][4]);
	}
	
	public void setPotvalue() {
		
	}
	
	public void setUserStartCapital() {
		
	}
	
}


