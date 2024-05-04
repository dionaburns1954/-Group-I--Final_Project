package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;

public class PlayerOne extends Player { //This is the character that you will play as
	
	private ArrayList<Card> hand;
	private int health;
	
	public PlayerOne() {
		hand = initHand();
		health = 100;
	}

	

	@Override
	public void playCard(Card card) {
		// TODO Auto-generated method stub
		System.out.println("Played card " + card);
		
	}

	@Override
	public void removeCard(Card card) {
		// TODO Auto-generated method stub
		hand.remove(card);
		
	}

	@Override
	public void addCardToHand(Card card) {
		// TODO Auto-generated method stub
		hand.add(card);
	}


	@Override
	public ArrayList<Card> initHand() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean checkPlayerHealth() { //method for checking if player has died
		if(health <= 0) return false;
		
		return true;
	}

}
