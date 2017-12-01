package pantryPlanner.common;

import java.util.Enumeration;
import java.util.Hashtable;

public class FindId {
	public Hashtable<String, Integer> ingredients = new Hashtable<String, Integer>();
	
	public FindId(Hashtable<Integer, Ingredient> database) {
		process(database);
	}
	
	public void process(Hashtable<Integer, Ingredient> database) {
		Enumeration<Integer> keys = database.keys();
        while(keys.hasMoreElements()){
        	int key = keys.nextElement();
            String name = database.get(key).getName();
            ingredients.put(name, key);
        }
	}
	
	public int getId(String name) throws IngredientException {
		if (ingredients.containsKey(name))
			return ingredients.get(name);
		else{
			throw new IngredientException("Item Not Found!");
		}
	}
}
