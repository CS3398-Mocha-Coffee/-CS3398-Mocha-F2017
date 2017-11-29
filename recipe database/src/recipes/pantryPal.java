package recipes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.io.BufferedReader;

public class pantryPal {
	
	HashMap<String, recipeClass> recipes;
	pantryPal(){
		recipes = new HashMap<String, recipeClass>();
		loadRecipeDB();
	}

	void loadRecipeDB(){
		recipeIO.loadCSV(recipes);
	}

	void saveRecipeDB() {
		recipeIO.saveCSV(recipes);
	}

	List<recipeClass> searchName(String S) {
		List<recipeClass> found = new ArrayList<recipeClass>();
		Set<String> keys = recipes.keySet();
		for (String k : keys) {
			recipeClass R = recipes.get(k);
			if (R.findName(S) != null) {
				found.add(R);
			}
		}
		return found;
	}

	List<recipeClass> searchIngredients(String S) {
		List<recipeClass> found = new ArrayList<recipeClass>();
		Set<String> keys = recipes.keySet();
		for (String k : keys) {
			recipeClass R = recipes.get(k);
			if (R.getIngredient(S) != null) {
				found.add(R);
			}
		}
		return found;
	}
	
	boolean removeRecipe(String S){
		Set<String> keys = recipes.keySet();
		for (String k : keys) {
			recipeClass R = recipes.get(k);
			if (R.findName(S) != null) {
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char choice = 'k';
		pantryPal P = new pantryPal();
		System.out.println("Welcome to Pantry Pal!");
		String criteria = "";
		while(choice != 'E'&&choice !='e') {
			System.out.println("Press A to add recipes");
			System.out.println("Press R to remove recipes by name");
			System.out.println("Press N to search recipes by name");
			System.out.println("Press I to search recipes by ingredient");
			System.out.println("Press E to exit program");
			choice = (char) System.in.read();
			
			if (choice == 'A'||choice =='a') {
				System.out.println("Might need integration with add recipe code");
			}
			if (choice == 'R'||choice =='r') {
				System.out.println("Input case sensative recipe to be removed");
				criteria = reader.readLine();
				criteria = reader.readLine();
				if (P.removeRecipe(criteria)) {
					P.recipes.remove(criteria);
				}
			}
			if (choice == 'N'||choice =='n') {
				System.out.println("Input recipe name");
				criteria = reader.readLine();
				criteria = reader.readLine();
				List<recipeClass> foundList = P.searchName(criteria);
				for(recipeClass R : foundList) {
					System.out.println(R.name);
				}
			}
			if (choice == 'I'||choice =='i') {
				System.out.println("Input ingredient name");
				criteria = reader.readLine();
				criteria = reader.readLine();
				List<recipeClass> foundList = P.searchIngredients(criteria);
				for(recipeClass R : foundList) {
					System.out.println(R.name);
				}
			}
		}

		System.out.println("Number of recipes in DB: "+P.recipes.size());
		P.saveRecipeDB();
		return;
	}
}