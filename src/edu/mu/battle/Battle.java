package edu.mu.battle;

import java.util.ArrayList;
import java.util.Random;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.item.Item;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

/**
 * 
 * 
 * @author Albert Zhou
 * @version 1.0
 * 
 * @see GameManager
 */
public class Battle {
	private PlayerOne player;
	private PlayerTwo enemy;
	
	// TODO: Shuffle deck
	private void shuffleDeck(Deck deck) {
		Random rand = new Random();
		Card heldCard;
		
		ArrayList<Card> cards = deck.getCards();
		for(int i = cards.size() - 1; i > 1; i--) {
			heldCard = cards.get(i);
			int randCardIndex = rand.nextInt(i - 1);
			
			cards.set(i, cards.get(randCardIndex));
			cards.set(randCardIndex,  heldCard);
		} // I don't even know if this works. Theoretically it should get the reference to the Deck's cards list.
	}
	
	// TODO: Play item (Potentially remove this)
	private void playItem(Item item) {
		
	}

	// TODO: Duel
	public boolean startBattle() {
		
		
		
		return true;
	}
	
	// TODO: Health
	
	// TODO: Discard pile
	

	
}
