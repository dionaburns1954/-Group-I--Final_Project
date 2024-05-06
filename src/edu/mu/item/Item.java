package edu.mu.item;

/**
 * Represents an abstract item in the game that can be used by players
 * Items have a name and a price, and provide an abstract method for applying their effects
 * 
 * @author Ryan Esparza
 * @version 1.0
 */
public abstract class Item {
	
	private String name; 
	private int price; 
	
	/**
	 * Constructs an Item object with the specified name and price
	 * @param name The name of the item
	 * @param price the price of the item
	 */
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Retrieves the name of the item
	 * 
	 * @return The name of the item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Retrieves the price of the item
	 * 
	 * @return The price of the item
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Applies the effect of the item
	 */
	public abstract void applyEffect();
}
