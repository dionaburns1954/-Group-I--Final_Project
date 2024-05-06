package edu.mu.battle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.mu.card.Card;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

public class Battle {
	
	
	private PlayerOne player;
	private PlayerTwo enemy;
	
	
	
	public Battle(PlayerOne Player, PlayerTwo enemy) {
		this.player = Player;
		this.enemy = enemy;
		
		
		
		
	}
	
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
	
	private void shuffleDecks() {
		// shuffle the cards 
		
	}
	
	private void drawCards(int numcards) {
		player.setHand(player.getDeck().pullCardsFromDeck(numcards));
		enemy.setHand(player.getDeck().pullCardsFromDeck(numcards));
	}
	private void playRound() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("\nPlayer's hand: " + player.getHand());
		
		System.out.print("choose a card to play");
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
	
	private void compareCards( Card playerCard, Card enemyCard) {
		// if player card.getvalue is greater then take health away from enemy
		// else if enemy card is greater than take health away from player 
		// else it is a tie 
	}
}


