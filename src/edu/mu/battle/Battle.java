package edu.mu.battle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.mu.card.Card;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

/**
 * Represents a battle between the two players
 * Includes shuffling decks, drawing cards, playing rounds, and determining the winner
 * 
 * @author Logan Bird
 * @author Dion Burns
 */
public class Battle {
	
	private PlayerOne playerDeck; 
	private PlayerTwo enemyDeck; 
	private ArrayList<Card> playerHand; // The hand of cards for the player
	private ArrayList<Card> enemyHand; // The hand of cards for the enemy
	private int playerHealth; // The health of the player
	private int enemyHealth; // The health of the enemy
	private final int DAMAGEAMOUNT = 33; // The amount of damage dealt in each round
	private PlayerOne player; // The first player
	private PlayerTwo enemy; // The second player
	
	
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
	 * Starts the battle between the two players
	 * 
	 * @return An integer indicating the result of the battle: 1 for player victory, 2 for enemy victory
	 */
	public int startBattle() {
		
		while(player.checkPlayerHealth() != false && enemy.checkPlayerHealth() != false ) {
			
			shuffleDecks();
			drawCards(3);
			
			playRound();
			
			System.out.println("\nEnd of round.");
			
		}
		if(player.checkPlayerHealth() == false) {
			return 2; // print out lose message 
		} else {
			return 1;// print out win message 
		}
	}
	
	/**
	 * Shuffles the cards
	 */
	private void shuffleDecks() {
		// shuffle the cards 
		
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
	
	/**
	 * Plays a round of the battle, where both players choose a card to play
	 */
	private void playRound() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("\nPlayer's hand: " + player.getHand());
		
		System.out.print("choose a card to play");
		int player_choice = scanner.nextInt();
		Card playerCard = playerHand.get(player_choice);
		playerHand.remove(playerCard);
		int playerchoice = scanner.nextInt();
		Card playerCard = player.getHand().get(playerchoice);
		player.getHand().remove(playerCard);
		
		scanner.close();
		int enemychoice = random.nextInt(enemy.getHand().size());
		Card enemyCard = enemy.getHand().get(enemychoice);
		enemy.getHand().remove(enemyCard);
		
		
		System.out.println("Player plays : " + playerCard);
		System.out.println("Enemy plays : "+ enemyCard);
		
		compareCards(playerCard, enemyCard);
		
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
		if(playerCardLarger) enemyDeck.damagePlayer(DAMAGEAMOUNT);
		else playerDeck.damagePlayer(DAMAGEAMOUNT);
	}
}


