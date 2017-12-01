package recipe.display;
import java.util.ArrayList;
import java.util.List;
import ingredient.utilities.CSVUtils;

public class RecipeManager {
	private static ArrayList<List<String>> timesFile = new ArrayList<List<String>>();
	private static ArrayList<List<String>> ingredientsFile = new ArrayList<List<String>>();
	private static ArrayList<List<String>> directionsFile = new ArrayList<List<String>>();
	private static ArrayList<List<String>> quantitiesFile = new ArrayList<List<String>>();
	private List<Recipe> recipes = new ArrayList<Recipe>();

	public RecipeManager() {
		try {
			initRecipes();
			initDirections();
			initQuantities();
			initTimes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initRecipes() throws Exception{
		int i = 0;
		ingredientsFile = CSVUtils.getParsed("src/recipe ingredients.csv");
		List<String> ingredients = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
 		//gets ingredients
		for (List<String> item : ingredientsFile) {
			for(String name : item) {
				if(name.contains("[") && name.contains("]")) {//filters out name
					name = name.replace("[", "");
					name = name.replace("]", "");
					name = name.replace("'", "");
					name = name.replaceAll("\"",""); 
					name = name.replace("  ", " ");
					names.add(name); //puts the name in array
					if(i > 0) { //filters out first name from ingredients
						ingredients.add("BREAK"); // signifies the end of ingredients for 
												  // all recipe names after the first name
					}
					i++;
				}
				else {
					if(!name.contains("Name") && !name.contains("Quantity") && !name.contains("Ingredients")) {
						name = name.replace("[", "");
						name = name.replace("]", "");
						name = name.replace("'", "");
						name = name.replace("  ", " ");
						if(!name.equals(""))
							ingredients.add(name); //adds the ingredients to list
					}
				}
			}
		}
		
//		for(String name : names) {
//			System.out.println(name);
//		}
		
			//instead of initializing all members, it may be better to set some later
		//THIS IS WHERE RECIPE OBJECT CREATION STARTS
		int n = 0; // name counter
		for(int j = 0; j < ingredients.size(); j++) { //goes through ingredients
			List<String> recipeIngredients = new ArrayList<String>();
			while (ingredients.get(j) != "BREAK") { //sorts them for every recipe
				recipeIngredients.add(ingredients.get(j)); //adds them to a temp list
				j++; 
				if (j == ingredients.size()) {
					break; //controls out of bounds error
				}
			}
				this.recipes.add(new Recipe(names.get(n), recipeIngredients));
				n++;
		}
		
//		System.out.println(getRecipes().get(recipes.size()-1));
//		System.out.println(getRecipes().get(recipes.size()-2));
//		System.out.println(recipes.size());
		
	}
	
	private void initDirections() throws Exception {
		directionsFile = CSVUtils.getParsed("src/recipe directions.csv");
		List<String> directions = new ArrayList<String>();
		for (List<String> item : directionsFile) {
			for(String dir : item) {
				if(dir.contains("[") && dir.contains("]")) { 
					directions.add(dir);
				}
			}
		}
		
		int i = 1;
		List<String> dirs = new ArrayList<String>();
		for(String d : directions) {
			if(i+2 <= directions.size())
				dirs.add(directions.get(i));
			i+=2;	
		}
		
		dirs.add(directions.get(directions.size()-1));
		int r = 0;
		for(String d: dirs) {
			d= d.replace("[", "");
			d = d.replace("]", "");
			d = d.replace("\"", "");
			d = d.replace("'", "");
			d = d.replace(",", "");
			this.recipes.get(r).setDirections(d);
			r++;
		}
	}
	
	private void initQuantities() throws Exception {
		int i = 0;
		quantitiesFile = CSVUtils.getParsed("src/recipe quantites.csv");
		List<String> quantities = new ArrayList<String>();
		for (List<String> q: quantitiesFile) {
			for(String item : q) {
				if(item.contains("[") && item.contains("]")) { //finds name
					if(i > 0) { //skips first name 
						quantities.add("BREAK");
					}
					i++;
				}
				else {
					if(!item.equals("")) {
						item = item.replace("'", "");
						item = item.replace("[", "");
						item = item.replace("]", "");
						item = item.replace("()", "");
						item = item.trim();
						quantities.add(item);
					}
				}
			}
		}
		
		for(String item : quantities) {
			
		}
		
		int n = 0;
		for(int j = 0; j < quantities.size(); j++) { //goes through quantities
			List<String> recipeQuantities = new ArrayList<String>();
			List<String> qDigits = new ArrayList<String>();
			while (quantities.get(j) != "BREAK") { //sorts them for every recipe
				qDigits.add(quantities.get(j));
				recipeQuantities.add(quantities.get(j)); //adds them to a temp list
				j++; 
				if (j == quantities.size()) {
					break; //controls out of bounds error
				}
			}
			if(n < recipes.size()) {
				int k = 0;
				String q;
				for(String item : recipes.get(n).getIngredients()) {
					recipeQuantities.set(k, recipeQuantities.get(k)+item);
					k++;
				}
				recipes.get(n).setQDigits(qDigits);
				recipes.get(n).setQuantities(recipeQuantities);
				n++;
			}
		}
	}
	
	public List<Recipe> getRecipes(){
		return this.recipes;
	}
	
	public void addRecipe(Recipe r) {
		recipes.add(r);
	}
	public boolean recipeExists(String recipeName) {
		for (Recipe recipe : this.recipes) {
			System.out.println("INPUT: " + recipeName);
			System.out.println("ARRAY: " + recipe);
			if(recipe.getName() == recipeName) {
				return true;
			}
		}
		return false;
	}
	
	private void initTimes() throws Exception {
		timesFile = CSVUtils.getParsed("src/recipe times.csv");
		List<String> t = new ArrayList<String>();
		int r = 0;
		for (int i = 1; i < timesFile.size(); i++) {
			for(int k = 1; k < timesFile.get(i).size(); k++) {
				if(r < recipes.size()) {
					recipes.get(r).setTotalTime(timesFile.get(i).get(k));
					recipes.get(r).setCookTime(timesFile.get(i).get(k+1));
					recipes.get(r).setPrepTime(timesFile.get(i).get(k+2));
					r++;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeManager recipes1 = new RecipeManager();
		for(Recipe r : recipes1.getRecipes()) {
			System.out.println(r);
		}
	}

}
