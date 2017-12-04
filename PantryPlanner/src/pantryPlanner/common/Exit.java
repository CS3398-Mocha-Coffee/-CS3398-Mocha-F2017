package pantryPlanner.common;

import java.util.Enumeration;
import java.util.Hashtable;

public class Exit {
	
	public static void save(Hashtable<Integer, Ingredient> inventory, String CSV_FILE) throws IngredientException {
		Enumeration<Integer> keys = inventory.keys();
		while(keys.hasMoreElements()){
        	int tempKey = keys.nextElement();
            Ingredient item = inventory.get(tempKey);
            int id = item.getId();
            String itemName = item.getName();
            	double qty = item.getQty();
            	String units = item.getUnit();
            	
            	// Code for saving to CSV file
        }
	}
}
