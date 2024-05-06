package edu.mu.deck;

import java.util.ArrayList;
import java.util.Random;

import edu.mu.card.Card;

/**
 * Represents an enemy deck in the game, containing cards used by opponent
 * 
 * @author Logan Bird
 * @author Dion Burns
 */
public class EnemyDeck extends Deck {
	/**
	 * Constructs an EnemyDeck object with the specified level
	 * 
	 * @param level The level of the enemy deck
	 */
	public EnemyDeck(int level) {
	
	deck = new ArrayList<Card>();
		initializeDeck(level);
	}
	
	/**
	 * Initializes the deck based on the specified level
	 * 
	 * @param level The level of the enemy deck
	 */
	protected void initializeDeck(int level) {
		if ( level == 1) {
			Deck_1();
			
		}else if (level == 2) {
			Deck_2();
			
		} else if (level == 3) {
			Deck_3();
			
		}else if (level == 4) {
			Deck_4();
			
		}else if (level == 5) {
			Deck_5();
			
		}else {
			Deck_above5(level);
			
		}
	}
	
	/**
	 * Adds cards to the deck for level 1
	 */
	private void Deck_1() {
		createDeck(0, 20);
	}
	/**
	 * Adds cards to the deck for level 2
	 */
	private void Deck_2() {
		createDeck(20, 40);
	}
	/**
	 * Adds cards to the deck for level 3
	 */
	private void Deck_3() {
		createDeck(40, 60);
	}
	/**
	 * Adds cards to the deck for level 4
	 */
	private void Deck_4() {
		createDeck(60, 80);
	}
	/**
	 * Adds cards to the deck for level 5
	 */
	private void Deck_5() {
		createDeck(60, 80);
	}
	/**
	 * Adds cards to the deck for levels above 5
	 * 
	 * @param level The level of the enemy decks
	 */
	private void Deck_above5(int level) {
		Deck_5();
		for(Card card : deck) {
			card.setValue(card.getValue()+level );
		}
	}
	
	/**
	 * Creates a deck of cards with values between the specified range
	 * 
	 * @param min The minimum value of the cards
	 * @param max The maximum value of the cards
	 * @return True of the deck was successfully created, false otherwise
	 */
	private boolean createDeck(int min, int max) {
		ArrayList<Card> deck = new ArrayList<Card>();
		Random rand = new Random();
		for(int i = 0; i < deckSize; i++) { //creates a temp deck
			deck.add(new Card(rand.nextInt(max - min) + min));
		}
		
		if(deck.size() <= 0) return false;
		
		for(int i = 0; i < deck.size(); i++) { //copies cards from temp deck to real deck
			(this.deck).add(deck.get(i));
		}
		if((this.deck).size() <= 0) return false;
		
		return true;
	}
}
