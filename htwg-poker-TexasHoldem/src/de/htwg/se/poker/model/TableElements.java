package de.htwg.se.poker.model;

public class TableElements {

	private CardsElements cardsElements;
	
	public TableElements()
	{
		setCardsElements(new CardsElements());
	}


	public CardsElements getCardsElements()
	{
		return cardsElements;
	}


	public void setCardsElements(CardsElements cardsElements)
	{
		this.cardsElements = cardsElements;
	}
}
