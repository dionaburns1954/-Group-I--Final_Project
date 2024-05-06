package edu.mu.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.mu.item.Item;
import edu.mu.shop.Shop;

class shopTest {
	private static Shop Shop;
	@BeforeAll
	
	static void setUp() {
		Shop = edu.mu.shop.Shop.getInstance();
	}
	
	
	@Test
	public void test_AddCurrency() {
		
		int Start_Currancy = Shop.getCurrency();
		int amount_to_add = 100;
		Shop.addCurrency(amount_to_add);
		assertEquals(Start_Currancy + amount_to_add, Shop.getCurrency());
		
	}

	@Test
	public void test_number_of_initial_displayed_items() {
	
	Shop.refreshShop();
	
	 List<Item> displayedItems = Shop.getDisplayedItems();
	assertNotNull(displayedItems);
	assertEquals(6,displayedItems.size());
	}
	
	@Test
	public void test_Refresh() { 
		Shop.refreshShop(); // set initial displayed items 
		
		List<Item> initialDisplay = new ArrayList<>(Shop.getDisplayedItems());
		
		Shop.refreshShop();
		
		List<Item> updatedDisplay = new ArrayList<>(Shop.getDisplayedItems());
		
		assertNotEquals(initialDisplay,updatedDisplay);
		
	}
}
