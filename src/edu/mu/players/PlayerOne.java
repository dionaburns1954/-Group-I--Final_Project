package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.deck.UserDeck;

/**
 * Represents Player One in the game
 * 
 * @author Dion Burns
 */
public class PlayerOne extends Player { //This is the character that you will play as
	
	private ArrayList<Card> hand;
	private UserDeck deck;
	private int health;
	
	/**
	 * Constructs a new PlayerOne instance
	 */
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
	/**
	 * Sets the hand of the player
	 * 
	 * @param cards The cards to set as the hand
	 */
	public void setHand(ArrayList<Card> cards) {
		hand = cards;
	}
	
	/**
	 * Gets the hand of the player
	 * 
	 * @return The hand of the player
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	/**
	 * Gets the deck of the player
	 * 
	 * @return The deck of the player
	 */
	public Deck getDeck() {
		return deck;
	}

}
