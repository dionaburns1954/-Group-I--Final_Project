package edu.mu.deck;

import edu.mu.card.Card;

public class EnemyDeck extends Deck {
	
	public EnemyDeck(int level) {
	
	super();
	initializeDeck(level);
	}
	
	private void initializeDeck(int level) {
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
		cards.add(new Card(1));
		// add whatever in deck 1 
	}
	private void Deck_2() {
		cards.add(new Card(1));
		// add whatever in deck 1 
	}
	private void Deck_3() {
		cards.add(new Card(1));
		// add whatever in deck 1 
	}
	private void Deck_4() {
		cards.add(new Card(1));
		// add whatever in deck 1 
	}
	private void Deck_5() {
		cards.add(new Card(1));
		// add whatever in deck 1 
	}
	private void Deck_above5(int level) {
		Deck_5();
		for(Card card : cards) {
			card.setValue(card.getValue()+level );
		}
		// add whatever in deck 1 
	}
}
