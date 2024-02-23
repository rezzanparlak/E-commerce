package ProductsInheritance;

public class Bags extends Products{
		
		private int width, height;
		private String material;
		

		public Bags(int productId, String name, String description, double price, int quantity, int width, int height, String material) {
			super(productId, name, description, price, quantity);
			// TODO Auto-generated constructor stub
			this.width = width;
			this.height = height;
			this.material = material;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}
		
		@Override
		public double getSale() {
			if(material.equalsIgnoreCase("Leather"))
				return price * 0.95;
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
			return "Bag\n" + super.toString() + "Width: " + width + "\nHeight: "+ height +"\nMaterial: " + material +"\n";
		}

		@Override
		public int compareTo(Products o) {
			// TODO Auto-generated method stub
			return this.getProductId() - o.getProductId();
		}
		
	
		
}
