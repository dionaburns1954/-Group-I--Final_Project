package edu.mu.deck;

import java.util.ArrayList;
import java.util.List;
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
		//initialize_Deck();
	

	}
	
	/**
	 * Initializes the user's deck with default cards
	 */
	private void initialize_Deck() {
		for(int i =1;i<=5; i++) {
			deck.add(new Card(i));
		}
	}
	
	/**
	 * Resets the deck by clearing it and initializing it again with default cards
	 */
	private void resetDeck() { // Initializes deck as well as reset deck to begining deck 
		deck.clear();
		deck = initDeck();
	}
}
