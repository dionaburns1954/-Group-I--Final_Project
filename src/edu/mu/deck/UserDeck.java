package edu.mu.deck;

import edu.mu.card.*;

/**
 * Represents the user's deck in the game, containing of cards available to the player
 * 
 * @author Logan Bird
 * @author Dion Burns
 */
public class UserDeck extends Deck {
	
	/**
	 * Constructs a UserDeck object
	 */
	public UserDeck() {
		super();
	}
	
	/**
	 * Resets the deck by clearing it and initializing it again with default cards
	 */
	private void resetDeck() { // Initializes deck as well as reset deck to beginning deck 
		deck.clear();
		deck = initDeck();
	}
}
