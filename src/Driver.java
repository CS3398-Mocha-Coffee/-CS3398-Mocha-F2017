import java.util.Hashtable;

public class Driver {
	private static Inventory pantry;
	private static final String CSV_FILE = "/Users/bfordyce/eclipse-workspace/MyPantry/src/ingredients.csv";
	private static Output out = new Output();
	
	
	public static void main(String[] args) throws Exception {
		IDatabase data = new IDatabase(CSV_FILE);
		pantry = new Inventory(data.getDatabase());
		pantry.addItem(100200, 5);
		pantry.addItem(110200, 3);
		pantry.addItem(120200, 8);
		pantry.addItem(130200, 5);
		pantry.addItem(140200, 6);
		
		
		out.write(pantry.listIngredients());
		

	}
}
