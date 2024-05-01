package edu.mu.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class shop {
	/*DELETE THIS LINE TO UNCOMMENT
	 * 
	 * private List<Item> allItems; private List<Item> displayedItems; private int
	 * currency;
	 * 
	 * public shop() { allItems= new ArrayList<>(); displayedItems = new
	 * ArrayList<>(); currency = 0; Initialize_All_Items();
	 * Select_Displayed_Items(); }//test
	 * 
	 * private void Initialize_All_Items() { // ADD ANY ITEMS HERE ADD TO ALL ITEMS
	 * ARRAY } private void Select_Displayed_Items() { displayedItems.clear(); //
	 * clear existing display of items
	 * 
	 * 
	 * displayedItems.add(Get_Random_Single_Card()); displayedItems.add(new
	 * DeleteCardItem( what ever delete card ) ; displayedItems.add( new
	 * ShuffleShopItem( what ever shuffle shop);
	 * displayedItems.add(Get_Random_BoosterPack()); for ( int i = 0; i < 3; i ++)
	 * {// for how ever other items we would want to add
	 * displayedItems.add(Get_Random_Item()); } } private Item
	 * Get_Random_BoosterPack() { Random random = new Random(); int chance =
	 * random.nextInt(10);// generate random number between 0 and 9 if ( chance <
	 * some value ) { return new boosterpack ( BRONZE); // repeat for other
	 * boostpack values make it where it is garenteed 1 like if everythign fails
	 * then hit this type thing } } private Item Get_Random_Single_Card() { Random
	 * random = new Random(); int value = random.nextInt(10)+1; // generate random
	 * value between 1 and 10 return new SingleCard( whate ver it is assign Value
	 * here ); } private Item Get_Random_Item() { Random random = new Ramom();
	 * return allItems.get(random.nextInt(allItems.size()));
	 * 
	 * } public void Open_Shop_Menu() {
	 * 
	 * } private void Display_Items () { for (int i =0; i< displayedItems.size();
	 * i+) { Item item = displayedItems.get(i); system.out.println((i+1)+". " +
	 * item.getName() + " - Price: $" + item.getPrice()); }
	 * 
	 * } private void Purchase_Item (Item item) { item.applyEffect(); currency -=
	 * item.getPrice(); displayedItems.remove(item);
	 * System.out.println("You Purchased: " + item.getName());
	 * System.out.println("remaining Currency: $" + currency);
	 * System.out.println("remaining Items in shop"); Display_Items();
	 * 
	 * } public void Add_Currency(int amount) { currency += amount; }
	 * 
	 *///DELETE THIS LINE TO UNCOMMENT
}