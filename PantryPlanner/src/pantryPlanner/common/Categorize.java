package pantryPlanner.common;

import java.util.ArrayList;
import java.util.Hashtable;

public class Categorize {
	private ArrayList<ArrayList<Ingredient>> sorted = new ArrayList<ArrayList<Ingredient>>();
	
	public Categorize() {
		// Initialize ArrayList of ArrayLists of Ingredients.
				for (int i = 0; i < 20; i++) {
					ArrayList<Ingredient> temp = new ArrayList<Ingredient>();
					sorted.add(temp);
				}
	}
	
	/**
	 * Categorize function takes @param ids and @param inventory, sorts items by ingredient category
	 * and @return an ArrayList of category ArrayList of ingredients.
	 */
	public ArrayList<ArrayList<Ingredient>> sort(ArrayList<Integer> ids, Hashtable<Integer, Ingredient> inventory) {
		for (int i = 0; i < ids.size(); i++) {
			if (ids.get(i) < 110000) {								// Dairy
				sorted.get(0).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 110000 && ids.get(i) < 120000) {	// Dairy Alternative
				sorted.get(1).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 120000 && ids.get(i) < 130000) {	// Vegetables
				sorted.get(2).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 130000 && ids.get(i) < 140000) {	// Fruits
				sorted.get(3).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 140000 && ids.get(i) < 150000) {	// Spices & Seasonings
				sorted.get(4).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 150000 && ids.get(i) < 160000) {	// Meats
				sorted.get(5).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 160000 && ids.get(i) < 170000) {	// Fish
				sorted.get(6).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 170000 && ids.get(i) < 180000) {	// Seafood
				sorted.get(7).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 180000 && ids.get(i) < 190000) {	// Baking & Grains
				sorted.get(8).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 190000 && ids.get(i) < 200000) {	// Bread Items & Snacks
				sorted.get(9).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 200000 && ids.get(i) < 210000) {	// Oils
				sorted.get(10).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 210000 && ids.get(i) < 220000) {	// Nuts
				sorted.get(11).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 220000 && ids.get(i) < 230000) {	// Condiments
				sorted.get(12).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 230000 && ids.get(i) < 240000) {	// Desserts
				sorted.get(13).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 240000 && ids.get(i) < 250000) {	// Beverages
				sorted.get(14).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 250000 && ids.get(i) < 260000) {	// Soups
				sorted.get(15).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 260000 && ids.get(i) < 270000) {	// Legumes
				sorted.get(16).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 270000 && ids.get(i) < 280000) {	// Sauces
				sorted.get(17).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 280000 && ids.get(i) < 290000) {	// Alcohol
				sorted.get(18).add(inventory.get(ids.get(i)));
			}else if (ids.get(i) >= 290000 && ids.get(i) < 300000) {	// Added Sweeteners
				sorted.get(19).add(inventory.get(ids.get(i)));
			}
		}
		return sorted;
	}
}
