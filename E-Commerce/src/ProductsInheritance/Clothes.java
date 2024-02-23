package ProductsInheritance;

public class Clothes extends Products{
	private String clothesSize;
	private String fabricType;
	
	

	public Clothes(int productId, String name, String description, double price, int quantity, String clothesSize, String fabricType) {
		super(productId, name, description, price, quantity);
		this.clothesSize = clothesSize;
		this.fabricType = fabricType;
	}

	public String getClothesSize() {
		return clothesSize;
	}

	public void setClothesSize(String clothesSize) {
		this.clothesSize = clothesSize;
	}

	public String getFabricType() {
		return fabricType;
	}

	public void setFabricType(String fabricType) {
		this.fabricType = fabricType;
	}
	
	@Override
	public double getSale() { 
		if(fabricType.equalsIgnoreCase("wool"))
			return price * 0.85;
		else if(fabricType.equalsIgnoreCase("polyester"))
			return price * 0.70;
		return price;
	}
	
	@Override
	public void addVat() {
		double price = super.getPrice();
		price += price * 0.5;
		super.setPrice(price);
	}
	
	@Override
	public String toString() {
		return "\nClothes\n" + super.toString() + "Clothe Size: " + clothesSize + "\nFabric Type: " + fabricType +"\n";
	}

	@Override
	public int compareTo(Products o) {
		// TODO Auto-generated method stub
		return this.getProductId() - o.getProductId();
	}
}
