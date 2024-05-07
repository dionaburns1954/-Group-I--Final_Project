package edu.mu.card;

/**
 * Represents a playing card in the game
 * 
 * @author Logan Bird
 * @author Dion Burns
 */
public class Card { 
	
	private int value;
	
	/**
	 * Default constructor. Constructs a new Card instance with a default value of 1
	 */
	public Card() {
		this.value = 1;
	}
	
	/**
	 * Constructs a new Card instance with the given value
	 * 
	 * @param value The value of the card
	 */
	public Card(int value) {
		this.value = value;
	}
	
	/**
	 * Sets the value of the card
	 * 
	 * @param value The value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Gets the value of the card
	 * 
	 * @return The value of the card
	 */
	public int getValue() {
		return value;
	}
}
