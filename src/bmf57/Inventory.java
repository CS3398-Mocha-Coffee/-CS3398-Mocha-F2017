import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class Inventory {
	private static Hashtable<String, Ingredient> ingredients = new Hashtable<String, Ingredient>();
	private static ArrayList<Double> idNums = new ArrayList<Double>();
	private static IDatabase data;
	
	//public Inventory() throws Exception {
	public static void main(String[] args) throws Exception {
		data = new IDatabase();
		System.out.println(data.getIngredient(1002).getName());
	}
	public static void addItem(double itemId, double qty) {
		if (hasItem(itemId)) {	
			incrementQty(itemId, qty);
		}else {
			ingredients.put(String.valueOf(itemId), data.getIngredient(itemId));
			idNums.add(itemId);
			Collections.sort(idNums);
		}
	}
	public static void removeItem(double itemId) throws IngredientException {
		if (hasItem(itemId)) {
			ingredients.remove(String.valueOf(itemId));
			idNums.remove(itemId);
		}else {
			throw new IngredientException("Item Not Found!");
		}
	}
	public static void editQty(double itemId, double qty) throws IngredientException {
		if (hasItem(itemId)  & qty >= 0) {
			if (qty == 0)
				removeItem(itemId);
			else
				(ingredients.get(String.valueOf(itemId))).setQty(qty);
		}else {
			throw new IngredientException("Item Not Found!");
		}
	}
	public static void incrementQty(double itemId, double qty) {
		if (hasItem(itemId)) {
			(ingredients.get(String.valueOf(itemId))).incrementQty(qty);
		}else {
			addItem(itemId, qty);
		}
	}
	public static void decrementQty(double itemId, double qty) throws IngredientException {
		if (hasItem(itemId)) {
			if (ingredients.get(String.valueOf(itemId)).getQty() > qty) {
				ingredients.get(String.valueOf(itemId)).decrementQty(qty);
			}else {
				removeItem(itemId);
			}
		}else {
			throw new IngredientException("Item Not Found!");
		}
	}
	public static boolean hasItem(double itemId) {
		return idNums.contains(itemId);
	}
}
