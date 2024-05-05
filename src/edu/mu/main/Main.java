package edu.mu.main;

import java.util.Random;

import edu.mu.gamemanager.GameManager;
import edu.mu.item.SingleCard;
import edu.mu.shop.shop;
public class Main {

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
    	
    	GameManager ref = new GameManager();
    	ref.start();
    }
    	
}
