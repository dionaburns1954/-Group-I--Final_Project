
package edu.mu.deck;
import java.util.ArrayList;
import java.util.Random;

import edu.mu.card.Card;

/**
 * Represents a deck of cards in the game.
 * 
 * @author Ryan Esparza
 * @author Logan Bird
 * @author Dion Burns
 * @author Albert Zhou
 */
public class Deck {
	
	/**
	 * A list of cards comprising the deck.
	 */
	protected ArrayList<Card> deck;
	
	/**
	 * The initial size of the deck.
	 */
	protected final int deckSize = 100;
	
	/**
	 * Constructs a new Deck instance and initializes it with the cards.
	 */
	public Deck() {
		this.deck = initDeck();
	}
	
	/**
	 * Initializes the deck with cards.
	 * 
	 * @return The initialized deck
	 */
	protected ArrayList<Card> initDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		
		// Generate 100 random cards, each with a value of 1-99
		for(int i = 0; i < deckSize; i++) {
			Random rand = new Random();
			Card card = new Card(rand.nextInt(99) + 1);
			
			// Add the card to the deck
			deck.add(card);
		}
		return deck;
 	}
	
	/**
	 * Deletes a given card from the deck.
	 * 
	 * @param card The card to be deleted
	 * @return True if the card is successfully removed, false otherwise
	 */
	public boolean deleteCard(Card card) {
		try {
			deck.remove(card);
			
			// Check if the deck contains the card
			for(int i = 0; i < deck.size(); i++) {
				if(deck.get(i) == card)
					return false;
			}
			return true;
		} catch(Exception e) {
			System.out.println("ERROR! Could delete Card from deck!");
			return false;
		}
	}
	
	/**
	 * Shuffles the cards
	 * 
	 * Iterates backwards through the deck, and replaces the card at the current position with a card randomly
	 * selected from the remaining cards that have not been shuffled.
	 */
	public void shuffleDeck() {
		Random rand = new Random();
		Card heldCard;
		
		for(int i = deck.size() - 1; i > 1; i--) {
			// Get the current card and store it
			heldCard = deck.get(i);
			// Get a random card from the cards that have not been shuffled
			int randCardIndex = rand.nextInt(i - 1);
			
			// Set the current card index with the random card
			deck.set(i, deck.get(randCardIndex));
			// Set the current card as the random card
			deck.set(randCardIndex,  heldCard);
		} 
	}
	/**
	 * Pulls a specified number of cards from the deck.
	 * 
	 * @param num The number of cards to pull
	 * @return The pulled cards
	 */
	public  ArrayList<Card> pullCardsFromDeck(int num) {
		try {
			
			ArrayList<Card> returnCards = new ArrayList<Card>(); 
		
			int deckIndex = 0;
			for(int i = 0; i < num; i++) {
				// Take the first card from the deck and add it to returnCards
				returnCards.add(deck.get(deckIndex)); 
				deleteCard(deck.get(deckIndex)); // Remove the card
			}
		
			// Replace the cards that were removed from the deck with new cards
			Random rand = new Random();
			for(int i = 0; i < num; i++) {
				// Generate a value between 1 and 99
				int value = rand.nextInt(99) + 1;
				Card card = new Card(value);
				deck.add(card);
			}
				return returnCards;
		} catch(Exception e) {
			System.out.println("ERROR! could not pull cards!");
			return null;
		}
	}
	
	/**
	 * Retrieves all cards in the deck.
	 * 
	 * @return The list of cards in the deck
	 */
	public ArrayList<Card> getCards() { return this.deck; }
	
	/**
	 * Adds a card to the deck.
	 * 
	 * @param card The card to be added
	 */
	public void addCard(Card card) {
		deck.add(card);
	}
}
