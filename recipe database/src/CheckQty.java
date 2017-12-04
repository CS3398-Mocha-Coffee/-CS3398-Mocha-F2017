package recipes;

public class CheckQty {
	private Ingredient onHand;
	public Ingredient required;
	private boolean sufficient;
	private double difference;
	private UnitConverter convert = new UnitConverter();

	public CheckQty() {
		
	}
	
	public void compare(Ingredient current, Ingredient needed) {
		sufficient = true;
		onHand = current;
		required = needed;
		simplify(onHand);
		simplify(required);
		checkUnits();
		compareValues();		
		difference = 0;
	}
	
	// Sufficient returns true if onHand has a sufficient amount of the ingredient for the recipe.
	public boolean hasSufficient() {
		return sufficient;
	}
	
	/**
	 * getRequired @returns the ingredient object with qty = (requiredQty - ohHandQty).
	 */
	public Ingredient getRequired() {
		return required;
	}
	
	/**
	 * checkUnits used recursion to convert the required units to the units of the onHand ingredient.
	 */
	public void checkUnits() {
		String unit1 = onHand.getUnit();
		String unit2 = required.getUnit();
		
		if (!unit1.equals(unit2)) {
			if (unit2.equals("oz")) {
				if (unit1.equals("cups") | unit1.equals("tbsp") | unit1.equals("tsp") | unit1.equals("pt") | unit1.equals("qt") | unit1.equals("gal")) {
					convert.oz_cups(required, true);
				}else if (unit1.equals("lb")) {
					convert.oz_lb(required, true);
				}else if (unit1.equals("kg") | unit1.equals("g")) {
					convert.kg_oz(required, false);
				}
			}else if (unit2.equals("kg")) {
				if (unit1.equals("lb") | unit1.equals("oz")) {
					convert.kg_oz(required, true);
				}else if (unit1.equals("g")) {
					convert.g_kg(required, false);
				}
			}else if (unit2.equals("g")) {
				convert.g_kg(required, true);
			}else if (unit2.equals("cups")) {
				if (unit1.equals("tbsp") | unit1.equals("tsp")) {
					convert.cups_tbsp(required, true);
				}else if (unit1.equals("pt") | unit1.equals("qt") | unit1.equals("gal")) {
					convert.pt_cups(required, false);
				}else if (unit1.equals("oz")) {
					convert.oz_cups(required, false);
				}
			}else if (unit2.equals("tbsp")) {
				if (unit1.equals("tsp")) {
					convert.tbsp_tsp(required, true);
				}else if (unit1.equals("pt") | unit1.equals("qt") | unit1.equals("gal") | unit1.equals("cups")) {
					convert.cups_tbsp(required, false);
				}
			}else if (unit2.equals("tsp")) {
				convert.tbsp_tsp(required, false);
			}else if (unit2.equals("gal")) {
				convert.gal_qt(required, true);
			}else if (unit2.equals("qt")) {
				if (unit1.equals("tbsp") | unit1.equals("tsp") | unit1.equals("pt") | unit1.equals("cups") | unit1.equals("oz")) {
					convert.qt_pt(required, true);
				}else if (unit1.equals("gal")) {
					convert.gal_qt(required, false);
				}
			}else if (unit2.equals("pt")) {
				if (unit1.equals("tbsp") | unit1.equals("tsp") | unit1.equals("cups") | unit1.equals("oz")) {
					convert.pt_cups(required, true);
				}else if (unit1.equals("gal") | unit1.equals("qt")) {
					convert.qt_pt(required, false);
				}
			}else if (unit2.equals("lb")) {
				if (unit1.equals("oz") | unit1.equals("g") | unit1.equals("kg"))
					convert.oz_lb(required, false);
			}
			checkUnits();
		}
	}
	
	/** 
	 * simplify unifies all units so that they can be compared.
	 * @param ingredient
	 */
	public void simplify(Ingredient ingredient) {
		String units = ingredient.getUnit();
		// remove any periods in the unit string and convert to lowercase
		units = units.toLowerCase();
		units = units.replaceAll("[.]", "");
		
		// standardize units
		if (units == "cup" || units == "c")
			units = "cups";
		else if (units == "ounces" || units == "ounce" || units =="fl oz" || units == "fluid ounces")
			units = "oz";
		else if (units == "lbs" || units == "pounds" || units == "pound")
			units = "lb";
		else if (units == "pint" || units == "pints")
			units = "pt";
		else if (units == "quart" || units == "quarts")
			units = "qt";
		else if (units == "kgs" || units == "kilogram" || units == "kilograms")
			units = "kg";
		else if (units == "grams" || units == "gram")
			units = "g";
		else if (units == "tablespoon" || units == "tablespoons")
			units = "tbsp";
		else if (units == "teaspoon" || units == "teaspoons")
			units = "tsp";
		else if (units == "mililiters" || units == "mililiter" || units == "mililitre" || units == "mililitres")
			units = "ml";
		else if (units == "gallon" || units == "galllons" || units == "gals")
			units = "gal";
		ingredient.setUnit(units);
	}
	
	/**
	 * Compares quantities and adjusts required qty
	 */
	public void compareValues() {
		if (onHand.getQty() >= required.getQty()) {
			required.setQty(0);
			sufficient = true;
			
		}else {
			difference = (required.getQty() - onHand.getQty());
			sufficient = false;
			required.setQty(difference);

		}
	}
	
	public double getDifference() {
		return difference;
	}
	
}
