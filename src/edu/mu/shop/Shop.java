package edu.mu.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import edu.mu.item.DeleteCardItem;
import edu.mu.item.Item;
import edu.mu.item.ItemFactory;
import edu.mu.item.ItemType;
import edu.mu.item.ResetShopItem;
import edu.mu.item.SingleCard;
import edu.mu.players.PlayerOne;
import edu.mu.players.PlayerTwo;

/**
 * Represents the in-game shop where players can buy items using currency
 * Allows players to view available items, purchase items, and refresh the shop inventory
 * 
 * @author Logan Bird
 * @author Ryan Esparza
 * @author Dion Burns
 * @author Albert Zhou
 */
public class Shop {

	private List<Item> displayedItems; 
	private int currency;
	private static Shop instance = null;
	private ItemFactory itemFactory = new ItemFactory();
	private PlayerTwo enemy;
	  
	/**
	 * Constructor for the Shop class
	 */
	private Shop() { 
		
		displayedItems = new ArrayList<Item>();
		currency = 0;
    }
	
	/**
	 * Gets the current instance of the player
	 * 
	 * @return the instance of the player
	 */
	public static Shop getInstance() {
		if(instance == null) {
			instance = new Shop();
		}
		return instance;
	}
	  
	/**
	 * Selects items to be displayed in the shop
	 */
	private void selectDisplayedItems() {
		displayedItems.clear();
	  
		displayedItems.add(itemFactory.getItem(ItemType.GET_SINGLE_CARD));
		displayedItems.add(itemFactory.getItem(ItemType.GET_SINGLE_CARD));
		displayedItems.add(getRandomBoosterPack());
		displayedItems.add(getRandomBoosterPack());
		displayedItems.add(itemFactory.getItem(ItemType.DELETE)); //change last param to not null
		displayedItems.add(itemFactory.getItem(ItemType.RESET_SHOP));
		displayedItems.add(getRandomBattleItem());
		displayedItems.add(getRandomBattleItem());
		
	}
	
	private Item getRandomBattleItem() {
		Random random = new Random();
		int itemToGenerate = random.nextInt(3);
		
		Item item = null;
		
		switch (itemToGenerate) {
		case 0:
			item = itemFactory.getItem(ItemType.HEAL);
			break;
		case 1:
			item = itemFactory.getItem(ItemType.PEEK_CARD);
			break;
		case 2:
			item = itemFactory.getItem(ItemType.SWAP_CARD);
			break;
		}
		
		return item;
	}
	
	public void setPlayerTwo(PlayerTwo enemy) {
		this.enemy = enemy;
	}
	
	/**
	 * Generates a random booster pack item
	 * 
	 * @return A random booster pack item
	 */
	private Item getRandomBoosterPack() {
		Random random = new Random();
		int chance = random.nextInt(10); // generate random number between 0 and 9 
		if (chance <= 5) { 
			return new SingleCard("Bronze booster", 4, new int[] {22,23,35,37,46,48,59,73});
			
			} else if (chance > 5 && chance < 9) {
				return new SingleCard("Silver booster", 10, new int[] {39,44,46,57,68,69,77,83});
			} else { 
				return new SingleCard("Gold booster", 40, new int[] {63,79,78,77,88,82,99,100});
		}
	} 

	/**
	 * Opens the shop menu, allowing the player to interact with the shop
	 */
	public void openShopMenu() {
	    selectDisplayedItems();
		
		Scanner scanner = new Scanner(System.in);
		boolean exitShop = false;
		
		while ( !exitShop) {
			System.out.println("Welcome to the Shop!");
			selectDisplayedItems();
			System.out.println(" Your Currency: $" + currency);
			System.out.println("Available Items:");
			displayItems();
			
			boolean validInput = false;
			while (!validInput) {
				System.out.println("Enter the number of the item you wish to purchase OR 'exit' to leave the shop:");
				
				String input = scanner.next();
				
				if ( input.equalsIgnoreCase("exit")) {
					System.out.println("Exiting the Shop");
					exitShop = true;
					validInput = true;
				} else {
					try {
						int itemNumber = Integer.parseInt(input)-1;
						if ( itemNumber >= 0 && itemNumber < displayedItems.size()) {
							Item selectedItem = displayedItems.get(itemNumber);
							if ( currency >= selectedItem.getPrice()) {
								purchaseItem(selectedItem);
								
							}else {
								System.out.println("Insufficient funds!");
							}
						} else {
							System.out.println("invalid item number");
						}
					} catch ( NumberFormatException e) {
						System.out.println("Invalid input, please enter a valid item number or exit to leave");
					}
				}
			}
		}
	}
	
	/**
	 * Displays items available in the shop
	 */
	private void displayItems () {
		for (int i =0; i< displayedItems.size(); i++) { 
			Item item = displayedItems.get(i);
			System.out.println((i + 1) + ". " +item.getName() + " - Price: $" + item.getPrice());
			}
	  }
	
	/**
	 * Purchases an item from the shop
	 * 
	 * @param item The item to purchase
	 */
	private void purchaseItem (Item item) { 
		if(item instanceof DeleteCardItem || item instanceof ResetShopItem || item instanceof SingleCard) {
			item.applyEffect();
		} else {
			PlayerOne.getPlayer().addBattleItem(item);
		}
		currency -= item.getPrice();
		displayedItems.remove(item);
		System.out.println("You Purchased: " + item.getName());
		System.out.println("remaining Currency: $" + currency);
		System.out.println("remaining Items in shop"); 
		displayItems();
	}
	
	/**
	 * Adds currency to the player's funds
	 * 
	 * @param amount The amount of currency to add
	 */
	public void addCurrency(int amount) { 
		currency += amount;
	}
	  
	/**
	 * Refreshes the shop by selecting new displayed items
	 */
	public void refreshShop() {
		selectDisplayedItems();
	}
	
	/**
	 * Retrieves the current currency balance
	 * 
	 * @return The current currency balance
	 */
	public int getCurrency() {
		return currency;
	}
	
	/**
	 * Retrieves the list of displayed items in the shop
	 * 
	 * @return The list of displayed items
	 */
	public List<Item> getDisplayedItems() {
		return displayedItems;
	}
}
