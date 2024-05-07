package edu.mu.battle;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import edu.mu.card.Card;
import edu.mu.item.Item;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

/**
 * Represents a battle between the two players.
 * Includes shuffling decks, drawing cards, playing rounds, and determining the winner.
 * 
 * @version 1.0
 * @author Logan Bird
 * @author Dion Burns
 * @author Albert Zhou
 */
public class Battle {
	
	/**
	 * The amount of damage taken when a player loses.
	 */
	private final int damageAmount = 50;
	
	/**
	 * The human player
	 */
	private PlayerOne player;
	
	/**
	 * The enemy AI player.

	 */
	private PlayerTwo enemy;
	

	public static final Scanner battleScanner = new Scanner(System.in);
	
	/**
	 * Constructor for the Battle class
	 * 
	 * @param Player The first player
	 * @param enemy The second player
	 */
	public Battle(PlayerOne Player, PlayerTwo enemy) {
		this.player = Player;
		this.enemy = enemy;
		
	}
	
	/**
	 * Starts the battle between the two players.
	 * 
	 * @return An boolean indicating if the player won or not.
	 */
	public boolean startBattle() {
		
		System.out.println("START OF BATTLE");
		shuffleDecks(); // Shuffle each deck before starting
		
		drawCards(7); // Draw 7 cards for both players
		
		while(player.checkPlayerHealth()  && enemy.checkPlayerHealth() ) {
			// Play rounds until one player is out of HP.
			playRound();
			
			System.out.println("\nEnd of round.");
			System.out.println("Enemy health = " + enemy.getHealth() + " HP");
		}
			
		if(!player.checkPlayerHealth()) { // If the player is dead, then display a message.
			System.out.println("\nYou Lose "); 
			return false;
		}
		
		System.out.println("You win off to next battle"); // Display the winning message
		return true;
	}
	
	/**
	 * Shuffles both the player and enemy's deck.
	 * 
	 * @see edu.mu.deck.Deck#shuffleDeck
	 */
	private void shuffleDecks() {
		player.getDeck().shuffleDeck();
		enemy.getDeck().shuffleDeck();
	}
	
	/**
	 * Draws a specified number of cards for both players from their respective decks
	 * 
	 * @param numcards The number of cards to draw
	 * @see edu.mu.deck.Deck#pullCardsFromDeck(int)
	 */
	private void drawCards(int numcards) {
		player.setHand(player.getDeck().pullCardsFromDeck(numcards));
		enemy.setHand(enemy.getDeck().pullCardsFromDeck(numcards));
	}
	
	/**
	 * Opens a menu allowing the user to use any battle items they have. If they do not
	 * have any battle items, then the menu is not displayed.
	 */
	private void openBattleItemMenu() { 
		ArrayList<Item> playerBattleItems = player.getBattleItems();
		boolean isInBattleItemMenu = false;
		
		// If the player does not have any battle items, then don't display the menu 
		if(playerBattleItems.size() > 0) {
			isInBattleItemMenu = true;
		}
		
		while(isInBattleItemMenu) {
			System.out.println("\nBattle items available to you: ");
			
			int i = 0;
			// Display the player's battle items
			for(Item item : playerBattleItems) {
				i++;
				System.out.println(i + ": " + item.getName());
			}
			
			System.out.println("Select a battle item to use or enter " + (i + 1) + " to exit:");
			
			try { 
				int itemChoice = battleScanner.nextInt() - 1; // Get the player choice
				
				if (itemChoice >= 0 && itemChoice < playerBattleItems.size()) {
					// Get the selected card from the player's hand
					Item item = playerBattleItems.get(itemChoice);
					item.applyEffect(); // Use the item
					player.getBattleItems().remove(item); // Remove the item
					
					// If the player does not have any more battle items left, then exit the menu
					if(playerBattleItems.size() == 0) {
						isInBattleItemMenu = false;
						displayPlayerHand();
					}
				} else if (itemChoice == playerBattleItems.size()) {
					// Exit the menu if the player chooses the option to
					displayPlayerHand();
					isInBattleItemMenu = false;
				} else {
					System.out.println("Please enter a valid choice.");
				}
			} catch(NoSuchElementException e) {
				System.out.println("Please enter a valid choice.");
				battleScanner.next();
			}
		}
	}
	
	/**
	 * Displays the player's current hand.
	 * 
	 * @see edu.mu.players.PlayerOne#hand
	 */
	private void displayPlayerHand() {
		for(int i = 0; i < player.getHand().size(); i++) {
			System.out.print("Card " + (i + 1) + ": " + player.getHand().get(i).getValue() + "\n");
		}
	}
	
	/**
	 * Plays a round of the battle, where both players choose a card to play
	 */
	private void playRound() {
		Random random = new Random();
		
		// Display the player's hand and the battle item menu, if applicable
		displayPlayerHand();
		openBattleItemMenu();
		
		boolean isInCardMenu = true;
		while (isInCardMenu) {	
			System.out.println("\nYou have " + player.getHealth() + " HP.");
			System.out.print("Choose a card to play: ");
			
			try {
				int playerchoice = battleScanner.nextInt()-1; // Get the player choice
				
				if ( playerchoice >= 0 && playerchoice < player.getHand().size())
				{
					isInCardMenu = false;
					
					// Get the player's selected card
					Card playerCard = player.getHand().get(playerchoice);
					
					// Randomly select a card from the enemy's hand.
					int enemychoice = random.nextInt(enemy.getHand().size());
					
					Card enemyCard = enemy.getHand().get(enemychoice);
					
					// Remove the selected cards from their respective hands
					player.getHand().remove(playerCard);
					enemy.getHand().remove(enemyCard);
					
					// Compare the card values
					compareCards(playerCard, enemyCard);
					
					System.out.println("Player plays card with value of: " + playerCard.getValue());
					System.out.println("Enemy plays card with value of: "+ enemyCard.getValue());
				
				} else {
					System.out.println("Invalid input please try again");
				}
			} catch(NoSuchElementException e) {
				System.out.println("ERROR not valid input");
			} finally {
				battleScanner.nextLine();
			}
		}
	}
	
	/**
	 * Compares the cards played by both players and applies damage accordingly.
	 * If the result is a tie, then the player wins by default.
	 * 
	 * @param playerCard The card played by the player
	 * @param enemyCard The card played by the enemy
	 */
	private void compareCards(Card playerCard, Card enemyCard) {
		boolean playerCardLarger = (playerCard.getValue() >= enemyCard.getValue()) ? true : false;
		if(playerCardLarger) {
			System.out.println("\nEnemy took damage"); 
			enemy.damagePlayer(damageAmount); // Damage the enemy if the player wins
		} else { 
			System.out.println("\nYOU took damage");
			player.damagePlayer(damageAmount); // Damage the player if they lose
		}
	}
}
