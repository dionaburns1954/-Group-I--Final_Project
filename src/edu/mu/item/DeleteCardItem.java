package edu.mu.item;

import edu.mu.deck.Deck;

public class DeleteCardItem extends Item{
	private Deck deck;
	public DeleteCardItem(String name, int price, Deck deck) {
		super(name, price);
		this.deck = deck;
	}
	
	@Override
	public void applyEffect() {
		deck.deleteCard(null);
	}

}
