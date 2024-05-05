
package edu.mu.deck;
import java.util.ArrayList;
import java.util.Random;

import edu.mu.card.Card;

public class Deck {
	
	ArrayList<Card> deck;
	
	public Deck() {
		this.deck = initDeck();
	}
	
	protected ArrayList<Card> initDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		final int deckSize = 40;
		for(int i = 0; i < deckSize; i++) {
			Random rand = new Random();
			Card card = new Card(rand.nextInt(99) + 1);
			deck.add(card);
		}
		
		if(deck.size() == 0)
			return null;
		
		return deck;
 	}
	
	public boolean deleteCard(Card card) {
		deck.remove(card);
		for(int i = 0; i < deck.size(); i++) {
			if(deck.get(i) == card)
				return false;
		}
		return true;
	}
	
	//private ArrayList<Card> cards;
	
	/*
	 * public void deleteCard(Card card) { cards.remove(card);
	 * System.out.println("Card deleted from deck."); }
	 */
	public  ArrayList<Card> pullCardsFromDeck(int num) {
		/*
		 * function takes in a num of cards representing
		 * how many cards to pull from top of deck.
		 * Method pulls num of cards from top of deck and deletes them
		 * from arraylist. Method returns truee if successful, false if unsuccessful
		 */
		ArrayList<Card> returnCards = new ArrayList<Card>(); 
		int deckIndex = 0;
		for(int i = 0; i < num; i++) {
			returnCards.add(deck.get(deckIndex)); //pops first card off deck and adds it to returnDeck
			deleteCardFromDeck(deck.get(deckIndex)); //removes popped card from deck
		}
		
		return returnCards;
	}
	
	private boolean deleteCardFromDeck(Card card) {
		//removes a certain card from the deck
		//card that is to be removed are ones that have been pulled
		//method returns true if card was successfully removed from deck, else returns false
		deck.remove(card);
		for(int i = 0; i < deck.size(); i++) {
			if(deck.get(i) == card)
					return false;
		}
		
		return true;
	}
	
	
	public ArrayList<Card> getCards() { return this.deck; }
}
