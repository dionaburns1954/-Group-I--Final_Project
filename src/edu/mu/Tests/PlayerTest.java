package edu.mu.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.mu.card.Card;
import edu.mu.gamemanager.GameManager;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

class PlayerTest {

	@Test
	void testPlayerHandInit() {
		PlayerOne player = new PlayerOne();
		//GameManager man = new GameManager();
		player.setHand(player.getDeck().pullCardsFromDeck(7));
		assertTrue(player.getHand() instanceof ArrayList<Card>);
	}
	
	@Test
	void testRemoveCard() {
		PlayerOne player = new PlayerOne();
		player.setHand(player.getDeck().pullCardsFromDeck(7));
		Card card = player.getHand().get(0);
		player.removeCard(card);
		//tests to see if removed card is still in player's hand
		assertEquals(1, loopThroughHand(player.getHand(), card));
		
	}
	private int loopThroughHand(ArrayList<Card> hand, Card card) {
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i) == card) return 0;
		}
		
		return 1;
	}
	
	@Test
	void testRefreshEnemy() {
		PlayerTwo enemy = new PlayerTwo(1);
		enemy.refreshEnemy(3);
		//checks to see if new enemy deck is initialized 
		assertTrue(enemy.getDeck().getCards() instanceof ArrayList<Card>);
		
	}
	
	

}
