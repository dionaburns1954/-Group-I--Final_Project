package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.deck.UserDeck;
import edu.mu.item.Item;

/**
 * Represents Player One in the game
 * 
 * @author Dion Burns
 * @author Albert Zhou
 */
public class PlayerOne extends Player { //This is the character that you will play as
	
	/**
	 * The cards that the player has available to play during {@link edu.mu.battle.Battle}
	 */
	private ArrayList<Card> hand;
	private UserDeck deck;
	private int health;
	private static PlayerOne instance = null;

	private ArrayList<Item> battleItems;
	

	
	/**
	 * Constructs a new PlayerOne instance
	 */
	public PlayerOne() {
		deck = new UserDeck();
		//hand = initHand();
		health = 100;
		battleItems = new ArrayList<Item>();
	}

	/**
	 * Gets the current instance of the player
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
	
	/**
	 * Adds a battle item to the player's current battle items
	 * @param item The item to add
	 */
	public void addBattleItem(Item item) {
		battleItems.add(item);
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
	
	
	/**
	 * Gets the player's current battle items.
	 * 
	 * @return The battle items of the player.
	 */
	public ArrayList<Item> getBattleItems() {
		return battleItems;
	}
}
