package edu.mu.item;

import edu.mu.players.PlayerOne;

public class HealItem extends Item {
	int healthToHeal;
	
	public HealItem(String name, int healthToHeal) {
		super(name, calculateCost(healthToHeal));
		
		this.healthToHeal = healthToHeal;
	}

	@Override
	public void applyEffect() {
		PlayerOne.getPlayer().addHealth(healthToHeal);
		System.out.println("You healed " + healthToHeal + " HP. You have " + PlayerOne.getPlayer().getHealth() + " HP.");
	}
	
	private static int calculateCost(int healthToHeal) {
		return (int) Math.round(Math.pow(1.5, healthToHeal / 10) + 15);
	}
}
