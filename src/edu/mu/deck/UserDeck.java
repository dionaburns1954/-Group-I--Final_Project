package edu.mu.deck;

import java.util.ArrayList;
import java.util.List;
import edu.mu.card.*;


public class UserDeck extends Deck {
	
	
	public UserDeck() {
		super();
		//initialize_Deck();
	

	}
	
	private void initialize_Deck() {
		for(int i =1;i<=5; i++) {
			deck.add(new Card(i));
		}
	}
	
	private void resetDeck() { // Initializes deck as well as reset deck to begining deck 
		deck.clear();
		//deck = initDeck(); figure out what to do with this
	}
}
