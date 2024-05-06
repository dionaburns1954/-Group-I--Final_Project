package edu.mu.item;

import edu.mu.players.PlayerOne;

public class HealItem extends Item {
	int healthToHeal;
	
	public HealItem(String name, int price, int healthToHeal) {
		super(name, price);
		
		this.healthToHeal = healthToHeal;
	}

	@Override
	public void applyEffect() {
		PlayerOne.getPlayer().addHealth(healthToHeal);
		
	}
	
}
