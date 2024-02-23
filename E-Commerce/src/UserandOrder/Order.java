package UserandOrder;

import java.util.ArrayList;


public class Order {
	private  int orderId;
	private  User user;
	private ArrayList<Integer> items = new ArrayList<Integer>();
	private static int lastOrderId = 1;
	
	public Order(User user , ArrayList<Integer> items) {
		orderId++;
		this.user = user;
		this.orderId = lastOrderId++;
		this.items.addAll(items);
	}
	

	public int getOrderId() {
		return orderId;
	}


	
	public User getUser() {
		return user;
	}

	public ArrayList<Integer> getItems() {
		return this.items;
	}
	
	@Override
	public String toString() {
		return "Order" + "\nOrder ID: " + orderId + "\nUser Id: " +  user.getUserId() + "\n";
	}
	
	
}
