package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;

/**
 * Abstract class representing a player in the game.
 * Defines methods for playing/removing cards, adding cards to hand, initializing hand, checking player health, and damaging player.
 * 
 * @author Dion Burns
 */
public abstract class Player {
	/**
	 * Plays the specified card.
	 * 
	 * @param card The card to play
	 */
	public abstract Card playCard(Card card);
	
	/**
	 * Removes the specified card from the player's hand
	 * 
	 * @param card The card to remove
	 */
	public abstract void removeCard(Card card);
	
	/**
	 * Adds the specified cards to the player's hand.
	 * 
	 * @param card The cards to add
	 */
	public abstract void addCardToHand(ArrayList<Card> card);
	
	/**
	 * Checks if the player's health is above zero.
	 * 
	 * @return True if the player's health is above zero, false otherwise
	 */
	public abstract boolean checkPlayerHealth();
	
	/**
	 * Damages the player by the specified amount.
	 * 
	 * @param num The amount of damage to inflict
	 */
	public abstract void damagePlayer(int num);
}
