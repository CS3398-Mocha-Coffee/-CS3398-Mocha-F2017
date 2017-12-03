	
/**
 * @author sfgib
 * @todo create a class that will take an inventory object as a parameter, 
 * save all the information to a CSV file. Then add another one that 
 * does the same thing in reverse (using CSVUtils). That way all of the
 *  pantry info will be saved using this on exit from the app, and then 
 *  call this method to restore the data when the app is opened.
 */

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


