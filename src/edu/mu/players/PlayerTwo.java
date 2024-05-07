package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.deck.EnemyDeck;

/**
 * Represents Player Two in the game. This player represents the AI that the player will play against.
 * 
 * @version 1.0
 * 
 * @see Player
 * 
 * @author Dion Burns
 */
public class PlayerTwo extends Player{

	/**
	 * The cards that the player has available to play during {@link edu.mu.battle.Battle}.
	 */
	private ArrayList<Card> hand;
	/**
	 * The player's current deck.
	 */
	private EnemyDeck deck;
	private int health;
	
	/**
	 * The current instance of the player.
	 */
	private static PlayerTwo instance = null;
	
	/**
	 * Constructs a new PlayerTwo instance.
	 * 
	 * @param level The level of the enemy
	 */
	public PlayerTwo(int level) {
		health = 100;
		deck = new EnemyDeck(level);
	}
	
	/**
	 * Refreshes the deck of the player with a new level.
	 * 
	 * @param level The new level
	 */
	public void refreshEnemy(int level) {
		health = 100;
		// Clear the current cards and adds the cards of the corresponding level.
		deck.getCards().clear();
		deck = new EnemyDeck(level);
	}
	
	/**
	 * Gets the current instance of the player.
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
	public boolean checkPlayerHealth() {
		if(health <= 0) return false;
		
		return true;
	}

	/**
	 * Gets the player's current health.
	 * @return The current health of the player
	 */
	public int getHealth() {
		return health;
	}

	@Override
	public void damagePlayer(int num) {
		health = health - num;
	}
	
	/**
	 * Sets the hand of the player.
	 * 
	 * @param cards The cards to set as the hand
	 */
	public void setHand(ArrayList<Card> cards) {
		hand = cards;
	}
	
	/**
	 * Gets the hand of the player.
	 * 
	 * @return The hand of the player
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	/**
	 * Gets the deck of the player.
	 * 
	 * @return The deck of the player
	 */
	public Deck getDeck() {
		return deck;
	}

}
