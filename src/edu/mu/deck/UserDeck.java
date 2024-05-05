package edu.mu.deck;

import java.util.ArrayList;
import java.util.List;
import edu.mu.card.*;


public class UserDeck extends Deck {
	
	
	public UserDeck() {
		super();
		intializeCards();
	

	}
	
	private void intializeCards() {
		for(int i =1;i<=5; i++) {
			cards.add(new Card(i));
		}
	}
	
	private void resetDeck() { // initilizes deck as well as reset deck to begining deck 
		cards.clear();
		intializeCards();
	}
}
