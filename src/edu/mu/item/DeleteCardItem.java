package edu.mu.item;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import edu.mu.deck.Deck;
import edu.mu.card.Card;

/**
 * Class that allows the player to delete a card from their deck
 * 
 * @author Ryan Esparza
 * @version 1.0
 */

public class DeleteCardItem extends Item{
	private Deck deck;
	//private Scanner scanner;
	
	/**
	 * 
	 * @param name The name of the delete card item
	 * @param price The price of the delete card item
	 * @param deck The player's deck
	 */
	public DeleteCardItem(String name, int price, Deck deck) {
		super(name, price);
		this.deck = deck;
		//this.scanner = scanner;
	}
	
	/**
	 * Applies the effect of the delete card item by allowing the player to choose a card from their deck to delete
	 * The player selects a card by its index in the deck, and it is removed if a valid choice is made
	 * 
	 * @message A message indicating the success or failure of the operation
	 */
	@Override
	public void applyEffect() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Select the card you want to delete:");
			
			ArrayList<Card> cards = deck.getCards();
			for (int i = 0; i < cards.size(); i++) {
				System.out.println((i + 1) + ". " + cards.get(i).getValue());
			}
			
			int choice = scanner.nextInt();
			if ((choice >= 1) && (choice <= cards.size())) {
				deck.deleteCard(cards.get(choice - 1));
			} else {
				System.out.println("Invalid choice. No card was deleted");
			}
		}
		//replace deleted card with new one
		Random rand = new Random();
		deck.addCard(new Card(rand.nextInt(99) + 1));
		//scanner.close();
	}

}
