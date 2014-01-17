package de.htwg.se.poker.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;
import de.htwg.se.poker.model.Card;
import de.htwg.se.poker.model.Card.Rank;
import de.htwg.se.poker.model.Card.Suit;
import de.htwg.se.poker.model.Player;
import de.htwg.se.poker.model.Table;

public class patternRecognation {
	
	private interface cardHandComperator
	{
		public boolean call(List<Card> Input);
	}

	 public List<Player> ComparePlayers(Table inTable)
	 {
		 List<Player> winners = new LinkedList<Player>();
		 Map<Player,List<Card>> playersCards = new HashMap<Player, List<Card>>(); 
		 
		 for(Player p : inTable.getPlayers())
		 {
			 List<Card> cards = new LinkedList<Card>();
			 cards.addAll(p.getCards());
			 for(Card c : inTable.getMiddleCards())
				 cards.add(c);
			 playersCards.put(p, cards);
		 }
		 
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isRoyalFlush(Input);}},winners,playersCards);
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isStraightFlush(Input);}},winners,playersCards);
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isFourOfAKind(Input);}},winners,playersCards);
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isTwinDrilling(Input);}},winners,playersCards);
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isAllSameSuite(Input);}},winners,playersCards);
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isStraight(Input);}},winners,playersCards);
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isDrilling(Input);}},winners,playersCards);
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isDoubleTwin(Input);}},winners,playersCards);
		 cascadeHandComperator(new cardHandComperator() {@Override public boolean call(List<Card> Input) { return isTwin(Input);}},winners,playersCards);
		 
		 if(winners.isEmpty())
		 {
			 List<Card> allCards = new LinkedList<Card>();
			 for(Player p : inTable.getPlayers())
			 {
				 allCards.addAll(p.getCards());
			 }
			 
			 Card highestCard = ReturnHighestCard(allCards);
			 
			 for(Player p : inTable.getPlayers())
			 {
				 for(Card c : p.getCards())
					 if(c.getRank().equals(highestCard.getRank()))
						 winners.add(p);
			 }
		 }
		 
		 return winners;
	 }
	 
	 private List<Player> cascadeHandComperator(cardHandComperator inFunction, List<Player> inWinners, Map<Player,List<Card>> inPlayerCards)
	 {
		 if(inWinners.isEmpty())
		 {//vergleichen
			 for(Entry<Player, List<Card>> kvp : inPlayerCards.entrySet())
			 {
				 if(inFunction.call(kvp.getValue()))
					 inWinners.add(kvp.getKey());
			 }
		 }
		 //Wenn if nicht genommen: Gewinner steht/stehen bereits fest, Ergebnis einfach weiterreichen 
		 
		 return inWinners;
	 }
	 
	 private Card ReturnHighestCard(List<Card> inCards)
	 {
		 TreeSet<Card> ts = new TreeSet<Card>(new Card.RankComperator()); 
		 ts.addAll(inCards);
		 return ts.last();
	 }
	 
	 private boolean isTwin(List<Card> inCards)
	 {
		 for(Rank r : Card.Rank.values())
		 {
			 if(countRank(r,inCards) == 2)
				 return true;
		 }
		 return false;
	 }
	 
	 private boolean isDoubleTwin(List<Card> inCards)
	 {
		 int twinCounter = 0;
		 for(Rank r : Card.Rank.values())
		 {
			 if(countRank(r,inCards) == 2)
				 twinCounter++;
		 }
		 
		 return twinCounter >= 2;
	 }
	 
	 private boolean isDrilling(List<Card> inCards)
	 {
		 for(Rank r : Card.Rank.values())
		 {
			 if(countRank(r,inCards) == 3)
				 return true;
		 }
		 return false;
	 }
	 
	 private boolean isStraight(List<Card> inCards)
	 {
		 return LongestStraightRanks(inCards,null) >= 5;
	 }
	 
	 private boolean isAllSameSuite(List<Card> inCards)
	 {
		 return suitesAreEqual(inCards,5);
	 }
	 
	 private boolean isTwinDrilling(List<Card> inCards)
	 {
		 boolean three = false;
		 boolean two = false;
		 
		 for(Rank r : Rank.values())
		 {
			 if(countRank(r, inCards) >= 3)
			 {
				 if(three || two)
					 return true;
				 else
					 three = true;
			 }
			 if(countRank(r, inCards) == 2)
			 {
				 if(three)
					 return true;
				 else
					 two = true;
			 }
		 }
		 
		 return false;
	 }
	 
	 private boolean isFourOfAKind(List<Card> inCards)
	 {
		 for(Rank r : Rank.values())
		 {
			 if(countRank(r,inCards) == 4)
				 return true;
		 }
		 return false;
	 }
	 
	 private boolean isStraightFlush(List<Card> inCards)
	 {
		 for(Suit s : Suit.values())
		 {
			 if(LongestStraightRanks(inCards,s) >= 5)
				 return true;
		 }
		 return false;
	 }
	 
	 private boolean isRoyalFlush(List<Card> inCards)
	 {
		 boolean Ace,King,Queen,Jack,Ten;
		  
		 for(Suit s : Suit.values())
		 {
			 Ace = King = Queen = Jack = Ten = false;
			 
			 for(Card c :inCards)
			 {
				if(c.getSuit() == s)
				{
					switch(c.getRank())
					{
					case ACE:
						Ace = true;
						break;
					case KING:
						King = true;
						break;
					case QUEEN:
						Queen = true;
						break;
					case JACK:
						Jack = true;
						break;
					case TEN:
						Ten = true;
						break;
					default:
						return false;
					}
				}
			 }
			 if(Ace&King&Queen&Jack&Ten)
				 return true;
		 }
		 return false;
	 }
	 
	 private boolean suitesAreEqual(List<Card> inCards,int minCounter)
	 {
		 int cH= minCounter;
		 int cD = minCounter;
		 int cC = minCounter;
		 int cS = minCounter;
		 
		 for(Card c : inCards)
		 {
			 if(c.getSuit() == Suit.SPADE)
				 cS--;
			 if(c.getSuit() == Suit.CLUB)
				 cC--;
			 if(c.getSuit() == Suit.HEART)
				 cH--;
			 if(c.getSuit() == Suit.DIAMOND)
				 cD--;
			 if(cS == 0 || cC == 0 || cH == 0 || cD == 0)
				 return true;
		 }
		 return false;
	 }
	 
	 private int LongestStraightRanks(List<Card> inCards,Suit s)
	 {
		 TreeSet<Card> ts = new TreeSet<Card>(new Card.RankComperator()); 
		 ts.addAll(inCards);
		 
		 int LastIndex = ts.first().getRank().ordinal()-1;
		 int actualCount = 0;
		 int longestCount = 0;
		 
		 for(Card c : ts)
		 {
			 if(s == null || c.getSuit() == s)
			 {
				 if(c.getRank().ordinal()-LastIndex == 1)
				 {//ein weiterführendes Element gefunden
					 LastIndex++;
					 actualCount++;
				 }
				 else if(LastIndex-c.getRank().ordinal() == 0)
					 continue;//gleicher Rang, nach nächstem Element schauen
				 else
				 {
					 LastIndex = c.getRank().ordinal();
					 actualCount = 1;
				 }
			 }
			 if(actualCount > longestCount)
				 longestCount = actualCount;
		 }
		 return longestCount;
	 }
	 
	 private int countRank(Rank r, List<Card> inCards){
		 int rankCount = 0;
		 for(Card c : inCards)
		 {
			 if(c.getRank() == r)
				 rankCount++;
		 }
		 return rankCount;
	 }
}
