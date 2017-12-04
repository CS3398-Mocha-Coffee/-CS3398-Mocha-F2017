package pantryPlanner.common;

import java.util.Enumeration;
import java.util.Hashtable;

public class RecipeInventory {
	private FindId find;
	private Inventory required;
	
	/**
	 * RecipeInventory takes @param database
	 */
	public RecipeInventory(Hashtable<Integer, Ingredient> database) {
		find = new FindId(database);
		required = new Inventory(database);
	}
	
	// Loops through hashtable of names and quantities and envokes the invetory's add method to create an ingredient object to store.
	public Inventory getInventory(Hashtable<String, Double> recipe) throws IngredientException {
		Enumeration<String> keys = recipe.keys();
        while(keys.hasMoreElements()){
        		String name = keys.nextElement();
            double qty = recipe.get(name);
            int id = find.getId(name);
            required.addItem(id, qty);
        }
        return required;
	}
}
