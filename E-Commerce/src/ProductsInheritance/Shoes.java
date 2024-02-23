package ProductsInheritance;

public class Shoes extends Products{
	private int shoeSize;
	private String shoeType;
	
	
	

	public Shoes(int productId, String name, String description, double price, int quantity, int shoeSize, String shoeType) {
		super(productId, name, description, price, quantity);
		this.shoeSize = shoeSize;
		this.shoeType = shoeType;
		}

	public int getShoeSize() {
		return shoeSize;
	}

	public void setShoeSize(int shoeSize) {
		this.shoeSize = shoeSize;
	}

	public String getShoeType() {
		return shoeType;
	}

	public void setShoeType(String shoeType) {
		this.shoeType = shoeType;
	}
	
	@Override
	public double getSale() {
		if(shoeType.equalsIgnoreCase("sneakers")) {
			return price * 0.98;
		}
		else if(shoeType.equalsIgnoreCase("Boots"))
			return price * 0.9;
		else
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
		return "Shoe\n" + super.toString() + "Shoe Size: " + shoeSize + "\nShoe Type: " + shoeType + "\n";
	}

	@Override
	public int compareTo(Products o) {
		// TODO Auto-generated method stub
		return this.getProductId() - o.getProductId();
	}
}
