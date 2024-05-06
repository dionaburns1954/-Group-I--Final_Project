package edu.mu.item;

import java.util.Random;

import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;
import edu.mu.shop.Shop;

public class ItemFactory {
	
	public Item getItem(ItemType itemType) {
		Item item = null;
		
		switch(itemType) {
		case DELETE:
			item = new DeleteCardItem("Delete Card", 10, PlayerOne.getPlayer().getDeck());
			break;
		case GET_SINGLE_CARD:
			item = getRandomSingleCard();
			break;
		case RESET_SHOP:
			item = new ResetShopItem("Reset Shop", 6, Shop.getInstance());
			break;
		}
		
		return item;
	}
	
	public Item getBattleItem(ItemType itemType, PlayerTwo enemy) {
		Item item = null;
			
		return item;
	}
	
	/**
	 * Generates a random single card item
	 * 
	 * @return A random single card item
	 */
	private Item getRandomSingleCard() { 
		
		int value = getSingleCardValue(); // generate random value between 1 and 10 
		return new SingleCard("Card " + value, value/2, new int[] {value}) ;
	}
	
	/**
	 * Generates a random value for a single card
	 * 
	 * @return A random value for a single card
	 */
	private int getSingleCardValue() {
		Random random = new Random ();
		int ra = random.nextInt(100);
		
		if (ra < 70) {
			return random.nextInt(20)+1;
		} else if (ra < 90) {
			return random.nextInt(20)+50;
		} else {
			return random.nextInt(20)+80;
		}
	}
}
