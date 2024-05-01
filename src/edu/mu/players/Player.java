package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;

public abstract class Player {

	//ArrayList<Card> hand;
	
	public abstract void playCard(Card card);
	
	public abstract void removeCard(Card card); //might change later
	
	public abstract void addCardToHand(Card card);
	
}
