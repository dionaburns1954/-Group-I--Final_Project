package edu.mu.item;

import java.util.Random;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.gamemanager.GameManager;

/**
 * Represents an item that adds a single card to the player's deck when applied
 * 
 * @author Ryan Esparza
 * @version 1.0
 * @see Item
 */
public class SingleCard extends Item {
    private int[] possibleValues;
    private int currentValue;

    /**
     * Constructs a SingleCard with the specified name, price, and possible card values
     * 
     * @param name The name of the single card item
     * @param price The price of the single card item
     * @param possibleValues An array of possible values for the card
     */
    public SingleCard(String name, int price, int[] possibleValues) {
        super(name, price);
        this.possibleValues = possibleValues;
    }

    /**
     * Applies the effect of adding a single card to the player's deck
     * If the card's value is not assigned, it randomly selects a value from the possible values
     */
    @Override
    public void applyEffect() {
    	if (currentValue == 0) { // Check if card value is not assigned
            currentValue = getRandomValueFromPossibleValues();
        }
    	// Add the card to the player's deck
    	GameManager.getInstance().getPlayerDeck().addCard(new Card(currentValue));
    }
    
    /**
     * Generates a random value for the card from the possible values
     * 
     * @return A random value for the card
     */
    private int getRandomValueFromPossibleValues() {
    	Random random = new Random();
    	int index = random.nextInt(possibleValues.length);
    	return possibleValues[index];
    }

    /**
     * Gets the current value of the card
     * 
     * @return The current value of the card
     */
    public int getCurrentValue() {
        return currentValue;
    }

    // Getter for card name
    public String getName() {
        return super.getName();
    }

    // Getter for card value
    public int getValue() {
        return currentValue;
    }
    
    /**
     * Resets the current value of the card to 0
     */
    public void resetValue() {
    	currentValue = 0;
    }

    /**
     * Sets the current value of the card
     * 
     * @param value The value to set
     */
    public void setCurrentValue(int value) {
        this.currentValue = value;
    }

    /**
     * Creates a duplicate of the SingleCard with the same attributes
     * 
     * @return A duplicate SingleCard instance
     */
    public SingleCard duplicate() {
        // Create a new SingleCard with the same attributes
        SingleCard duplicateCard = new SingleCard(this.getName(), this.getPrice(), this.possibleValues);
        duplicateCard.setCurrentValue(this.getCurrentValue());
        return duplicateCard;
    }
}
