package edu.mu.main;

import edu.mu.gamemanager.GameManager;

/**
 * The main class to run the game
 * 
 * @author Ryan Esparza
 * @author Logan Bird
 * @author Dion Burns
 * @author Albert Zhou
 */
public class Main {

	/**
	 * The entry point of the program
	 * 
	 * @param args The command-line arguments
	 */
    public static void main(String[] args) {
		/*
		 * String cardName = "Card A"; int cardPrice = 5; int[] possibleValues = {1, 2,
		 * 3, 4, 5}; shop Shop = new shop(); // No need to generate a random value here,
		 * as we're using the array of possible values SingleCard card = new
		 * SingleCard(cardName, cardPrice, possibleValues);
		 * 
		 * System.out.println("Created card: " + card.getName() + " with value: " +
		 * card.getValue()); Shop.Add_Currency(50); Shop.Open_Shop_Menu();
		 */
    	
    	// Create an instance of the GameManager and start the game
    	GameManager ref = new GameManager();
    	ref.start();
    }
    	
}
