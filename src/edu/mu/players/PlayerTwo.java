package edu.mu.players;

import java.util.ArrayList;

import edu.mu.card.Card;
import edu.mu.deck.Deck;
import edu.mu.deck.EnemyDeck;

public class PlayerTwo extends Player{

	private ArrayList<Card> hand;
	private EnemyDeck deck;
	private int health;
	
	public PlayerTwo(int level) {
		//hand = initHand();
		health = 100;
		deck = new EnemyDeck(level);
	}
	
	
	@Override
	public void playCard(Card card) {
		// TODO Auto-generated method stub
		System.out.println("Card has been played!");
		removeCard(card);
		
	}

	@Override
	public void removeCard(Card card) {
		// TODO Auto-generated method stub
		hand.remove(card);
		
	}

	@Override
	public void addCardToHand(ArrayList<Card> card) {
		// TODO Auto-generated method stub
		Card cardToAdd = card.get(0);
		hand.add(cardToAdd);
	}


	@Override
	public ArrayList<Card> initHand() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean checkPlayerHealth() {
		if(health <= 0) return false;
		
		return true;
	}


	@Override
	public void damagePlayer(int num) {
		// TODO Auto-generated method stub
		health = health - num;
		
	}
	
	public void setHand(ArrayList<Card> cards) {
		hand = cards;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public Deck getDeck() {
		return deck;
	}

}
