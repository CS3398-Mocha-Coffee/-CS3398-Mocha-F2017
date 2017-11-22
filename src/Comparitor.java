package pantryPlanner.common;

import java.util.ArrayList;

public class Comparitor {
	private Inventory missing;
	private CheckQty qty = new CheckQty();
	private CheckSubstitutes findSubs;
	
	public Comparitor(Inventory pantry, Inventory recipe) throws IngredientException {
		missing = new Inventory(recipe.data);
		run(pantry, recipe);
		findSubs = new CheckSubstitutes(pantry, recipe);
	}
	
	/**
	 * run function iterates the ingredients required by the @param recipe and appends missing items/items with insufficient qty to the missing inventory.
	 * @throws IngredientException
	 */
	public void run(Inventory pantry, Inventory recipe) throws IngredientException {
		for(int i = 0; i < recipe.idNums.size(); i++) {
			int id = recipe.idNums.get(i);
			if (pantry.hasItem(id) == true) {
				qty.compare(pantry.ingredients.get(id), recipe.ingredients.get(id));
				if (!qty.hasSufficient()) {
					missing.addItem(recipe.ingredients.get(id));
				}else {
					qty.compareValues();
					missing.addItem(qty.getRequired());
				}
			}
		}
	}
	
	/**
	 *getMissing @returns missing --Invetory object of missing ingredients
	 */
	public Inventory getMissing() {
		return missing;
	}
	
	/**
	 * getSubs @returns a string with substitute suggestions.
	 */
	public String getSubs() {
		return findSubs.getSubInfo();
	}
	
	
}
