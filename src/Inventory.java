package pantryPlanner.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Inventory {
	public Hashtable<Integer, Ingredient> data = new Hashtable<Integer, Ingredient>();
	public Hashtable<Integer, Ingredient> ingredients = new Hashtable<Integer, Ingredient>();
	public ArrayList<Integer> idNums = new ArrayList<Integer>();
	
	/**
	 * Constructor takes @param database and stores contents in a Hashtable as a local database
	 */
	public Inventory(Hashtable<Integer, Ingredient> database) {
		data.putAll(database);
	}
	
	
	/**
	 * addItem takes @param itemId and @param qty and either adds a new ingredient to the inventory
	 * or increments the ingredient if one already exists. @throws IngredientException 
	 */
	public void addItem(int itemId, double qty) throws IngredientException {
		if (hasItem(itemId)) {	
			incrementQty(itemId, qty);
		}else {
			ingredients.put(itemId, retrieve(itemId, qty));
			idNums.add(itemId);
			Collections.sort(idNums);
		}
	}
	public void addItem(Ingredient item) throws IngredientException {
		if (hasItem(item.getId())) {	
			CheckQty check = new CheckQty();
			check.simplify(item);
			check.simplify(ingredients.get(item.getId()));
			if (item.getUnit().equals(ingredients.get(item.getId()).getUnit()))
				incrementQty(item.getId(), item.getQty());
			else {
				check.checkUnits();
				incrementQty(item.getId(), check.required.getQty());
			}
		}else {
			ingredients.put(item.getId(), retrieve(item.getId(), item.getQty()));
			idNums.add(item.getId());
			Collections.sort(idNums);
		}
	}
	/**
	 * removeItem takes @param itemId and removes the specified item if one exists, 
	 * @throws IngredientException otherwise.
	 */
	public void removeItem(int itemId) throws IngredientException {
		if (hasItem(itemId)) {
			ingredients.remove(itemId);
			idNums.remove(itemId);
		}else {
			throw new IngredientException("Item Not Found!");
		}
	}
	/**
	 * editQuantitiy allows the user to change the quantity of ingredient @param itemId with
	 *  a specified @param qty, and @throws IngredientException if item does not exist.
	 */
	public void editQty(int itemId, double qty) throws IngredientException {
		if (hasItem(itemId)  & qty >= 0) {
			if (qty == 0)
				removeItem(itemId);
			else
				(ingredients.get(itemId)).setQty(qty);
		}else {
			throw new IngredientException("Item Not Found!");
		}
	}
	/**
	 * incrementQty increments @param itemId by @param qty
	 * @throws IngredientException if qty < 0
	 */
	public void incrementQty(int itemId, double qty) throws IngredientException {
		if (qty >= 0) {
			if (hasItem(itemId)) {
				(ingredients.get(itemId)).incrementQty(qty);
			}else {
				addItem(itemId, qty);
			}
		}else {
			throw new IngredientException("**Increment with positive Qty only**");
		}
	}
	/**
	 * decrementQty increments @param itemId by @param qty
	 * @throws IngredientException if qty < 0
	 */
	public void decrementQty(int itemId, double qty) throws IngredientException {
		if (qty >= 0) {
			if (hasItem(itemId)) {
				if (ingredients.get(itemId).getQty() > qty) {
					ingredients.get(itemId).decrementQty(qty);
				}else {
					removeItem(itemId);
				}
			}else {
				throw new IngredientException("Item Not Found!");
			}
		}else {
			throw new IngredientException("**Decrement with positive Qty only**");
		}
	}
	/**
	 * hasItem checks if @param itemId is in inventory
	 * @return True if ingredient exists, False otherwise.
	 */
	public boolean hasItem(int itemId) {
		return idNums.contains(itemId);
	}
	/**
	 * getIngredient @return a copy of an @param itemId in the inventory
	 * @throws IngredientException if ingredient not found.
	 */
	public Ingredient getIngredient(int itemId) throws IngredientException {
		if (hasItem(itemId))
			return ingredients.get(itemId);
		else
			throw new IngredientException("Item Not Found!");
	}
	/**
	 * retrieve finds an ingredient details for @param itemId and
	 * @return an ingredient object with quantity set to @param qty
	 */
	public Ingredient retrieve(int itemId, double qty) {
		Ingredient temp = data.get(itemId);
		temp.setQty(qty);
		return temp;
	}
	/**
	 * list Ingredients uses the Categorize class and the DisplayItem class to form a cancatenated string
	 * to  @return and print an itemized list of ingredients.
	 */
	public String listIngredients() {
		Categorize categorize = new Categorize();
		DisplayIngredients itemize = new DisplayIngredients();
		return itemize.display(categorize.sort(idNums, ingredients));
	}
}
