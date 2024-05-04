package edu.mu.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.mu.item.Item;
import edu.mu.shop.shop;

class shopTest {
	private static shop Shop;
	@BeforeAll
	
	static void setUp() {
		Shop = new shop();
	}
	
	
	@Test
	public void test_AddCurrency() {
		
		int Start_Currancy = Shop.Get_Currency();
		int amount_to_add = 100;
		Shop.Add_Currency(amount_to_add);
		assertEquals(Start_Currancy + amount_to_add, Shop.Get_Currency());
		
	}

	@Test
	public void test_number_of_initial_displayed_items() {
	
	Shop.refreshShop();
	
	 List<Item> displayedItems = Shop.Get_Displayed_Items();
	assertNotNull(displayedItems);
	assertEquals(6,displayedItems.size());
	}
	
	@Test
	public void test_Refresh() { 
		Shop.refreshShop(); // set initial displayed items 
		
		List<Item> initialDisplay = new ArrayList<>(Shop.Get_Displayed_Items());
		
		Shop.refreshShop();
		
		List<Item> updatedDisplay = new ArrayList<>(Shop.Get_Displayed_Items());
		
		assertNotEquals(initialDisplay,updatedDisplay);
		
	}
}
