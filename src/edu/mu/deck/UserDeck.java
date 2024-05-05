package edu.mu.deck;

import java.util.ArrayList;
import java.util.List;
import edu.mu.card.*;


public class UserDeck extends Deck {
	private List<Card> initialCards;
	
	public UserDeck() {
		super();
		initialCards = new ArrayList<>();
		Int_intCards();
		resetDeck();

	}
	
	private void Int_intCards() {
		initialCards.add(new Card(1));
		initialCards.add(new Card(2));
		initialCards.add(new Card(3));
		initialCards.add(new Card(4));
		initialCards.add(new Card(5));
	}
	
	private void resetDeck() { // initilizes deck as well as reset deck to begining deck 
		clearDeck();
		
		for (Card card : initialCards) {
			addCard(card);
		}
	}
	public void addCardToDeck(Card card) {
		addCard(card);
	}
	
	public void deleteCardFromDeck(Card card) {
		deleteCard(card);
	}
	
	// maybe add shuffle 
}
