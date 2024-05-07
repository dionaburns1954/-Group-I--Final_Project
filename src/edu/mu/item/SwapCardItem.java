package edu.mu.item;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.mu.battle.Battle;
import edu.mu.card.Card;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

/**
 * An item allowing the player to swap a card in their hand with a random card from the enemy's deck.
 * 
 * @version 1.0
 * 
 * @see Item
 * 
 * @author Albert Zhou
 */
public class SwapCardItem extends Item {
	// Get the current PlayerTwo instance
	private PlayerTwo enemy = PlayerTwo.getPlayer();
	
	/**
	 * Parameterized constructor to generate an item with the given name and price.
	 * @param name The name of the card
	 * @param price The price of the card
	 */
	public SwapCardItem(String name, int price) {
		super(name, price);
	}
	
	@Override
	public void applyEffect() {
		// Get the currentBattleScanner
		Scanner scanner = Battle.battleScanner;
		ArrayList<Card> playerHand = PlayerOne.getPlayer().getHand();

		Random rand = new Random();
		
		System.out.println("Select the card you want to swap: ");
		
		// Display the player's current hand
		int i = 0;
		for(Card card : playerHand) {
			i++;
			System.out.println(i + ". " + card.getValue());
		}
		
		// Loop until the player selects a valid card to remove
		boolean isSelectingCard = true;
		while(isSelectingCard) {
			int chosenCardIndex = scanner.nextInt();
			
			// If the input is valid, swap the cards
			if (chosenCardIndex > 0 && chosenCardIndex <= i) {
				// Get a random index in the enemy's hand
				int swappedCardIndex = rand.nextInt(enemy.getHand().size() - 1);
				
				chosenCardIndex -= 1;
				
				// Store the cards
				Card heldCard = enemy.getHand().get(swappedCardIndex);
				Card playerCard = playerHand.get(chosenCardIndex);
				
				// Swap the cards
				enemy.getHand().set(swappedCardIndex, playerCard);
				playerHand.set(chosenCardIndex, heldCard);
				
				System.out.println("You swapped your card of value " + playerCard.getValue() + ".");
				System.out.println("You recieved a card of value " + heldCard.getValue() + " from the enemy's hand.");
				isSelectingCard = false;
				break;
				
			} else {
				System.out.println("Please select a card to swap.");
			}
		}
	}
}
