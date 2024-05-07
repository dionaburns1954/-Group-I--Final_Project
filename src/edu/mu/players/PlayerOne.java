package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.deck.UserDeck;
import edu.mu.item.Item;

/**
 * Represents Player One in the game. This is the character that the player will play as.
 * 
 * @version 1.0
 * 
 * @see Player
 * 
 * @author Dion Burns
 * @author Albert Zhou
 */
public class PlayerOne extends Player {
	
	/**
	 * The cards that the player has available to play during {@link edu.mu.battle.Battle}.
	 */
	private ArrayList<Card> hand;
	
	/**
	 * The player's current deck.
	 */
	private UserDeck deck;
	private int health;
	
	/**
	 * The current instance of the player.
	 */
	private static PlayerOne instance = null;

	private ArrayList<Item> battleItems;
	

	
	/**
	 * Constructs a new PlayerOne instance.
	 */
	public PlayerOne() {
		deck = new UserDeck();
		//hand = initHand();
		health = 100;
		battleItems = new ArrayList<Item>();
	}

	/**
	 * Gets the current instance of the player. If there is not a current instance,
	 * one is created instead.
	 * 
	 * @return the instance of the player
	 */
	public static PlayerOne getPlayer() {
		if(instance == null) {
			instance = new PlayerOne();
		}
		return instance;
	}

	@Override
	public Card playCard(Card card) {
		// Play the card and remove it from the current hand.
		System.out.println("Played card " + card);
		Card playedCard = card;
		removeCard(card);
		return playedCard;
		
	}

	@Override
	public void removeCard(Card card) {
		// Remove the card from the hand.
		hand.remove(card);
	}

	@Override
	public void addCardToHand(ArrayList<Card> card) {
		// Add a card from the hand into the deck.
		Card cardToAdd = card.get(0);
		hand.add(cardToAdd);
	}
	
	/**
	 * Adds a battle item to the player's current battle items.
	 * @param item The item to add
	 */
	public void addBattleItem(Item item) {
		battleItems.add(item);
	}

	@Override
	public boolean checkPlayerHealth() {
		if(health <= 0) 
			return false;
		return true;
	}
	
	/**
	 * Get the player's current health.
	 * @return The player's current health
	 */
	public int getHealth() {
		return health;
	}

	@Override
	public void damagePlayer(int num) {
		health = health - num;
	}
	
	public void addHealth(int hp) { 
		health += hp;
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
	
	/**
	 * Gets the player's current battle items.
	 * 
	 * @return The battle items of the player.
	 */
	public ArrayList<Item> getBattleItems() {
		return battleItems;
	}
}
