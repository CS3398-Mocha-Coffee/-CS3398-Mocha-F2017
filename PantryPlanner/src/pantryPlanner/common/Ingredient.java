package pantryPlanner.common;

public class Ingredient {
	
	private int mId;
	private String mName;
	private String mQty;
	private String mUnit;
	
	/**
	 * Constructor for setting fields of object using:
	 * @param id, @param name, @param unit, and @param qty
	 */
	public Ingredient(String id, String name, String unit, String qty) {
		this.mId = Integer.parseInt(id);
		this.mName = name;
		this.mQty = qty;
		this.mUnit = unit;
	}
	public int getId() {
		return mId;
	}
	public void setId(int mId) {
		this.mId = mId;
	}
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public double getQty() {
		return Double.parseDouble(mQty);
	}
	public void setQty(double qty) {
		mQty = String.valueOf(qty);
	}
	public void incrementQty(double qty) {
		double quantity = Double.parseDouble(mQty) + qty;
		mQty = String.valueOf(quantity);
	}
	public void decrementQty(double qty) {
		double quantity = Double.parseDouble(mQty) - qty;
		mQty = String.valueOf(quantity);
	}
	public String getUnit() {
		return mUnit;
	}
	public void setUnit(String mUnit) {
		this.mUnit = mUnit;
	}

}
