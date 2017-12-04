package pantryPlanner.common;

import java.util.ArrayList;

public class FindSubstitutes {
	private ArrayList<String> subs;
	
	public FindSubstitutes() {
		subs = new ArrayList<String>();
	}
	
	public ArrayList<String> getSubs(Inventory pantry, Inventory recipe, Inventory missing) {
		for (int i = 0; i < missing.idNums.size(); i++) {
			findSubs(pantry, recipe, missing.idNums.get(i));
		}
		return subs;
	}
	
	public void findSubs(Inventory pantry, Inventory recipe, int id) {
		String line = "Substitute ";
		int modId = (id / 100) * 100;
		double qty = recipe.ingredients.get(id).getQty();
		if (pantry.ingredients.contains(modId)) {
			if (pantry.ingredients.get(modId).getQty() >= qty){
				line += recipe.ingredients.get(id).getName() + " for " + pantry.ingredients.get(modId).getName();
				subs.add(line);
			}
		}
	}
}
