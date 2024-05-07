# -Group-I--Final_Project
This is a game like war.

## Description
This program is a game called a game like war. This game is a card game where the user is given a initial deck and he battles enemy decks by comparing values of cards, as he beats more and more enemies the users goal is to see how long they can last battling harder and harder enemy decks. To run this program, just copy the repository and run the "Main" file.

## GAME PLAY 
The game play consists of 2 main stages Battle and Shop. the battle is the combat of the game and the Shop is the deck building proccess of the game.

## battle
inside the battle gamplay the user starts off with a initlized deck and jumps right into a battle, the  battle sequence starts off by both the enemy deck and the users deck being shuffled and drawing 7 cards, the user then can choose to either use a battle item, or can pick a card to battle with, after the user selects a card to battle with then it is compared up against the enemies card, which ever card has the highest value wins the round, whoe ever loses a round loses health, the round will repeat until either the enemy runs out of health OR the user runs out of health, if the user runs out of health the game is over. if the enemy runs out of health then the user wins and gets a level, and currency and then goes onto the shop phase of the game

## SHOP 
after a battle the user gets currency, with this currency the user can purchase either more  cards to add to their deck, the ability to remove a card from their deck ( if they want to get rid of low value cards), purchase different battle items to be used in battle such as see what the enemy card is or heal, OR you can purchase an item that reloads the shop. after you purchae all that you want for your deck the user can type exit to go on to the next battlle


## PACKAGES 
* edu.mu.battle
* edu.mu.card
* edu.mu.deck
* edu.mu.gamemanager
* edu.mu.item
* edu.mu.main
* edu.mu.players
* edu.mu.shop
* edu.mu.Tests


## Battle class 
// enter battle class methods

public class Battle {
	
- public Battle(PlayerOne Player, PlayerTwo enemy) 

 	// creates player and enemy 
	
- public boolean startBattle() {

  	// starts the battle, first call shuffle cards, then call draw cards, then create a loop and call playRound, the while loop will continuelly play rounds until either the user or the enemy loses all of their health
	
- private void shuffleDecks() {

  	// shuffles the decks

- private void drawCards(int numcards) {

  	// draws cards for both enemy and user
  
- private void openBattleItemMenu() { 

  	// this opens a menu that shows the user the battle items they have purchase and lets the user use a battle item if they want to or ecit the menu
			
- private void displayPlayerHand() {

  	// this shows what cards the user drew
	
- private void playRound() {	

  	// this starts off by showing the users hand, then it will openItemBattleMenu, after that it will create  a loop and tekk the user to choose a card, it then take the card the user chose, and then pick a card from the enemies hand randomly and show the value of both of the cards and run compareCards method.
   
- private void compareCards(Card playerCard, Card enemyCard) 

  	// this method compares the values of the two cards if the player card is higher then the enemy will lose health else it is flipped and the user will lose health 
		
## CARD class
Global Varialables
* value : Numbered value of card
Methods
* setValue(int value) : sets the card's value to a certain value
* getValue() : returns the card's current value

## DECK Class
* EnemyDeck
  - protected initializeDeck(int level) : initializes a deck of a certain level
  - private void Deck_1() : initializes deck of level 1
  - private void Deck_2() : initializes deck of level 2
  - private void Deck_3() : initializes deck of level 3
  - private void Deck_4() : initializes deck of level 4
  - private void Deck_5() : initializes deck of level 5
  - private void Deck_above5(int level) : Initializes a deck with level higher than 5
  - private boolean createDeck(int min, int max) : Adds cards with values ranging between a min and max to deck
* UserDeck
  - resetDeck() : initializes a new deck and sets as the user's current deck

## ITEM 
THERE ARE A LOT OF DIFFERENT ITEMS SO GO THROUGH AND LIST EM ALL 
* DeLeteCardItem( )
* HealthItem()
* ItemFactory()
* ItemType()
* PeekCardItem()
* ResetShopItem()
* SingleCard()
* SwapCardItem()

## PLAYERS 
PlayerOne
* Global Variables
  - private ArrayList<Card> hand;
  - private UserDeck deck;
  - private int health;
  - private static PlayerOne instance
  - private ArrayList<Item> battleItems;
* Methods
  - public static getPlayer() : returns instance if its not null, otherwise creates a new instance and returns it
  - public Card playCard(Card card) : plays a specified card
  - public void removeCard(Card card) : removes a specified card
  - public void addCardToHand(ArrayList<Card> card) : adds a list of cards to the player's hand
  - public void addBattleItem(Item item) : Adds and item to the player's battleItems list
  - public ArrayList<Card> initHand() : returns null
  - public boolean checkPlayerHealth() : Checks whether the player's health is less than or equal to zero. Returns false if it is, otherwise returns true.
  - public int getHealth() : returns the player's health
  - public void damagePlayer(int num) : damages player for a certain amount
  - public void addHealth(int hp) : adds a certain amount of HP to the user's health
  - public setHand(ArrayList<Card> cards) : sets hand to a certain list of cards
  - public ArrayList<Card> getHand() : returns the user's current hand
  - public Deck getDeck() : returns the user's deck
  - public ArrayList<Item> getBattleItems() : return's the user's current battleItems list

## SHOP
 
	
- public static Shop getInstance() 

	// this method gets the Instance of the player 

- private void selectDisplayedItems() 

	// this method selects what items will be displayed in the shop, the choice of items are random
	
- private Item getRandomBattleItem() {

	// this gets a random battle item to be called in selecting displayed items 
	
- public void setPlayerTwo(PlayerTwo enemy) {

	// this method sets the player two

- private Item getRandomBoosterPack() {	

	// this item gets a random booster Pack to be called in select displayed items

- public void openShopMenu() 

  	 // this method is the method that runs the shop, this method enters a loop showing the user their currency and the items in the shop, it then reads a input the input is either a number OR exit, if the user inputs a number then the method will check to see if that number matches with one of the items in the shop if it does then it will compare the amount of currency the user has with how much the item costs, if the use has enough money then the user will purchase the item and the item will be removed from the shop and the shop will loop back to telling the user their currency and available items, If the user inputs exit this will leave the shop 
			
- private void displayItems () 

	// this displays the items that were selected 
  
- private void purchaseItem (Item item)  

	// this checks to see if the item is a item that needs to be used right away OR if it is a battle item, if it is a item to use right away it will use the items applyEffect, if the item is a battle item it is stored in battle itemit then subtracks the user currency by how ever much the item cost and remove the item from the shop 
	
- public void addCurrency(int amount)  

  	 //this function adds  what ever the amount it to the players currancy 
	
- public void refreshShop() 

	//this refreshes the items inside teh shop 
	
- public int getCurrency() 

	// getter for currency 
	
- public List<Item> getDisplayedItems() 

	// shows the displayed Items in the shop



## TEST
 I do not think we would need test here

## GAME MANAGER / MAIN 
SHOW those two together here 
