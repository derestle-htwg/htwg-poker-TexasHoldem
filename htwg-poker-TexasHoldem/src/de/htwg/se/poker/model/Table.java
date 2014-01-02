package de.htwg.se.poker.model;

public class Table {

	public TableElements tableElem;
	public Object[][] tableArray;
	int index = 0;
	
	public Table() {
		this.tableElem = new TableElements();
		this.tableArray = new Object[30][27];
		tableElem.cardsElements.setMiddleCards();
	}
	
	
	public void setTableComponents(int round)
	{
		for (int row = 0; row < tableArray.length; row++)
	    {
	      for (int col = 0; col < tableArray[row].length; col++)
	      {
	    	    	  
	    	  if (row == 2 || row == 4 || row == 25 || row == 27)
	    		  setBorderOfHoldCardsField(row, col);
	    	  
	    	  else if (row == 3 || row == 26)
	    		  setHoldCards(row, col, round);	    	 
	    	  
	    	  else if (row == 5 || row == 24)	    	  
	    		  setPlayerData(row, col, round);
	    	  
	    	  else if (row == 6 || row == 8 || row == 21 || row == 23)
	    		  setCheckBoxBorder(row, col);
	    	  
	    	  else if (row == 7 || row == 22)
	    		  setCheckBox(row, col, round);
	    	  
	    	  else if (row == 12 || row == 14)
	    		  setBorderOfMiddleCardsField(row, col);
	    	  
	    	  else if (row == 13)
	    		  setMiddlecardsOnTheTable(row, col, index, round);
	    	  
	    	  else if (row == 16)
	    		  setPotValue(row, col, round);	    	
	    	  
	    	  else if (row == 0 || row == 29)	    	  
	    		  tableArray[row][col] = "#####";	    	  
	    	  
	    	  else  
	    		  setFreeCells(row, col);
	      }	      
	    }
		
		fillTable();
	}

	private void setFreeCells(int row, int col)
	{
		if (col == 0)
			tableArray[row][col] = "#    ";
		
		else if (col == 26)
			tableArray[row][col] = "    #";
		
		else
			tableArray[row][col] = "     ";
	}
	
	private void setBorderOfHoldCardsField(int row, int col)
	{
		if (col == 0 || col == 26)		
			tableArray[row][col] = "#";	
		
		else if (col == 1)
			tableArray[row][col] = "    ";
		
		else if (col == 2 || col == 4 || col == 6 || col == 8 || 
				 col == 10 || col == 12 || col == 14 || col == 16 ||
				 col == 18 || col == 20 || col == 22 || col == 24)
			
			tableArray[row][col] = "**";
				
		
		else if (col == 3 || col == 7 || col == 11 || 
				 col == 15 || col == 19 || col == 23)
		
			tableArray[row][col] = "*************";
		
		
		else if (col == 5 || col == 13 || col == 21)
			tableArray[row][col] = "  ";
				
		else if  (col == 9 || col == 17)		
   			tableArray[row][col] = "        ";			
				
		else		
			tableArray[row][col] = "     ";
		
	}
	
	private void setHoldCards(int row, int col, int round)
	{
		if (col == 0 || col == 26)
			tableArray[row][col] = "#";
		
		else if (col == 1)
			tableArray[row][col] = "    ";
		
		else if (col == 2 || col == 6 || col == 10 || 
				 col == 14 || col == 18 || col == 22)
			
			tableArray[row][col] = "* ";
		
		
		else if (col == 4 || col == 8 || col == 12 || 
				 col == 16 || col == 20 || col == 24)
			
			tableArray[row][col] = " *";
		
		
		else if (col == 3 || col == 7 || col == 11 || 
				 col == 15 || col == 19 || col == 23)
		{
			if (round == 0)
				tableArray[row][col] = "  HoldCard   ";
			else
				tableArray[row][col] = tableElem.cardsElements.getCard();
		}
		
		else if (col == 5 || col == 13 || col == 21)
			tableArray[row][col] = "  ";
		
		else if  (col == 9 || col == 17)
   			tableArray[row][col] = "        ";			
		
		else
			tableArray[row][col] = "     ";
	}
	
	private void setBorderOfMiddleCardsField(int row, int col)
	{		
		if (col == 0 || col == 26)
			tableArray[row][col] = "#";
		
		else if ( col == 1 || col == 2 || col == 3 ||
				  col == 23 || col == 24 || col == 25)
			
			tableArray[row][col] = "      ";
	
		
		else if ( col == 4 || col == 6 || col == 8 || col == 10 || 
				  col == 12 || col == 14 || col == 16 || col == 18 ||
				  col == 20 || col == 22 )
			
			tableArray[row][col] = "**";		
		
		
		else if ( col == 5 || col == 9 || col == 13 || col == 17 || col == 21 )
			tableArray[row][col] = "*************";
				
		else if  (col == 7 || col == 11 || col == 15 || col == 19)		
   			tableArray[row][col] = "   ";					
	}

