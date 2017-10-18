package ingrediants;

abstract public class Dessert extends Ingredient {
	public Dessert() {
		parishable = true;
		refridgerated = false;
		itemName = "Dessert Item";
		measurement = "oz";
	}
}