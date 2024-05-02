package edu.mu.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import edu.mu.item.DeleteCardItem;
import edu.mu.item.Item;
import edu.mu.item.SingleCard;

public class shop {


	  
	private List<Item> allItems; 
	private List<Item> displayedItems; 
	private int currency;
	  
	  
	  
	public shop() { 
		allItems= new ArrayList<>(); 
		displayedItems = new ArrayList<>();
		currency = 0;
		Initialize_All_Items();
	    Select_Displayed_Items();
	    }//test
	  
	private void Initialize_All_Items() { // ADD ANY ITEMS HERE ADD TO ALL ITEMS
		displayedItems.add(new SingleCard("Card A", 5, new int[] {1, 2, 3, 4, 5}));
		displayedItems.add(new DeleteCardItem("Delete Card", 10, null));
	//displayedItems.add(new ResetShop("re roll items ", 10, null));
	
	}
	private void Select_Displayed_Items() {
		displayedItems.clear();
	  
	  displayedItems.add(Get_Random_Single_Card());
	  displayedItems.add(new DeleteCardItem("Delete Card", 10, null));
	 // displayedItems.add(new ResetShop("re Roll items", 10, null)); 
	 // displayedItems.add(Get_Random_BoosterPack());
	  for ( int i = 0; i < 3; i ++) {// for how ever other items we would want to add
		  displayedItems.add(Get_Random_Item());
		  } 
	  }
	
	//private Item Get_Random_BoosterPack() {
		//Random random = new Random();
		//int chance =random.nextInt(10);// generate random number between 0 and 9 
		//if ( chance < /*some value */){ 
		//	return new boosterpack ( BRONZE); // repeat for other boosterpack values make it where it is guaranteed 1 like if everything fails then hit this type thing 
	//	} 
	//} 
	
	private Item Get_Random_Single_Card() { 
		Random random = new Random();
		int value = random.nextInt(10)+1; // generate random value between 1 and 10 
	  return new SingleCard("Card A", 5, new int[] {1, 2, 3, 4, 5} );
	   }
	
	private Item Get_Random_Item() {
		Random random = new Random();
	  return allItems.get(random.nextInt(allItems.size()));
	  
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
								int itemNumber = Integer.parseInt(input);
								if ( itemNumber >= 0 && itemNumber < displayedItems.size()) {
									Item selectedItem = displayedItems.get(itemNumber);
									if ( currency >= selectedItem.getPrice()) {
										Purchase_Item(selectedItem);
										
										
										validInput = true;
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