	private void setMiddlecardsOnTheTable(int row, int col, int ind, int round)
	{
		if (col == 0 || col == 26)		
			tableArray[row][col] = "#";
				
		else if ( col == 1 || col == 2 || col == 3 ||
				  col == 23 || col == 24 || col == 25)
		
			tableArray[row][col] = "      ";

		
		else if (col == 4 || col == 8 || col == 12 || 
				 col == 16 || col == 20)
		
			tableArray[row][col] = "* ";
	
		
		else if (col == 6 || col == 10 || col == 14 || 
				 col == 18 || col == 22)
		
			tableArray[row][col] = " *";

		
		else if (col == 5 || col == 9 || col == 13 || 
				 col == 17 || col == 21)
		{
			if (round == 0)			
				tableArray[row][col] = "  MiddleCard ";
						
			else 
			{
				if (ind < 5)
				{
					tableArray[row][col] = tableElem.cardsElements.getMiddleCards().get(index);
					++index;
				}
			}
		}
		
		else if  (col == 7 || col == 11 || col == 15 || col == 19)		
   			tableArray[row][col] = "   ";					
	}
		
	private void setPlayerData(int row, int col, int round)
	{
		if (col == 0 || col == 26)
			tableArray[row][col] = "#";
				
		else if (col == 1)		
			tableArray[row][col] = "      ";
				
		else if (col == 2 || col == 10 || col == 18)
		{
			if (round == 0)
				tableArray[row][col] = " Empty-Seat ";
			else
			tableArray[row][col] = "Player-Name ";
		}
		
		else if (col == 4 || col == 12 || col == 20)		
			tableArray[row][col] = "Capital:";		
		
		else if (col == 3 || col == 11 || col == 19)		
			tableArray[row][col] = "  ";		
		
		else if (col == 5 || col == 7 || col == 13 || 
				 col == 15 || col == 21 || col == 23)
		
   			tableArray[row][col] = " ";					
		
		
		else if (col == 6 || col == 14 || col == 22)		
			tableArray[row][col] = "500.00";
				
		else if (col == 8 || col == 16 || col == 24)		
			tableArray[row][col] = "Û";
				
		else if (col == 9 || col == 17)		
			tableArray[row][col] = "             ";
				
		else		
			tableArray[row][col] = "        ";
	}
	
	private void setCheckBoxBorder(int row, int col)
	{
		if (col == 0 || col == 26)		
			tableArray[row][col] = "#";
				
		else if (col == 1)		
			tableArray[row][col] = "       ";		
		
		else if (col == 2 || col == 10 || col == 18)		
			tableArray[row][col] = "-";
				
		else if ( col == 3 || col == 5 || col == 7 ||  
				  col == 11 || col == 13 || col == 15 ||
				  col == 19 || col == 21 || col == 23 )
		
			tableArray[row][col] = "-----";
		
		
		else if (col == 4 || col == 6 || col == 12 || 
				 col == 14 || col == 20 || col == 22)
		
			tableArray[row][col] = "-  -";
		
		
		else if  (col == 8 || col == 16 || col == 24)		
   			tableArray[row][col] = "-  ";			
				
		else if (col == 9 || col == 17)		
			tableArray[row][col] = "                  ";
				
		else		
			tableArray[row][col] = "         ";		
	}
		
	private void setCheckBox(int row, int col, int round)
	{
		if (col == 0 || col == 26)		
			tableArray[row][col] = "#";
				
		else if (col == 1)		
			tableArray[row][col] = "       ";
				
		else if (col == 2 || col == 10 || col == 18)		
			tableArray[row][col] = "-";
		
		else if (col == 3 || col == 5 || col == 7 ||  
				 col == 11 || col == 13 || col == 15 ||
				 col == 19 || col == 21 || col == 23)
		
			tableArray[row][col] = " OPT ";
		
		else if (col == 4 || col == 6 || col == 12 || 
				 col == 14 || col == 20 || col == 22)
			
			tableArray[row][col] = "-  -";
		
		
		else if  (col == 8 || col == 16 || col == 24)		
   			tableArray[row][col] = "-  ";			
		
		
		else if (col == 9 || col == 17)		
			tableArray[row][col] = " DB               ";
		
		
		else		
			tableArray[row][col] = " DB      ";		
	}
		
	private void setPotValue(int row, int col, int round)
	{
		if (col == 0 || col == 26)
			tableArray[row][col] = "#";
		
		else if (col == 13)
			tableArray[row][col] = "Pot: ";
		
		else if (col == 14)
			tableArray[row][col] = "0000.00";
		
		else if (col == 15)
			tableArray[row][col] = " Û";
		
		else if (col == 25)
			tableArray[row][col] = "              ";
		
		else
			tableArray[row][col] = "     ";
	}
	
	
	private void fillTable()
	{
		for (int row = 0; row < tableArray.length; row++ )
	    {
	      for (int col = 0; col < tableArray[row].length; col++ )
	      {
	    	 System.out.print(tableArray[row][col]);    	  
	      } 
	      System.out.println();
	    }
	}
}