package recipes;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

import recipes.recipeClass.IngredientProperties;
import recipes.recipeClass.StepProperties;

public class recipeIO {
	protected static String filename = "RecipeDB.csv"; // to name output file
	public static void loadCSV(HashMap<String, recipeClass> recipes) {
		try {
			File F = new File(filename);
			FileInputStream Fin = new FileInputStream(F);
			InputStreamReader FIStream = new InputStreamReader(Fin);
			BufferedReader FReader = new BufferedReader(FIStream);
			String line;
			boolean skipHeader = true;
			while((line=FReader.readLine())!=null) {
				// skip first line
				if (skipHeader == true) {
					skipHeader = false;
					continue;
				}
				String[] parts = line.split(",");
				recipeClass newRecipe = new recipeClass();
				newRecipe.setName(parts[0]);
				newRecipe.setPrepTime(parts[1]);
				newRecipe.setCookTime(parts[2]);
				newRecipe.setTotalTime(parts[3]);
				String[] ingredients = parts[4].split(":");
				String[] volume = parts[5].split(":");
				String[] measurement = parts[6].split(":");
				String[] steps = parts[7].split(":");

				for (int i = 0; i < ingredients.length; i++) {
					double vol = Double.parseDouble(volume[i]);
					newRecipe.addItem(ingredients[i], vol, measurement[i]);
				}
				for (int i = 0; i < steps.length; i++) {
					newRecipe.addSteps(i+1, steps[i]);
				}
				recipes.put(newRecipe.getName(), newRecipe);
			}
			FReader.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void saveCSV(HashMap<String, recipeClass> recipes) {
		try {
			File F = new File(filename);
			FileOutputStream Fout = new FileOutputStream(F);
			OutputStreamWriter FOWriter = new OutputStreamWriter(Fout);
			BufferedWriter FWrite = new BufferedWriter(FOWriter);
			
			//write header
			FWrite.write("Name,Prep Time,Cook Time,Total Time,Ingredients,Indegeiedet Values,Ingredient Measurement,Steps\r\n");
			
			Set<String> keys = recipes.keySet();
			for (String k : keys) {
				recipeClass R = recipes.get(k);
				FWrite.write(R.name+",");
				FWrite.write(R.prepTime+",");
				FWrite.write(R.cookTime+",");
				FWrite.write(R.totalTime+",");
				
				String ingre = "";
				String vol = "";
				String measure = "";
				for(int i = 0; i < R.ingredients.size(); i++) {
					IngredientProperties ip = R.ingredients.get(i);
					ingre += ip.ingredient.getItemName() +":";
					String S = Double.toString(ip.amount);
					vol += S +":";
					measure += ip.measurements+":";
				}
				FWrite.write(ingre+",");
				FWrite.write(vol+",");
				FWrite.write(measure+",");

				String steps = "";
				for(int i = 0; i < R.steps.size(); i++) {
					StepProperties ip = R.steps.get(i);
					steps += ip.instruction+":";
				}
				FWrite.write(steps+"\r\n");
			}			
			FWrite.flush();
			FWrite.close();			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//function for test loading
	public static void main (String[] args) {
		HashMap<String, recipeClass> recipes = new HashMap<String, recipeClass>();
		loadCSV(recipes);
	}
}
