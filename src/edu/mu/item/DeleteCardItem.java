package edu.mu.item;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import edu.mu.deck.Deck;
import edu.mu.card.Card;

/**
 * {@link Item} that allows the player to delete a card from their deck.
 * 
 * @version 1.0
 * @see Item
 * @author Ryan Esparza
 */
public class DeleteCardItem extends Item{
	/**
	 * The player's deck.
	 * 
	 * @see edu.mu.players.PlayerOne#deck
	 */
	private Deck deck;
	
	/**
	 * Parameterized constructor for the item.
	 * 
	 * @param name The name of the delete card item
	 * @param price The price of the delete card item
	 * @param deck The player's deck
	 */
	public DeleteCardItem(String name, int price, Deck deck) {
		super(name, price);
		this.deck = deck;
	}
	
	/**
	 * Applies the effect of the delete card item by allowing the player to choose a card from their deck to delete.
	 * The player selects a card by its index in the deck, and it is removed if a valid choice is made.<p>
	 * 
	 * Prints a message indicating the success or failure of the operation.
	 */
	@Override
	public void applyEffect() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the card you want to delete:");
		
		// Get the cards from the deck
		ArrayList<Card> cards = deck.getCards();
		
		// Display all of the cards and their values
		for (int i = 0; i < cards.size(); i++) {
			System.out.println((i + 1) + ". " + cards.get(i).getValue());
		}
		
		int choice = scanner.nextInt();
		
		if (choice >= 1 && choice <= cards.size()) {
			deck.deleteCard(cards.get(choice - 1)); // Delete the card
		} else {
			System.out.println("Invalid choice. No card was deleted");
		}
		
		// Replace the deleted card with a new one
		Random rand = new Random();
		deck.addCard(new Card(rand.nextInt(99) + 1));
	}

}
