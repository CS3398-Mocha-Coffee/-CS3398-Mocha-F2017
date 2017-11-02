public class Ingredient {
	
	private String mId;
	private String mName;
	private String mQty;
	private String mUnit;
	
	public Ingredient(String id, String name, String unit, String qty) {
		this.mId = id;
		this.mName = name;
		this.mQty = qty;
		this.mUnit = unit;
	}

	public double getId() {
		return Double.parseDouble(mId);
	}

	public void setId(double mId) {
		this.mId = String.valueOf(mId);
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
