package pantryPlanner.common;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Open {
	
	public static Hashtable restore(String csvFile) throws Exception {
		ArrayList<List<String>> parcedFile = new ArrayList<List<String>>();
		Hashtable<Integer, Ingredient> ingredients = new Hashtable<Integer, Ingredient>();
		
		parcedFile = CSVUtils.getParsed(csvFile);
		// Parse the information in each line and set the fields of the ingredients 
		// before putting them in a Hashtable.
		for (int i = 0; i < parcedFile.size(); i++) {
			List<String> item = parcedFile.get(i);
			for (int j = 0; j < 3; j++) {
				Ingredient temp = new Ingredient(item.get(0), item.get(1), item.get(2), item.get(3));
				// Ingredient key = ingredient ID; value = ingredient
				ingredients.put(Integer.parseInt(item.get(0)), temp);
			}
		}
		return ingredients;
	}
}
