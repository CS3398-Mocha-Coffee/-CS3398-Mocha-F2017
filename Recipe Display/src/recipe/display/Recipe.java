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
	private List<String> qDigits = new ArrayList<String>();
	private List<Recipe> recipes = new ArrayList<Recipe>();
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
	
	public List<Recipe> getRecipes(){
		return this.recipes;
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
	
	public void showIngredients() {
		for(String item : this.ingredients) {
			System.out.println(item);
		}
	}
	
	public String toString() {
		return "Recipe: " + this.name + "\nDirections: " + this.directions;
	}
	
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public void setCookTime(String t) {
		this.cookTime = t;
	}
	public void setPrepTime(String t) {
		this.prepTime = t;
	}
	public void setTotalTime(String t) {
		this.prepTime = t;
	}
	public void setQDigits(List<String> q) {
		this.qDigits = q;
	}
	
	public void setQuantities(List<String> q) {
		this.quantities = q;
	}
	
	
	
	

}
