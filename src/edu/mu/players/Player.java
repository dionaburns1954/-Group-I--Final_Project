package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;

public abstract class Player {

	//ArrayList<Card> hand;
	
	public abstract Card playCard(Card card);
	
	public abstract void removeCard(Card card); //might change later
	
	public abstract void addCardToHand(ArrayList<Card> card);
	
	public abstract ArrayList<Card> initHand();
	
	public abstract boolean checkPlayerHealth();
	
	public abstract void damagePlayer(int num);
	
}
