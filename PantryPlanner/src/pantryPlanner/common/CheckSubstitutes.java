package pantryPlanner.common;

public class CheckSubstitutes {
	private Inventory substituted;
	private String subInfo = "";
	private CheckQty check = new CheckQty();
	private boolean found = false;
	
	public CheckSubstitutes(Inventory pantry, Inventory recipe) throws IngredientException {
		substituted = new Inventory(pantry.data);
		findSubs(pantry, recipe);
	}
	
	public String getSubInfo() {
		return subInfo;
	}
	
	public void findSubs(Inventory pantry, Inventory recipe) throws IngredientException {
		for (int i = 0; i < recipe.idNums.size(); i++) {
			int rModId = (recipe.idNums.get(i) / 100) * 100;
			for (int j = 0; j < pantry.idNums.size(); j++) {
				String line = "Substitute ";
				double pModId = (pantry.idNums.get(j) / 100) * 100;
				if (pModId == rModId) {
					check.compare(pantry.ingredients.get(pantry.idNums.get(j)), recipe.ingredients.get(recipe.idNums.get(i)));
					if (check.hasSufficient()){
						line += pantry.ingredients.get(pantry.idNums.get(j)).getName() + " for " + recipe.ingredients.get(recipe.idNums.get(i)).getName() ;
						subInfo += (line + "\n");
						substituted.addItem(recipe.ingredients.get(recipe.idNums.get(i)));
						found = true;
					}
				}
			}
		}
	}

	public Inventory getSubstituted() {
		return substituted;
	}
	
	public boolean found() {
		return found;
	}
	
}