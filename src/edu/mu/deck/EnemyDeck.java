package edu.mu.deck;

import java.util.ArrayList;
import java.util.Random;

import edu.mu.card.Card;

public class EnemyDeck extends Deck {
	
	public EnemyDeck(int level) {
	
	//super();
	deck = new ArrayList<Card>();
	initializeDeck(level);
	}
	
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
	
	private void Deck_1() {
		deck.add(new Card(1));
		// add whatever in deck 1
		createDeck(0, 20);
	}
	private void Deck_2() {
		//deck.add(new Card(1));
		// add whatever in deck 1 
		createDeck(20, 40);
	}
	private void Deck_3() {
		//deck.add(new Card(1));
		// add whatever in deck 1 
		createDeck(40, 60);
	}
	private void Deck_4() {
		//deck.add(new Card(1));
		// add whatever in deck 1
		createDeck(60, 80);
	}
	private void Deck_5() {
		//deck.add(new Card(1));
		// add whatever in deck 1
		createDeck(60, 80);
	}
	private void Deck_above5(int level) {
		Deck_5();
		for(Card card : deck) {
			card.setValue(card.getValue()+level );
		}
		// add whatever in deck 1 
	}
	
	private boolean createDeck(int min, int max) {
		ArrayList<Card> deck = new ArrayList<Card>();
		Random rand = new Random();
		for(int i = 0; i < 100; i++) { //creates a temp deck
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
