
package edu.mu.deck;
import java.util.ArrayList;
import edu.mu.card.Card;

public class Deck {
	
	ArrayList<Card> deck;
	
	public Deck() {
		this.deck = new ArrayList<Card>();
	}
	
	public boolean pullCardsFromDeck(int num) {
		/*
		 * function takes in a num of cards representing
		 * how many cards to pull from top of deck.
		 * Method pulls num of cards from top of deck and deletes them
		 * from arraylist. Method returns truee if successful, false if unsuccessful
		 */
		
		return false;
	}
	
	private boolean deleteCardFromDeck(Card card) {
		//removes a certain card from the deck
		//card that is to be removed are ones that have been pulled
		//method returns true if card was successfully removed from deck, else returns false
		
		return false;
	}
	
	public boolean shuffleDeck() {
		//shuffles deck of cards before playing
		//if deck is shuffled correctly, return true, else return false
		
		return false; 
	}
	
}
