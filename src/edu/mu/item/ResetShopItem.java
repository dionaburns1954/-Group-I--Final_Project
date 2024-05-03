package edu.mu.item;

import edu.mu.shop.shop;

public class ResetShopItem extends Item {
	
	private shop shopInstance;
	
	public ResetShopItem(String name, int price, shop shopInstance) {
		super(name, price);
		this.shopInstance = shopInstance;
	}
	
	@Override
	public void applyEffect() {
		shopInstance.refreshShop();
	}

}
