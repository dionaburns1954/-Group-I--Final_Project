package edu.mu.item;

import java.util.Random;

import edu.mu.players.PlayerOne;
import edu.mu.shop.Shop;

/**
 * A factory for creating both battle items and normal items.
 * 
 * @version 1.0
 * 
 * @see Item
 * 
 * @author Albert Zhou
 * @author Logan Bird
 */
public class ItemFactory {
	
	/**
	 * Creates an item of the specified type.
	 * @param itemType The type of item to create.
	 * @return The item created.
	 */
	public Item getItem(ItemType itemType) {
		Item item = null;
		
		// Determine what type of item needs to be created and assign it to item
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
		case HEAL:
			int hp = getRandomHPValue();
			item = new HealItem("Heal " + hp + " HP", hp);
			break;
		case PEEK_CARD:
			item = new PeekCardItem("Peek the enemy's first card", 10);
			break;
		case SWAP_CARD:
			item = new SwapCardItem("Swap a card with the enemy", 30);
			break;
		default:
			break;
		}
		
		return item;
	}
	
	/**
	 * Generates a random single card item.
	 * 
	 * @return A random single card item
	 */
	private Item getRandomSingleCard() { 
		// Generate a random value between 1 and 10
		int value = getSingleCardValue(); 
		return new SingleCard("Card " + value, value / 2, new int[] {value}) ;
	}
	
	/**
	 * Generates a random HP value for the HealItem item.
	 * 
	 * @see HealItem
	 * 
	 * @return The HP to restore.
	 */
	private int getRandomHPValue() {
		Random rand = new Random();
		
		int hp = rand.nextInt(101 - 20) + 20;
		
		return hp;
	}
	
	/**
	 * Generates a random value for a single card.
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
