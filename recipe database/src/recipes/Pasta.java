package recipes;

public class Pasta extends recipeClass{
	public Pasta() {
		name = "Pasta with tomato sauce";
		prepTime = "10 minutes";
		cookTime = "10 minutes";
		totalTime = "20 mintues";
		favorites = false;
		
		addItem("spagetti", 12, "oz");
		addSteps(1, "Boil water");
		addTags("Italian");
	}
}
