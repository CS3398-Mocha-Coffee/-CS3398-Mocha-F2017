package pantryPlanner.common;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class IDatabase {
	private static ArrayList<List<String>> parcedFile = new ArrayList<List<String>>();
	private static Hashtable<Integer, Ingredient> ingredients = new Hashtable<Integer, Ingredient>();
 
	public IDatabase(String csvFile) throws Exception {
		parcedFile = CSVUtils.getParsed(csvFile);
		// Parse the information in each line and set the fields of the ingredients 
		// before putting them in a Hashtable.
		for (int i = 0; i < parcedFile.size(); i++) {
			List<String> item = parcedFile.get(i);
			for (int j = 0; j < 3; j++) {
				Ingredient temp = new Ingredient(item.get(0), item.get(1), item.get(2), "0");
				// Ingredient key = ingredient ID; value = ingredient
				ingredients.put(Integer.parseInt(item.get(0)), temp);
			}
		}
	}
	
	/**
	 * getDatabase @return a Hashtable database that was read from CSV file.
	 */
	public  Hashtable<Integer, Ingredient> getDatabase() {
		return ingredients;
	}
	public Ingredient getIngredient(int itemId) {
		return ingredients.get(itemId);
	}
}
