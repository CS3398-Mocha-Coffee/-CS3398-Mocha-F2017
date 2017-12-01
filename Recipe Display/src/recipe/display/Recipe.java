package recipe.display;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	
	private static ArrayList<List<String>> timesFile = new ArrayList<List<String>>();
	private static ArrayList<List<String>> ingredientsFile = new ArrayList<List<String>>();
	private static ArrayList<List<String>> directionsFile = new ArrayList<List<String>>();
	private static ArrayList<List<String>> quantitiesFile = new ArrayList<List<String>>();
	
	private List<String> ingredients = new ArrayList<String>();
	private List<String> quantities = new ArrayList<String>();
	private List<Recipe> recipes = new ArrayList<Recipe>();
	private List<String> quantityDigits = new ArrayList<String>();
	private List<String> times = new ArrayList<String>();
	
	private String directions, name, totalTime, cookTime, prepTime;
	

	public Recipe(String name, String cookTime, String prepTime, String totalTime,
			String directions, List<String> ingredients, List<String> quantities) 
	{
		this.name = name;this.cookTime = cookTime;this.prepTime = prepTime;this.totalTime = totalTime;
		this.directions = directions;this.ingredients=ingredients;this.quantities=quantities;
	}
	
	public Recipe(String name, List<String> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<String> getIngredients(){
		return this.ingredients;
	}
	
	public void showIngredients() {
		for(String item : this.ingredients) {
			System.out.print(item);
		}
	}
	
	public String toString() {
		return  "Recipe: " + this.name +
				"\nTotal Time: " + this.totalTime +
				"\nCook Time: " + this.cookTime +
				"\nPrep Time: " + this.prepTime +
				"\nDirections: " + this.directions +
				"\nIngredients: " + this.ingredients.toString()+
				"\nQuantities: " + this.quantities;
	}
	
	public void setDirections(String directions) {
		this.directions = directions;
	}
	
	public void setQuantities(List<String> q) {
		this.quantities = q;
	}
	
	public void setQDigits(List<String>q) {
		this.quantityDigits = q;
	}
	
	public List<String> getQDigits(){
		return this.quantityDigits;
	}
	
	public void setTotalTime(String t) {
		this.totalTime = t;
	}
	
	public void setCookTime(String t) {
		this.cookTime = t;
	}
	
	public void setPrepTime(String t) {
		this.prepTime = t;
	}
	
}
