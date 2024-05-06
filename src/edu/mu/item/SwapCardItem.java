package edu.mu.item;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.mu.battle.Battle;
import edu.mu.card.Card;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

public class SwapCardItem extends Item {

	private PlayerTwo enemy = PlayerTwo.getPlayer();
	
	public SwapCardItem(String name, int price) {
		super(name, price);
	}
	
	@Override
	public void applyEffect() {
		Scanner scanner = Battle.battleScanner;
		ArrayList<Card> playerHand = PlayerOne.getPlayer().getHand();

		Random rand = new Random();
		
		System.out.println("Select the card you want to swap: ");
		
		int i = 0;
		for(Card card : playerHand) {
			i++;
			System.out.println(i + ". " + card.getValue());
		}
			
		boolean isSelectingCard = true;
		while(isSelectingCard) {
			int chosenCardIndex = scanner.nextInt();
			
			if (chosenCardIndex > 0 && chosenCardIndex <= i) {
				int swappedCardIndex = rand.nextInt(enemy.getHand().size() - 1);
				
				chosenCardIndex -= 1;
				Card heldCard = enemy.getHand().get(swappedCardIndex);
				Card playerCard = playerHand.get(chosenCardIndex);
				
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
