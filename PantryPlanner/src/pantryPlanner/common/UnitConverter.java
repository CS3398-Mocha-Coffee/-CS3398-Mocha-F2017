package pantryPlanner.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UnitConverter {
	public void kg_oz(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "kg") {
				item.setUnit("oz");
				item.setQty(round(item.getQty() * 35.274, 2));
			}
		}else {
			if (item.getUnit() == "oz") {
				item.setUnit("kg");
				item.setQty(round(item.getQty() / 35.274, 2));
			}
		}
	}
	public void g_kg(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "g") {
				item.setUnit("kg");
				item.setQty(round(item.getQty() / 1000.0, 2));
			}
		}else {
			if (item.getUnit() == "kg") {
				item.setUnit("g");
				item.setQty(round(item.getQty() * 1000.0, 2));
			}
		}
	}
	public void oz_lb(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "oz") {
				item.setUnit("lb");
				item.setQty(round(item.getQty() / 16.0, 2));
			}
		}else {
			if (item.getUnit() == "lb") {
				item.setUnit("oz");
				item.setQty(round(item.getQty() * 16.0, 2));
			}
		}
	}
	public void gal_qt(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "gal") {
				item.setUnit("qt");
				item.setQty(round(item.getQty() * 4.0, 2));
			}
		}else {
			if (item.getUnit() == "qt") {
				item.setUnit("gal");
				item.setQty(round(item.getQty() / 4.0, 2));
			}
		}
	}
	public void qt_pt(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "qt") {
				item.setUnit("pt");
				item.setQty(round(item.getQty() * 2.0, 2));
			}
		}else {
			if (item.getUnit() == "pt") {
				item.setUnit("qt");
				item.setQty(round(item.getQty() / 2.0, 2));
			}
		}
	}
	public void pt_cups(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "pt") {
				item.setUnit("cups");
				item.setQty(round(item.getQty() * 2, 2));
			}
		}else {
			if (item.getUnit() == "cups") {
				item.setUnit("pt");
				item.setQty(round(item.getQty() / 2, 2));
			}
		}
	}
	public void oz_cups(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "oz") {
				item.setUnit("cups");
				item.setQty(round(item.getQty() / 8, 2));
			}
		}else {
			if (item.getUnit() == "cups") {
				item.setUnit("oz");
				item.setQty(round(item.getQty() * 8, 2));
			}
		}
	}
	public void cups_tbsp(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "cups") {
				item.setUnit("tbsp");
				item.setQty(round(item.getQty() * 16, 2));
			}
		}else {
			if (item.getUnit() == "tbsp") {
				item.setUnit("cups");
				item.setQty(round(item.getQty() / 16, 2));
			}
		}
	}
	public void tbsp_tsp(Ingredient item, boolean forward) {
		if (forward) {
			if (item.getUnit() == "tbsp") {
				item.setUnit("tsp");
				item.setQty(round(item.getQty() * 3, 2));
			}
		}else {
			if (item.getUnit() == "tsp") {
				item.setUnit("tbsp");
				item.setQty(round(item.getQty() / 3, 2));
			}
		}
	}
	// Round function rounds floating pt to 2 decimal places.
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
