package edu.mu.item;

import edu.mu.shop.shop;

/**
 * Represents an item that resets the shop to refresh its inventory
 * 
 * @author Ryan Esparza
 * @version 1.0
 * @see Item
 */
public class ResetShopItem extends Item {
	
	private shop shopInstance; // Instance of the shop to reset
	
	/**
	 * Constructs a ResetShopItem with the specified name, price, and shop instance
	 * 
	 * @param name The name of the reset shop item
	 * @param price The price of the reset shop item
	 * @param shopInstance The instance of the shop to reset
	 */
	public ResetShopItem(String name, int price, shop shopInstance) {
		super(name, price);
		this.shopInstance = shopInstance;
	}
	
	/**
	 * Applied the effect of resetting the shop, which refreshes its inventory
	 */
	@Override
	public void applyEffect() {
		shopInstance.refreshShop();
	}

}
