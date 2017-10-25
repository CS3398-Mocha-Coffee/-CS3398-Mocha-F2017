package recipes;
import java.util.*;

import ingrediants.Ingredient;

public class recipeClass {

	public class IngredientProperties {
		Ingredient ingredient;
		double amount;
		String measurements;
		IngredientProperties() {}
		IngredientProperties(Ingredient type, double volume, String measurement) {
			IngredientProperties newItem = new IngredientProperties();
			newItem.ingredient = type;
			newItem.amount = volume;
			newItem.measurements = measurement;
		}
		String getName() { return ingredient.getItemName(); }
	}

	public class StepProperties{
		int orderNumber;
		String instruction;
		StepProperties(){}
		StepProperties(int order, String direction){
			StepProperties newSteps = new StepProperties();
			newSteps.orderNumber = order;
			newSteps.instruction = direction;
		}
	}
	
	public class TagProperties{
		String tags;
		TagProperties(){}
		TagProperties(String category){
			TagProperties newTag = new TagProperties();
			newTag.tags = category;
		}
	}

	protected String name;
	protected String prepTime;
	protected String cookTime;
	protected String totalTime;
	protected Vector<IngredientProperties> ingredients = new Vector<IngredientProperties>();
	protected Vector<StepProperties> steps = new Vector<StepProperties>();
	protected Vector<TagProperties> tags = new Vector<TagProperties>();
	protected boolean favorites;
	
	public String getName() {
		return this.name;
	}
	
	public String getPrepTime() {
		return this.prepTime;
	}

	public String getCookTime() {
		return this.cookTime;
	}

	public String getTotalTime() {
		return this.totalTime;
	}

	public boolean getFavorite( ) {
		return this.favorites;
	}

	public IngredientProperties getIngredient(int itemNumber) {
		return this.ingredients.get(itemNumber);
	}

	public IngredientProperties getIngredient(String itemName) {		
		IngredientProperties ing = null;
		for(int i=0; i<this.ingredients.size(); i++) {
			
			IngredientProperties ip = this.ingredients.get(i);
			if (ip.getName()==itemName) {
				ing = ip;
				break;
			}
		}
		return ing;
	}

	public void addItem(IngredientProperties newItem) {
		this.ingredients.add(newItem);
	}

	public void addItem(String itemName, double volume, String measurement) {
		Ingredient ingre = null;
		ingre.setItemName(itemName);

		this.ingredients.add(new IngredientProperties(ingre, volume, measurement));
	}


	public StepProperties getSteps(int stepNumber){
		return this.steps.get(stepNumber);
	}

	public void addSteps(int order, String directions) {
		this.steps.add(new StepProperties(order, directions));
	}

	public boolean hasTag(String category){
		
		for(TagProperties cur : this.tags) {
			if( cur.tags.equalsIgnoreCase(category))
				return true;
		}
		return false;
		
	}

	public void addTags(String category) {
		this.tags.add(new TagProperties(category));
	}
	
	public void setName(String n) {
		this.name = n;
	}

	public void setPrepTime(String p) {
		this.prepTime = p;
	}

	public void setCookTime(String c) {
		this.prepTime = c;
	}
	
	public void setTotalTime(String t) {
		this.prepTime = t;
	}

	public void setFavorite(boolean f) {
		this.favorites = f;
	}
}