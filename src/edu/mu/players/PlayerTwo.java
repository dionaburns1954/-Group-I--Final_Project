package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.deck.EnemyDeck;

/**
 * Represents Player Two in the game
 * 
 * @author Dion Burns
 */
public class PlayerTwo extends Player{

	private ArrayList<Card> hand;
	private EnemyDeck deck;
	private int health;
	private static PlayerTwo instance = null;
	
	
	
	/**
	 * Constructs a new PlayerTwo instance
	 * 
	 * @param level The level of the enemy
	 */
	private PlayerTwo(int level) {
		//hand = initHand();
		health = 100;
		deck = new EnemyDeck(level);
	}
	
	/**
	 * Refreshes the deck of the player with a new level
	 * 
	 * @param lvl The new level
	 */
	public void refreshEnemy(int lvl) { //for if you want to change difficulty
		health = 100;
		deck.getCards().clear();
		deck = new EnemyDeck(lvl);
	}
	
	
	/**
	 * Gets the current instance of the player
	 * 
	 * @return the instance of the player
	 */
	public static PlayerTwo getPlayer() {
		if(instance == null) {
			instance = new PlayerTwo(1);
		}
		return instance;
	}
	
	@Override
	public Card playCard(Card card) {
		System.out.println("Card has been played!");
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
	public ArrayList<Card> initHand() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean checkPlayerHealth() {
		if(health <= 0) return false;
		
		return true;
	}

	public int getHealth() {
		return health;
	}

	@Override
	public void damagePlayer(int num) {
		// TODO Auto-generated method stub
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
