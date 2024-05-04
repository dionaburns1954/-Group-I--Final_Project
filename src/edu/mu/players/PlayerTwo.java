package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;

public class PlayerTwo extends Player{

	private ArrayList<Card> hand;
	private int health;
	
	public PlayerTwo() {
		hand = initHand();
		health = 100;
	}
	
	
	@Override
	public void playCard(Card card) {
		// TODO Auto-generated method stub
		System.out.println("Card has been played!");
		removeCard(card);
		
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
	public boolean checkPlayerHealth() {
		if(health <= 0) return false;
		
		return true;
	}

}
