package edu.mu.gamemanager;

import edu.mu.battle.Battle;
import edu.mu.deck.Deck;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;
import edu.mu.shop.Shop;

/**
 * Manages the flow of the game, like starting battles, managing player health and levels,
 * displaying player hands, and interacting with the shop.
 * 
 * @version 1.0
 * 
 * @see edu.mu.battle.Battle
 * 
 * @author Dion Burns
 * @author Logan Bird
 * @author Ryan Esparza
 */
public class GameManager {
	/**
	 * The current instance of the {@link GameManager}.
	 */
	private static GameManager instance;
	private final PlayerOne player = PlayerOne.getPlayer();
	
	/**
	 * The current instance of the shop.
	 */
	private Shop shop = Shop.getInstance();
	private PlayerTwo enemy;
	
	/**
	 * The number of cards that should be drawn for each hand.
	 */
	private final int handNum = 7;
	
	/**
	 * Private constructor for the GameManager.
	 * Initializes the player and enemy characters.
	 */
	public GameManager() {
		enemy = PlayerTwo.getPlayer();
		shop.setPlayerTwo(enemy);
	}
	
	/**
	 * Gives both the player and enemy a fresh hand of cards. Called at the beginning of battle.
	 * 
	 * @return True if both players have a non-empty hand after drawing cards, false otherwise
	 */
	public boolean giveHand() {
		player.setHand(player.getDeck().pullCardsFromDeck(handNum));
		if(player.getHand().size() <= 0) // Check if the player hand was successfully created
			return false;
		
		enemy.setHand(player.getDeck().pullCardsFromDeck(handNum));
		if(enemy.getHand().size() <= 0) // Check if the enemy hand was successfully created
			return false;
		
		return true;
	}
	
	/**
	 * Retrieves the player's deck.
	 * 
	 * @return The player's deck
	 */
	public Deck getPlayerDeck() {
		return player.getDeck();
	}
	
	/**
	 * Starts the game loop, managing battles, player health, levels, and interaction with the shop.
	 */
	public void start() {
		giveHand();
		
		int userLevel = 1; // The starting level of the user
		
		shop.addCurrency(10); // Give the player $10 at the start of the game	
		
		// Gameplay loop
		while(true) {
			
			System.out.println("Level " + userLevel); // Display the player's current level
			
			// Initialize the enemy deck with the corresponding level
			enemy.refreshEnemy(userLevel);
			shop.setPlayerTwo(enemy);
			
			Battle battle = new Battle(player, enemy);
			
			// Store the result of the battle
			boolean didPlayerWin = battle.startBattle(); 
			
			if (didPlayerWin == true) {
				userLevel++; // Increment the player's current level
				
				// Give the player $50 and open the shop menu
				shop.addCurrency(50);
				shop.openShopMenu();
			} 
			// If the player loses, break out of the loop
			else if (didPlayerWin == false) {
				System.out.println("Game Over - You Lose!");
				break;
			}
			
		}
	}	
	
	/**
	 * Retrieves the singleton instance of the GameManager.
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
