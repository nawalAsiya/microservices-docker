package com.mysmartshop.product;

import java.util.List;

public interface ProductService {
	public List<Product> getAvailableProducts();

    public Product getProductDetails(String productId);

    public Product addProduct(Product product);

    public void removeProduct(String productId);

 
}
