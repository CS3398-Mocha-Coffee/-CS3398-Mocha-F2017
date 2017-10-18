package ingrediants;

abstract public class Ingredient {
	// Boolean attributes for sorting
	protected boolean parishable;
	protected boolean refridgerated;
	protected String itemName;
	protected String measurement = "qty";
	
	// Getter and Setter methods
	public boolean isRefridgerated() {
		return refridgerated;
	}
	public void setRefridgerated(boolean refridgerated) {
		this.refridgerated = refridgerated;
	}
	public boolean isParishable() {
		return parishable;
	}
	public void setParishable(boolean parishable) {
		this.parishable = parishable;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}

