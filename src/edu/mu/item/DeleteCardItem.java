package edu.mu.item;
import java.util.ArrayList;
import java.util.Scanner;
import edu.mu.deck.Deck;
import edu.mu.card.Card;

public class DeleteCardItem extends Item{
	private Deck deck;
	public DeleteCardItem(String name, int price, Deck deck) {
		super(name, price);
		this.deck = deck;
	}
	
	@Override
	public void applyEffect() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the card you want to delete:");
		
		ArrayList<Card> cards = deck.getCards();
		for (int i = 0; i < cards.size(); i++) {
			System.out.println((i + 1) + ". " + cards.get(i));
		}
		int choice = scanner.nextInt();
		if (choice >= 1 && choice <= cards.size()) {
			deck.deleteCard(cards.get(choice - 1));
		} else {
			System.out.println("Invalid choice. No card was deleted");
		}
		scanner.close();
	}

}
