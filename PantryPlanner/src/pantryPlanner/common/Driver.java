package pantryPlanner.common;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Driver {
	private static Inventory pantry;
	private static Inventory recipe;
	private static final String CSV_FILE = "/Users/ajmor/eclipse-workspace/PantryPlanner/src/pantryPlanner/databases/ingredients.csv";
	private static Output out = new Output();
	
	
	public static void main(String[] args) throws Exception {
		IDatabase data = new IDatabase(CSV_FILE);
		
		pantry = new Inventory(data.getDatabase());
		recipe = new Inventory(data.getDatabase());
		FindId find = new FindId(data.getDatabase());
		
		Hashtable<String, Integer> ingredients = new Hashtable<String, Integer>();
		
		
 
		
		int id = find.getId("Milk");
		System.out.println(id);
		
		
		
		pantry.addItem(100200, 5);
		pantry.addItem(110200, 3);
		pantry.addItem(120200, 8);
		pantry.addItem(130200, 5);
		pantry.addItem(140200, 6);
		
		recipe.addItem(100202, 3);
		
		//Comparitor comp = new Comparitor(pantry, recipe);
		
		
		
		
		
		out.write(pantry.listIngredients());
		//System.out.println(comp.getSubs());
		
		CheckQty comp = new CheckQty();
		
		Ingredient req = data.getIngredient(100200);
		req.setQty(1);
		req.setUnit("gal");
		
		Ingredient have = data.getIngredient(100200);
		have.setQty(0);
		
		comp.compare(have, req);
		
		System.out.println(comp.hasSufficient());
		System.out.println(comp.getRequired().getQty() + " " + comp.getRequired().getUnit() + " " + comp.getRequired().getName());
		
	
		

	}
}
