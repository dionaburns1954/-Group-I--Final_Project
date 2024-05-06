
package edu.mu.deck;
import java.util.ArrayList;
import java.util.Random;

import edu.mu.card.Card;

/**
 * Represents a deck of cards in the game
 * 
 * @author Ryan Esparza
 * @author Logan Bird
 * @author Dion Burns
 * @author Albert Zhou
 */
public class Deck {
	
	protected ArrayList<Card> deck;
	protected final int deckSize = 100;
	
	/**
	 * Constructs a new Deck instance and initializes it with the cards
	 */
	public Deck() {
		this.deck = initDeck();
	}
	
	/**
	 * Initializes the deck with cards
	 * 
	 * @return The initialized deck
	 */
	protected ArrayList<Card> initDeck() {
		ArrayList<Card> deck = new ArrayList<Card>();
		//final int deckSize = 20;
		for(int i = 0; i < deckSize; i++) {
			Random rand = new Random();
			Card card = new Card(rand.nextInt(99) + 1);
			deck.add(card);
		}
		
		if(deck.size() == 0)
			return deck;
		
		return deck;
 	}
	
	/**
	 * Deletes a card from the deck
	 * 
	 * @param card The card to be deleted
	 * @return True if the card is successfully removed, false otherwise
	 */
	public boolean deleteCard(Card card) {
		try {
			deck.remove(card);
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
			heldCard = deck.get(i);
			int randCardIndex = rand.nextInt(i - 1);
			
			deck.set(i, deck.get(randCardIndex));
			deck.set(randCardIndex,  heldCard);
		} 
	}
	/**
	 * Pulls a specified number of cards from the deck
	 * 
	 * @param num The number of cards to pull
	 * @return The pulled cards
	 */
	public  ArrayList<Card> pullCardsFromDeck(int num) {
		try {
			
			ArrayList<Card> returnCards = new ArrayList<Card>(); 
		
			int deckIndex = 0;
			for(int i = 0; i < num; i++) {
				returnCards.add(deck.get(deckIndex)); //pops first card off deck and adds it to returnDeck
				deleteCard(deck.get(deckIndex)); //removes popped card from deck
			}
		
			//replace cards that were pulled with new ones
			Random rand = new Random();
			for(int i = 0; i < num; i++) {
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
	 * Retrieves all cards in the deck
	 * 
	 * @return The list of cards in the deck
	 */
	public ArrayList<Card> getCards() { return this.deck; }
	
	/**
	 * Adds a card to the deck
	 * 
	 * 
	 * @param card The card to be added
	 */
	public void addCard(Card card) {
		deck.add(card);
	}
}
