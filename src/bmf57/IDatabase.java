import java.util.ArrayList;
import java.util.Hashtable;

public class IDatabase {
	private static final String CSV_FILE = "/Users/bfordyce/eclipse-workspace/MyPantry/src/ingredients.csv";
	private static ArrayList<String> parcedFile = new ArrayList<String>();
	private static Hashtable<String, Ingredient> ingredients = new Hashtable<String, Ingredient>();
	
	public IDatabase() throws Exception {
		parcedFile = CSVUtils.getParsed(CSV_FILE);
		// Parse the information in each line and set the fields of the ingredients 
		// before putting them in a Hashtable.
		for (int i = 0; i < parcedFile.size(); i++) {
			String line = parcedFile.get(i);
			String[] details = line.split("\\s+");
			Ingredient temp = new Ingredient(details[0], details[1], details[2], "0");
			// Ingredient key = ingredient ID; value = ingredient
			ingredients.put(details[0], temp);
		}
	}
	
	public Ingredient getIngredient(double itemId) {
		String key = String.valueOf(itemId);
		return ingredients.get(key);
	}
}
