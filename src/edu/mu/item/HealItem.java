package edu.mu.item;

import edu.mu.players.PlayerOne;

/**
 * {@link Item} that allows the player to delete a card from their deck.
 * 
 * @version 1.0
 * 
 * @see Item
 * 
 * @author Albert Zhou
 */
public class HealItem extends Item {
	private int healthToHeal;
	
	/**
	 * Parameterized constructor for creating the HealItem
	 * 
	 * @param name The name of the card
	 * @param healthToHeal The amount of health to heal
	 */
	public HealItem(String name, int healthToHeal) {
		super(name, calculateCost(healthToHeal));
		
		this.healthToHeal = healthToHeal;
	}

	@Override
	public void applyEffect() {
		// Add the health to the player's current HP
		PlayerOne.getPlayer().addHealth(healthToHeal);
		System.out.println("You healed " + healthToHeal + " HP. You have " + PlayerOne.getPlayer().getHealth() + " HP.");
	}
	
	/**
	 * Calculates the cost of the card, using the formula 1.5^(x/10) + 15
	 * 
	 * @param healthToHeal
	 * @return the cost of the card
	 */
	private static int calculateCost(int healthToHeal) {
		return (int) Math.round(Math.pow(1.5, healthToHeal / 10) + 15);
	}
}
