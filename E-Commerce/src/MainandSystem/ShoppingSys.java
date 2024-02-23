package MainandSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import Comparator.ShoppingProductCompare;
import ProductsInheritance.Bags;
import ProductsInheritance.Clothes;
import ProductsInheritance.Products;
import ProductsInheritance.Shoes;
import UserandOrder.Order;
import UserandOrder.User;

public class ShoppingSys {

	 private static HashSet<Products> productList = new HashSet<>();
	 private static ArrayList<User> userList = new ArrayList<>();
	 private static ArrayList<User> adminList = new ArrayList<User>();
	 private static ArrayList<Integer> shoppingCard = new ArrayList<Integer>(); 
	 private static ArrayList<Order> orderList = new ArrayList<>() ;
	
	 public static boolean readFromFile() {
		 File f1 = new File("product.txt");
		 Bags b;
		 Shoes s;
		 Clothes c;
		 Scanner sc= null;
		 try {
			sc = new Scanner(f1);
			int productId, quantity, width, height, shoeSize;
			String name, description, material, shoeType, clothesSize, fabricType, type;
			double price;
			while(sc.hasNext()) {
				type = sc.next();
				productId = sc.nextInt();
				name = sc.next();
				description = sc.next();
				price = sc.nextDouble();
				quantity = sc.nextInt();
				if(type.equalsIgnoreCase("bags")) {
					width = sc.nextInt();
					height = sc.nextInt();
					material = sc.next();
					b = new Bags(productId, name, description, price, quantity, width, height, material);
					productList.add(b);
				}
				else if(type.equalsIgnoreCase("shoes")) {
					shoeSize = sc.nextInt();
					shoeType = sc.next();
					s = new Shoes(productId, name, description, price, quantity, shoeSize, shoeType);
					productList.add(s);
				}
				else {
					clothesSize = sc.next();
					fabricType = sc.next();
					c = new Clothes(productId, name, description, price, quantity, clothesSize, fabricType);
					productList.add(c);
				}	
			}
			 sc.close();
			 f1 = new File("admins.txt");
			 String  username, password;
			 User u;
				sc = new Scanner(f1);
				while(sc.hasNext()) {
					username = sc.next();
					password = sc.next();
					u = new User(username, password);
					adminList.add(u); 
				}
				sc.close();
			return true;
			
		} 
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	 }
	 
	 public static ArrayList<User> getAdminList(){
		 return adminList;
	 }
	 
	 public static ArrayList<User> getUserList(){
		 return userList;
	 }
	 
	 public static boolean addProduct(String type, int productId, String name, String description, double price, int quantity, int width, int height, String material, int shoeSize, String shoeType, String clothesSize, String fabricType) {
		 if(type.equalsIgnoreCase("bags")) {
			 Bags b = new Bags(productId, name, description, price, quantity, width, height, material);
			 productList.add(b);
			 return true;
			 }
		 else if(type.equalsIgnoreCase("clothes")) {
			 Clothes c = new Clothes(productId, name, description, price, quantity, clothesSize, fabricType);
			 productList.add(c);
			 return true;
		 }
		 else if(type.equalsIgnoreCase("shoes")) {
			 Shoes s = new Shoes(productId, name, description, price, quantity, shoeSize, shoeType);
			 productList.add(s);
			 return true;
		 }
		 return false;
	 }

	 
	 public static boolean addOrder(User u) {
	 	Order o = new Order(u, shoppingCard);
	 	if(u != null) {
	        orderList.add(o);
	        shoppingCard.clear();
	        return true;
	 	}
        return false;
    }
		
	 
	 
	 public static boolean addShoppingCard(int productId) {
			for(Products p: productList) {
				if(p.getProductId() == productId && p.getQuantity() > 0)  {
					shoppingCard.add(productId);
					return true;
				}
			}
	        return false;
	    }
		
	 public static User addUser(String username, String password) {
		        // Check if the username already exists
		        if (searchUser(username) != null) {
		            return null;
		        } else {
		            // Create a new user and add it to the list
		            User newUser = new User(username, password);
		            userList.add(newUser);
		           return newUser;
		        }
		    }

	 
     public static boolean removeProduct(int productId) {
        for (Products product : productList) {
            if (product.getProductId() == productId) {
                productList.remove(product);
                return true; // Product removed successfully
            }
        }
        return false; // Product not found
    }

     public static Products searchProduct(int productId) {
        for (Products product : productList) {
            if (product.getProductId() == productId) {
                return product; // Return product information
            }
        }
        return null;
    }

	    public static User searchUser(String userName) {
	        for (User user : userList) {
	            if (user.getUsername().equalsIgnoreCase(userName)) {
	                return user; // Return customer information
	            }
	        }
	        return null;
	    }

	    public static Order searchOrder(int orderId) {
	        for (Order order : orderList) {
	            if (order.getOrderId() == orderId) {
	                return order; // Return order information
	            }
	        }
	        return null;
	    }
	    
	    public static User login(String username, String password) {
	    	for(User u: adminList) {
	    		if(u.getUsername().equalsIgnoreCase(username) && u.getPassword().equalsIgnoreCase(password))
	    			return u;
	    	}
	    	return null;
	    }

	    public static double calculateTotalPrice() {
	        double totalPrice = 0.0;

	        for (Products p : productList) {
	            for (int productId : shoppingCard) {
	                if (p.getProductId() == productId) {
	                    totalPrice += p.getSale();
	                    break; 
	                }
	            }
	        }
	        
	        return totalPrice;	   
	       }

	    public static String displayAvailableProducts() {
	        String output = "";
	        TreeSet<Products> tp = new TreeSet<>();
	        tp.addAll(productList);
	       for(Products p: tp)
	       {
	    	   if(p.getQuantity() > 0)
	    		   output += p.toString() + "\n";
	       }
	        return output;
	        
	       }
	    
	    public static String displayOrders() {
	        String orders = "";
	        ArrayList<Integer> p;
	        for(Order o: orderList)
	        {
	        	p = o.getItems();
	        	orders += o.toString() + "\n" + "Products\n";
	        	for(int i = 0; i < p.size(); i++) {
	        		for(Products pro: productList) {
		    			if(pro.getProductId() == p.get(i))
		    				orders+= pro.toString()+ "\n";
		    			}
	        		}
	        	}
	        
	        return orders;
	       }



	    public static String displayShoppingCard() {
	    	String res ="";
	    		for(int i = 0; i < shoppingCard.size(); i++){
	    		 for(Products p: productList) {
	    			if(p.getProductId() == shoppingCard.get(i))
	    				res += p.toString() + "\n";
	    		}
	    	}
	    	return res;
	    }
	    
	    public static String[] getIdArray() {
	    	String[] idArray = new String[productList.size()];
	    	ShoppingProductCompare spc = new ShoppingProductCompare();
	    	TreeSet<Products> ts = new TreeSet<Products>(spc);
	    	ts.addAll(productList);
	    	
	    	int i = 0;
	    	
	    	for(Products p: ts) {
	    		idArray[i] = p.getProductId() + "";
	    		i++;
	    	}
	    	return idArray;
	    }
	    
	    public static ArrayList<Integer> getShoppingCard() {
	    	return shoppingCard;
	    }
}

