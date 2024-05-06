package edu.mu.Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.mu.item.SingleCard;

class single_cardTest {

    @Test
    void testApplyEffect() {
        // Define the parameters for the SingleCard constructor
        String name = "Test Card";
        int price = 5;
        int[] possibleValues = {1, 2, 3};
        
        // Create a SingleCard instance
        SingleCard singleCard = new SingleCard(name, price, possibleValues);

        // Call the applyEffect method
        singleCard.applyEffect();

        // Now, you can add assertions to verify the expected behavior of applyEffect
        // For example, you might assert that the card's value has been set
        // assertEquals(expectedValue, actualValue);
    }
}
