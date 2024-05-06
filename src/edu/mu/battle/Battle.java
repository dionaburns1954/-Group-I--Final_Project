package edu.mu.battle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.mu.card.Card;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

public class Battle {
	
	
	private PlayerOne playerDeck;
	private PlayerTwo enemyDeck;
	private ArrayList<Card> playerHand;
	private ArrayList<Card> enemyHand;
	private int playerHealth;
	private int enemyHealth;
	private final int DAMAGEAMOUNT = 33;
	
	
	
	public Battle(PlayerOne PlayerDeck, PlayerTwo enemyDeck) {
		this.playerDeck = PlayerDeck;
		this.enemyDeck = enemyDeck;
		this.playerHand = new ArrayList<>();
		this.enemyHand = new ArrayList<>();
		this.playerHealth = 3;
		this.enemyHealth = 3;
		
	}
	
	public int startBattle() {
		
		while(playerHealth > 0 && enemyHealth >0) {
			
			shuffleDecks();
			drawCards(3);
			
			playRound();
			
			System.out.println("\nEnd of round.");
			
		}
		if(playerHealth <= 0) {
			return 2; // print out lose message 
		} else {
			return 1;// print out win message 
		}
	}
	
	private void shuffleDecks() {
		// shuffle the cards 
		
	}
	
	private void drawCards(int numcards) {
		// draw cards to put into hand 
		
	}
	private void playRound() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("\nPlayer's hand: " + playerHand);
		
		System.out.print("choose a card to play");
		int player_choice = scanner.nextInt();
		Card playerCard = playerHand.get(player_choice);
		playerHand.remove(playerCard);
		
		// dp enemy but make the choice random 
		
		// print out player card 
		// print out enemy card
		
		// run compare
	}
	
	private void compareCards(Card playerCard, Card enemyCard) {
		// if player card.getvalue is greater then take health away from enemy
		// else if enemy card is greater than take health away from player 
		// else it is a tie 
		boolean playerCardLarger = (playerCard.getValue() >= enemyCard.getValue()) ? true : false;
		if(playerCardLarger) enemyDeck.damagePlayer(DAMAGEAMOUNT);
		else playerDeck.damagePlayer(DAMAGEAMOUNT);
	}
}
