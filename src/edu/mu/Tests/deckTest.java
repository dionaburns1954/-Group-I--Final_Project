package edu.mu.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.deck.EnemyDeck;
import edu.mu.deck.UserDeck;

class deckTest {

	@Test
	void testIfCardsWerePulledFromDeck() {
		
		Deck deck = new Deck();
		ArrayList<Card> pulledCards = deck.pullCardsFromDeck(80);
		assertTrue(pulledCards instanceof ArrayList<Card>);
	}
	
	@Test
	void testIfDeckWasInitCorrectly() {
		/*
		 * Checks to make sure an ArrayList of 100 cards
		 * was created
		 */
		UserDeck uDeck = new UserDeck();
		assertEquals(100, uDeck.getCards().size());
		
	}
	
	@Test
	void testIfCardWasDeleted() {
		/*
		 * Tests to make sure passed card was properly deleted from deck
		 */
		EnemyDeck eDeck = new EnemyDeck(1);
		Card card = eDeck.getCards().get(0);
		assertEquals(true, eDeck.deleteCard(card));
	}

}
