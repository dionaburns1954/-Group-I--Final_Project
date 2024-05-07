package edu.mu.item;

import edu.mu.players.PlayerTwo;

/**
 * An item that allows the player to peek at the enemy's first card.
 * 
 * @version 1.0
 *
 * @see Item
 * 
 * @author Albert Zhou
 */
public class PeekCardItem extends Item {

	private PlayerTwo enemy;
	
	/**
	 * Parameterized constructor to create the item.
	 * @param name The name of the card
	 * @param price The price of the card
	 */
	public PeekCardItem(String name, int price) {
		super(name, price);
		this.enemy = PlayerTwo.getPlayer();
	}

	@Override
	public void applyEffect() {
		// Display the enemy's first card in their hand.
		System.out.println("Enemy's first card: " + enemy.getHand().getFirst().getValue());
		
	}
	
}
