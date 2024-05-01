package edu.mu.main;

import java.util.Random;

import edu.mu.item.SingleCard;

public class Main {

    public static void main(String[] args) {
        String cardName = "Card A";
        int cardPrice = 5;
        int[] possibleValues = {1, 2, 3, 4, 5};
        
        // No need to generate a random value here, as we're using the array of possible values
        SingleCard card = new SingleCard(cardName, cardPrice, possibleValues);
        
        System.out.println("Created card: " + card.getName() + " with value: " + card.getValue());
    }

}
