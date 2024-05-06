package edu.mu.item;

import edu.mu.players.PlayerTwo;

public class PeekCardItem extends Item {

	PlayerTwo enemy;
	
	public PeekCardItem(String name, int price, PlayerTwo enemy) {
		super(name, price);
		// TODO Auto-generated constructor stub
		this.enemy = enemy;
	}

	@Override
	public void applyEffect() {
		System.out.println("Enemy's first card: " + enemy.getHand().getFirst().getValue());
		
	}
	
}
