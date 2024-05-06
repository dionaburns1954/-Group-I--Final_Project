package edu.mu.gamemanager;

import edu.mu.battle.Battle;
import edu.mu.deck.Deck;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;
import edu.mu.shop.Shop;

/**
 * Manages the flow of the game, like starting battles, managing player health and levels,
 * displaying player hands, and interacting with the shop.

 * @author Dion Burns
 * @author Logan Bird
 * @author Ryan Esparza
 */
public class GameManager {
	
	private static GameManager instance;
	
	private final PlayerOne player = PlayerOne.getPlayer();
	private Shop shop = Shop.getInstance();
	private PlayerTwo enemy;
	private final int handNum = 7;
	
	/**
	 * Private constructor for the GameManager
	 * Initializes the player and enemy characters
	 */
	public GameManager() {
		enemy = PlayerTwo.getPlayer();
		shop.setPlayerTwo(enemy);
	}
	
	/**
	 * Gives both the player and enemy a fresh hand of cards
	 * 
	 * @return True if both players have a non-empty hand after drawing cards, false otherwise
	 */
	public boolean giveHand() { //gives player and enemy a fresh hand. Supposed to be called at the beginning
		player.setHand(player.getDeck().pullCardsFromDeck(handNum));
		if(player.getHand().size() <= 0) return false;
		
		enemy.setHand(player.getDeck().pullCardsFromDeck(handNum));
		if(enemy.getHand().size() <= 0) return false;
		
		return true;
		
	}
	
	/**
	 * Retrieves the player's deck
	 * 
	 * @return The player's deck
	 */
	public Deck getPlayerDeck() {
		return player.getDeck();
	}
	
	/**
	 * Checks if player one's health is greater than zero
	 * 
	 * @return True if player one's health is greater than zero, false otherwise
	 */
	private boolean checkPlayerOneHealth() {
		if(player.checkPlayerHealth()) return true;
		
		return false;
	}
	
	/**
	 * Checks if player two's health is greater than zero
	 * 
	 * @return True if player two's health is greater than zero, false otherwise
	 */
	private boolean checkPlayerTwoHealth() {
		if(enemy.checkPlayerHealth()) return true;
		
		return false;
	}
	
	/**
	 * Displays the player's hand of cards
	 * 
	 * @param player The player whose hand should be displayed
	 */
	private void displayPlayerHand(PlayerOne player) {
		for(int i = 0; i < player.getHand().size(); i++) {
			System.out.print("Card " + (i + 1) + ": " + player.getHand().get(i).getValue());
			System.out.println();
		}
	}
	
	/**
	 * Starts the game loop, managing battles, player health, levels, and interaction with the shop
	 */
	public void start() {
		giveHand();
		
		int userLevel = 1; 
		
		shop.addCurrency(10);// starting currency 
		
		
		while(true) { // GAME PLAY LOOP 
			
			System.out.println("level " + userLevel);// tell what level you're on
			
			enemy.refreshEnemy(userLevel);;// set up enemy deck for that level
			shop.setPlayerTwo(enemy);
			
			Battle battle = new Battle(player,enemy);
			boolean result = battle.startBattle();// call battle method 
			
			
			if (result == true) {
				userLevel++;
				shop.addCurrency(50);
				
				shop.openShopMenu();// if win open shop and let user buy things for deck 
				
			} 
			else if ( result == false) {// if lose then break out of loop 
				System.out.println("Game Over - You Lose!");
				break;
			}
			
		}
	}	
	
	/**
	 * Retrieves the singleton instance of the GameManager
	 * 
	 * @return The singleton instance of the GameManager
	 */
	public static GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	}
}
