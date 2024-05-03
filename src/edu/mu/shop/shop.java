package edu.mu.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import edu.mu.deck.Deck;
import edu.mu.item.DeleteCardItem;
import edu.mu.item.Item;
import edu.mu.item.ResetShopItem;
import edu.mu.item.SingleCard;

public class shop {

	private List<Item> displayedItems; 
	private int currency;
	private Deck playerDeck;
	  
	  
	  
	public shop() { 
		
		displayedItems = new ArrayList<>();
		currency = 0;
		playerDeck = new Deck();

	    Select_Displayed_Items();
	    }//test
	  
	
	private void Select_Displayed_Items() {
		displayedItems.clear();
	  
	  displayedItems.add(Get_Random_Single_Card());
	  displayedItems.add(Get_Random_Single_Card());
	  displayedItems.add(Get_Random_BoosterPack());
	  displayedItems.add(Get_Random_BoosterPack());
	  displayedItems.add(new DeleteCardItem("Delete Card", 10, null));
	  displayedItems.add(new ResetShopItem("Reset Shop", 3, this));
	  
	  
	  }
	
	private Item Get_Random_BoosterPack() {
		Random random = new Random();
		int chance =random.nextInt(10);// generate random number between 0 and 9 
		if ( chance <= 5){ 
			return new SingleCard("Bronze booster", 4, new int[] {2,2,3,3,4,4,5,7});
			}else if ( chance >5 && chance < 9) {
				return new SingleCard("Silver booster", 6, new int[] {3,4,4,5,6,6,7,8});
			} else { 
				return new SingleCard("Gold booster", 8, new int[] {6,7,7,7,8,8,9,10});
			}
		} 

	private int Get_Single_Card_Value() {
		Random random = new Random ();
		int ra = random.nextInt(100);
		
		if (ra < 70) {
			return random.nextInt(5)+1;
		}else if (ra < 90) {
			return random.nextInt(4)+6;
		}else {
			return random.nextInt(4)+10;
		}
	}
	private Item Get_Random_Single_Card() { 
		
		int value = Get_Single_Card_Value(); // generate random value between 1 and 10 
	  return new SingleCard("Card " + value, value, new int[] {value}) ;
	   }
	

	
	public void Open_Shop_Menu() {
		Scanner scanner = new Scanner(System.in);
		boolean exitShop = false;
		
		while ( !exitShop) {
			System.out.println("Welcome to the Shop!");
			Select_Displayed_Items();
			System.out.println(" Your Currency: $" + currency);
			System.out.println("Available Items:");
			Display_Items();
			
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
										Purchase_Item(selectedItem);
										
										
										
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
		scanner.close();
	}
	
	private void Display_Items () {
		for (int i =0; i< displayedItems.size(); i++) { 
			Item item = displayedItems.get(i);
			System.out.println((i+1)+". " +item.getName() + " - Price: $" + item.getPrice());
			}
	  }
	private void Purchase_Item (Item item) { 
		item.applyEffect();
		currency -= item.getPrice();
		displayedItems.remove(item);
	  System.out.println("You Purchased: " + item.getName());
	  System.out.println("remaining Currency: $" + currency);
	  System.out.println("remaining Items in shop"); Display_Items();
	  
	  }
	public void Add_Currency(int amount) { 
		currency += amount;
		}
	  
	
	public void refreshShop() {
		Select_Displayed_Items();
	}
	
}