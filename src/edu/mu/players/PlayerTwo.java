package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;

public class PlayerTwo extends Player{

	ArrayList<Card> hand;
	
	public PlayerTwo() {
		hand = initHand();
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

}
