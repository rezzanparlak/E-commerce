package ProductsInheritance;

import java.util.Objects;

public abstract class Products implements Comparable<Products>, ProductInterface{
	protected int productId;
	protected String name, description;
	protected double price;
	protected int quantity;
	

	

	public Products(int productId, String name, String description, double price, int quantity) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		
	}


	public abstract double getSale();
	
	
	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return productId == other.productId;
	}


	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product ID: " + productId +"\nProducts name: " + name + "\nDescription: " + description + "\nPrice: " + price + "\nQuantity: " + quantity +"\n";
	}
	
	
	
	
}
