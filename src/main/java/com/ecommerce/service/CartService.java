package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.CartItem;

public interface CartService {
	
	public void addProductToCart(int customer_id, int product_id, int quantity);
	
	public void removeProductToCart(int customer_id, int product_id);
	
	public void viewCartProducts(int customer_id);
	
	List<CartItem> getCartItems(long customerId);

	public void clearCart(long userId);
}
