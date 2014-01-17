package de.htwg.se.poker.controller;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import de.htwg.se.poker.model.Card;
import de.htwg.se.poker.model.Card.Rank;
import de.htwg.se.poker.model.Card.Suit;
import de.htwg.se.poker.model.Player;
import de.htwg.se.poker.model.Table;

/* Showdown */
public class patternRecognation {

	 public Player ComparePalyers(Table inTable)
	 {
		 
		 		 
		 return null;
	 }
	 
	 boolean isDoubleTwin(List<Card> inCards)
	 {
		 int twinCounter = 0;
		 for(Rank r : Card.Rank.values())
		 {
			 if(countRank(r,inCards) == 2)
				 twinCounter++;
		 }
		 
		 return twinCounter == 2;//höchstens 2 twins möglich!
	 }
	 
	 boolean isDrilling(List<Card> inCards)
	 {
		 for(Rank r : Card.Rank.values())
		 {
			 if(countRank(r,inCards) == 3)
				 return true;
		 }
		 return false;
	 }
	 
	 boolean isStraight(List<Card> inCards)
	 {
		 return ranksAreStraight(inCards);
	 }
	 
	 boolean isAllSameSuite(List<Card> inCards)
	 {
		 return suitesAreEqual(inCards);
	 }
	 
	 boolean isTwinDrilling(List<Card> inCards)
	 {
		 Rank r1 = inCards.get(0).getRank();
		 Rank r2 = null;
		 
		 for(Card c : inCards)
		 {
			if(c.getRank() !=  r1)
			{
				r2 = c.getRank();
				break;
			}
		 }
		 
		 return (countRank(r1,inCards) + countRank(r2,inCards)) == 5;
	 }
	 
	 boolean isFourOfAKind(List<Card> inCards)
	 {
		 //1. oder 2. Karte müssen im 4er Rang sein
		 Rank r1 = inCards.get(0).getRank();
		 Rank r2 = inCards.get(1).getRank();
		 
		 return countRank(r1, inCards) == 4 || countRank(r2, inCards) == 4;
		 
	 }
	 
	 boolean isStraightFlush(List<Card> inCards)
	 {
		 return ranksAreStraight(inCards) & suitesAreEqual(inCards);
	 }
	 
	 boolean isRoyalFlush(List<Card> inCards)
	 {
		 suitesAreEqual(inCards);
		 
		 boolean Ace,King,Queen,Jack,Ten;
		 Ace = King = Queen = Jack = Ten = false;
		 
		 for(Card c :inCards)
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
		 return Ace&King&Queen&Jack&Ten;
	 }
	 
	 boolean suitesAreEqual(List<Card> inCards)
	 {
		 Suit s = inCards.get(0).getSuit();
		 for(Card c : inCards)
		 {
			 if(c.getSuit() != s)
				 return false;
		 }
		 return true;
	 }
	 
	 boolean ranksAreStraight(List<Card> inCards)
	 {
		 TreeSet<Card> ts = new TreeSet<Card>(new Card.RankComperator()); 
		 ts.addAll(inCards);
		 
		 int LastIndex = ts.first().getRank().ordinal()-1;
		 
		 for(Card c : ts)
		 {
			 if(LastIndex-c.getRank().ordinal() == 1)
				 LastIndex++;
			 else
				 return false;
		 }
		 return true;
	 }
	 
	 int countRank(Rank r, List<Card> inCards){
		 int rankCount = 0;
		 for(Card c : inCards)
		 {
			 if(c.getRank() == r)
				 rankCount++;
		 }
		 return rankCount;
	 }
}
