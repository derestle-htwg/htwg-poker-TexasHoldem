package de.htwg.se.poker.model;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import de.htwg.se.poker.model.Card.Rank;
import de.htwg.se.poker.model.Card.Suit;

public class CardTest extends TestCase{
	
	@Before
    public void setUp() {
            
    }

    @After
    public void tearDown() {

    }
	
    @Test
	public void test() {
		for(Rank r : Rank.values())
		{
			for(Suit s : Suit.values())
			{
				Card c = new Card(r,s);
				assertTrue(c.getRank() == r);
				assertTrue(c.getSuit() == s);
				assertTrue(c.toString().equals(String.format("%13s",s + " " + r)));
			}
		}
	}

}
