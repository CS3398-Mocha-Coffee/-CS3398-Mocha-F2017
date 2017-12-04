package recipes;

import java.util.ArrayList;

public class DisplayIngredients {
	private String info;
	
	public DisplayIngredients() {
		info = "";
	}
	/**
	 * print function prints the items name, qty, and units using @param item
	 * @return this string.
	 */
	public String print(Ingredient item) {
		return  (item.getName() + " x" + item.getQty() + " " + item.getUnit() + "\n");
	}
	
	/**
	 * display function takes @param sorted and concatenates a string with ingredient category headings with their
	 * respective ingredients. The function then @returns the string
	 */
	public String display(ArrayList<ArrayList<Ingredient>> sorted) {
		for (int index = 0; index < 20; index++) {
			if (!sorted.get(index).isEmpty()) {
				info += heading(index, sorted);
				info += " - " + items(index, sorted);
			}
		}
		return info;
	}
	
	/**
	 * Items creates list of ingredients concatenated into a string to @return
	 * using @param index and@param sorted
	 */
	private String items(int index, ArrayList<ArrayList<Ingredient>> sorted) {
		String items = "";
		for (int i = 0; i < sorted.get(index).size(); i++) {
			items += print(sorted.get(index).get(i));
		}
		items += "\n";
		return items;
	}
	
	/**
	 * heading uses @param index and @param sorted to determine proper heading to @return.
	 */
	private String heading(int index, ArrayList<ArrayList<Ingredient>> sorted) {
		if (index == 0) {
			return "Dairy Items:\n";
		}else if (index == 1) {
			return "Dairy Alternative Items:\n";
		}else if (index == 2) {
			return "Vegetable Items:\n";
		}else if (index == 3) {
			return "Fruit Items:\n";
		}else if (index == 4) {
			return "Spice & Seasoning Items:\n";
		}else if (index == 5) {
			return "Meat Items:\n";
		}else if (index == 6) {
			return "Fish Items:\n";
		}else if (index == 7) {
			return "Seafood Items:\n";
		}else if (index == 8) {
			return "Baking & Grain Items:\n";
		}else if (index == 9) {
			return "Bread & Snack Items:\n";
		}else if (index == 10) {
			return "Oil Items:\n";
		}else if (index == 11) {
			return "Nut Items:\n";
		}else if (index == 12) {
			return "Condiment Items:\n";
		}else if (index == 13) {
			return "Dessert Items:\n";
		}else if (index == 14) {
			return "Beverage Items:\n";
		}else if (index == 15) {
			return "Soup Items:\n";
		}else if (index == 16) {
			return "Legume Items:\n";
		}else if (index == 17) {
			return "Sauce Items:\n";
		}else if (index == 18) {
			return "Alcohol Items:\n";
		}else if (index == 19) {
			return "Added Sweetener Items:\n";
		}else {
			return "";
		}
	}
}
