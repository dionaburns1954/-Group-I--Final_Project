package edu.mu.battle;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.item.Item;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

/**
 * Represents a battle between the two players
 * Includes shuffling decks, drawing cards, playing rounds, and determining the winner
 * 
 * @author Logan Bird
 * @author Dion Burns
 * @author Albert Zhou
 */
public class Battle {

	private final int DAMAGEAMOUNT = 50;
	private PlayerOne player;
	private PlayerTwo enemy;
	private Scanner battleScanner;
	
	/**
	 * Constructor for the Battle class
	 * 
	 * @param Player The first player
	 * @param enemy The second player
	 */
	public Battle(PlayerOne Player, PlayerTwo enemy) {
		this.player = Player;
		this.enemy = enemy;
		
		battleScanner = new Scanner(System.in);
	}
	
	/**
	 * Starts the battle between the two players
	 * 
	 * @return An integer indicating the result of the battle: 1 for player victory, 2 for enemy victory
	 */
	public boolean startBattle() {
		
		System.out.println("START OF BATTLE");
			shuffleDecks();
			
			drawCards(7);
			
			while(player.checkPlayerHealth()  && enemy.checkPlayerHealth() ) {
			playRound();
			
			System.out.println("\nEnd of round.");
			System.out.println("enemy health = " + enemy.checkPlayerHealth());
		}
			
		if(!player.checkPlayerHealth()) {
			System.out.println("\nYou Lose "); // Print victory message
			return false;
		}
		
		System.out.println("You win off to next battle");
		return true;// print out win message 
	}
	
	
	private void shuffleDecks() {
		player.getDeck().shuffleDeck();
		enemy.getDeck().shuffleDeck();
	}
	
	/**
	 * Draws a specified number of cards for both players from their respective decks
	 * 
	 * @param numcards The number of cards to draw
	 */
	private void drawCards(int numcards) {
		player.setHand(player.getDeck().pullCardsFromDeck(numcards));
		enemy.setHand(player.getDeck().pullCardsFromDeck(numcards));
	}
	
	private void openBattleItemMenu() { 
		boolean isInBattleItemMenu = false;
		
		if(player.getBattleItems().size() > 0) {
			isInBattleItemMenu = true;
		}
		
		while(isInBattleItemMenu) {
			System.out.println("Select a battle item to use or enter " + player.getBattleItems().size() + " to exit:");
			
			try { 
				int itemChoice = battleScanner.nextInt() - 1;
				
				if (itemChoice >= 0 && itemChoice < player.getBattleItems().size()) {
					Item item = player.getBattleItems().get(itemChoice);
					
					item.applyEffect();
				}
				
			} catch(NoSuchElementException e) {
				System.out.println("Please enter a valid choice.");
			}
		}
	}
	
	/**
	 * Plays a round of the battle, where both players choose a card to play
	 */
	private void playRound() {
		
				
		Random random = new Random();
		
		for(int i = 0; i < player.getHand().size(); i++) {
			System.out.print("Card " + (i + 1) + ": " + player.getHand().get(i).getValue() + "\n");
		}
		
		openBattleItemMenu();
		
		boolean isInCardMenu = true;
		while (isInCardMenu) {	
			System.out.print("Choose a card to play: ");
			
			try {
				int playerchoice = battleScanner.nextInt()-1;
				
				if ( playerchoice >= 0 && playerchoice < player.getHand().size())
				{
					isInCardMenu = false;
			
					Card playerCard = player.getHand().get(playerchoice);

					int enemychoice = random.nextInt(enemy.getHand().size());
					Card enemyCard = enemy.getHand().get(enemychoice);
					
					player.getHand().remove(playerCard);
					enemy.getHand().remove(enemyCard);
					
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
	 * Compares the cards played by both players and applies damage accordingly
	 * 
	 * @param playerCard The card played by the player
	 * @param enemyCard The card played by the enemy
	 */
	private void compareCards(Card playerCard, Card enemyCard) {
		// if player card.getvalue is greater then take health away from enemy
		// else if enemy card is greater than take health away from player 
		// else it is a tie 
		boolean playerCardLarger = (playerCard.getValue() >= enemyCard.getValue()) ? true : false;
		if(playerCardLarger) {
			System.out.println("\nenemy took damage");
			enemy.damagePlayer(DAMAGEAMOUNT);}
		else { 
			System.out.println("\nYOU took damage");
			player.damagePlayer(DAMAGEAMOUNT);}
		}
	}
