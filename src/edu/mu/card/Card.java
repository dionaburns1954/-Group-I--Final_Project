package edu.mu.card;

public class Card { //might turn into an abstract class or interface later
	
	private int value;
	
	
	public Card() { //default constructor
		this.value = 1;
	}
	
	public Card(int value) { //parametized constructor
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	
	
}
