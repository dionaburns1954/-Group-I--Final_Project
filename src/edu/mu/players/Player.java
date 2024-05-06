package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;

/**
 * Abstract class representing a player in the game
 * Defines methods for playing/removing cards, adding cards to hand, initializing hand, checking player health, and damaging player
 * 
 * @author Dion Burns
 */
public abstract class Player {

	//ArrayList<Card> hand;
	
	/**
	 * Plays the specified card
	 * 
	 * @param card The card to play
	 */
	public abstract Card playCard(Card card);
	/**
	 * Removes the specified card from the player's hand
	 * 
	 * @param card The card to remove
	 */
	public abstract void removeCard(Card card); //might change later
	
	/**
	 * Adds the specified cards to the player's hand
	 * 
	 * @param card The cards to add
	 */
	public abstract void addCardToHand(ArrayList<Card> card);
	
	/**
	 * Initializes the player's hand
	 * 
	 * @return The initialized hand
	 */
	public abstract ArrayList<Card> initHand();
	
	/**
	 * Checks if the player's health is above zero
	 * 
	 * @return True if the player's health is above zero, false otherwise
	 */
	public abstract boolean checkPlayerHealth();
	
	/**
	 * Damages the player by the specified amount
	 * 
	 * @param num The amount of damage to inflict
	 */
	public abstract void damagePlayer(int num);
	
}
