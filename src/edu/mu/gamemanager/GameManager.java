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
		//displayPlayerHand(player); //need to format this correctly

		//PlayerOne user = new PlayerOne();
		
		//user.INITDECK();// intialize starting deck ( depending on how many compares to win a battle Deck should start with very little cards that way it insentivises the user to add to the deck 
		
		//user.Level(1);// set the users level to 1 
		int userLevel = 1; // SET USER LEVEL LIKE THIS ???
		
		shop.addCurrency(10);// starting currency 
		
		// if we want health to not reset inbetween battles then initilize it here BUT if we want it to reset then initilize it at beginning of loop 
	
		while(true) { // GAME PLAY LOOP 
			
			System.out.println("level " + userLevel);// tell what level your on
			
			enemy.refreshEnemy(userLevel);;// set up enemy deck for that level
			shop.setPlayerTwo(enemy);
			//enemy.INITDECK(level); initilize enemy deck based on level 
			
			Battle battle = new Battle(player,enemy);
			boolean result = battle.startBattle();// call battle method 
			
			// do we want to update level and user money inside battle function or out here
			if (result == true) {
				userLevel++;
				shop.addCurrency(50);
				
				shop.openShopMenu();// if win open shop and let user buy things for deck 
				
				//idk if we need logic if exit shop go back to begining of loop or not 
			} 
			else if ( result == false) {// if lose then break out of loop 
				System.out.println("Game Over - You Lose!");
				break;
			}
			
		}
	
		// start battle 
				// iniside battle 
				// shuffle both decks 
				// IF we are doing playable hand then have player draw cards that they can choose to use IF we are doing a war style then draw top card off the deck 
				// take the two chosen cards and compare who ever card value is the highest wins
				// loser loses a life and we repeat battle until someone has all of their life points out. 
				// once winner  add level and add currency 
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
