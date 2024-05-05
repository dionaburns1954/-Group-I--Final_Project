package edu.mu.gamemanager;

import edu.mu.deck.Deck;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

public class GameManager {
	
	private final PlayerOne player = new PlayerOne();
	private PlayerTwo enemy;
	private int enemyLvl = 1; //can be changed
	//private final Deck deck;
	private final int handNum = 7;
	
	public GameManager() {
		enemy = new PlayerTwo(enemyLvl);
		//deck = new Deck();
	}
	
	public boolean giveHand() { //gives player and enemy a fresh hand. Supposed to be called at the beginning
		player.setHand(player.getDeck().pullCardsFromDeck(handNum));
		if(player.getHand().size() <= 0) return false;
		
		enemy.setHand(player.getDeck().pullCardsFromDeck(handNum));
		if(enemy.getHand().size() <= 0) return false;
		
		
		return true;
		
	}
	
	private boolean checkPlayerOneHealth() {
		if(player.checkPlayerHealth()) return true;
		
		return false;
	}
	
	private boolean checkPlayerTwoHealth() {
		if(enemy.checkPlayerHealth()) return true;
		
		return false;
	}

}
