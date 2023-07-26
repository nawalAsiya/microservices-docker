package com.mysmartshop.cart;

import java.util.List;




public interface CartService {
public List<CartItem> addToCart(String productId);

public List<CartItem> removeFromCart(String productId);

public List<CartItem> updateQuantity(String productId,int Quantity);

public float calculateTotalCost();

public List<CartItem> getAllItems();

}
