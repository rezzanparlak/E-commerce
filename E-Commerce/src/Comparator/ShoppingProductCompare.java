package Comparator;

import java.util.Comparator;

import ProductsInheritance.Products;

public class ShoppingProductCompare implements Comparator<Products>{

	@Override
	public int compare(Products o1, Products o2) {
		// TODO Auto-generated method stub
		return o1.getProductId() - o2.getProductId();
	}
	
}
