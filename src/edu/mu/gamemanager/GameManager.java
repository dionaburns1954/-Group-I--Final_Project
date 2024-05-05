package edu.mu.gamemanager;

import java.util.Scanner;

import edu.mu.deck.Deck;
import edu.mu.players.Player;
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
	
	private void displayPlayerHand(PlayerOne player) {
		for(int i = 0; i < player.getHand().size(); i++) {
			System.out.print("Card " + (i + 1) + ": " + player.getHand().get(i).getValue());
			System.out.println();
		}
	}
	
	
	public void start() {
		giveHand();
		displayPlayerHand(player); //need to format this correctly
		//initilize users starting deck 
		// intiilize users starting money 
		// if we want health to not reset inbetween battles then initilize it here BUT if we want it to reset then initilize it at beginning of loop 
		// LOOP create loop for game sequence 
		// initillize  the users  health, and level 
		// from level initilize enemy deck 
		// start battle 
				// iniside battle 
				// shuffle both decks 
				// IF we are doing playable hand then have player draw cards that they can choose to use IF we are doing a war style then draw top card off the deck 
				// take the two chosen cards and compare who ever card value is the highest wins
				// loser loses a life and we repeat battle until someone has all of their life points out. 
				// once winner  add level and add currency 
		// if win open shop 
		// once the user exits shop  then loop it back up to start of loop 
		// ELSE break the loop you lose game over. 
		
	}	
}
