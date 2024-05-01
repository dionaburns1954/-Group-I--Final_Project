package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;

public class PlayerOne extends Player { //This is the character that you will play as
	
	ArrayList<Card> hand;
	
	public PlayerOne() {
		hand = new ArrayList<Card>();
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

}
