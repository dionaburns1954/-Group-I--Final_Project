package edu.mu.item;

import java.util.Random;

public class SingleCard extends Item {
    private int[] possibleValues;
    private int currentValue;

    public SingleCard(String name, int price, int[] possibleValues) {
        super(name, price);
        this.possibleValues = possibleValues;
        applyEffect(); // Initialize to invalid value
    }

    @Override
    public void applyEffect() {
    	if (currentValue == 0) { // Check if card value is not assigned
            currentValue = getRandomValueFromPossibleValues();
        }
        // Here you can add logic for adding the card to the player's deck
    }
    
    private int getRandomValueFromPossibleValues() {
    	Random random = new Random();
    	int index = random.nextInt(possibleValues.length);
    	return possibleValues[index];
    }

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
    
    public void resetValue() {
    	currentValue = 0;
    }

    public void setCurrentValue(int value) {
        this.currentValue = value;
    }

    public SingleCard duplicate() {
        // Create a new SingleCard with the same attributes
        SingleCard duplicateCard = new SingleCard(this.getName(), this.getPrice(), this.possibleValues);
        duplicateCard.setCurrentValue(this.getCurrentValue());
        return duplicateCard;
    }
}
