package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.deck.UserDeck;

public class PlayerOne extends Player { //This is the character that you will play as
	
	private ArrayList<Card> hand;
	private UserDeck deck;
	private int health;
	
	public PlayerOne() {
		deck = new UserDeck();
		//hand = initHand();
		health = 100;
	}

	

	@Override
	public Card playCard(Card card) {
		// TODO Auto-generated method stub
		System.out.println("Played card " + card);
		Card playedCard = card;
		removeCard(card);
		return playedCard;
		
	}

	@Override
	public void removeCard(Card card) {
		// TODO Auto-generated method stub
		hand.remove(card);
		
	}

	@Override
	public void addCardToHand(ArrayList<Card> card) {
		// TODO Auto-generated method stub
		Card cardToAdd = card.get(0);
		hand.add(cardToAdd);
	}


	@Override
	public ArrayList<Card> initHand() { //need to get rid of this because hand is being init in gameManager class
		// TODO Auto-generated method stub
		//take from deck and pull some amount of cards
		return null;
	}



	@Override
	public boolean checkPlayerHealth() { //method for checking if player has died
		if(health <= 0) return false;
		
		return true;
	}



	@Override
	public void damagePlayer(int num) {
		health = health - num;
		
	}
	
	public void setHand(ArrayList<Card> cards) {
		hand = cards;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public Deck getDeck() {
		return deck;
	}

}
