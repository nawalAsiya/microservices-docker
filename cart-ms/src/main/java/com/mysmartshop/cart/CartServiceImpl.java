package com.mysmartshop.cart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository itemRepo;
	
	 @Autowired
	 RestTemplate ProductServiceClient;

	@Override
	public List<CartItem> addToCart(String productId) {
		Optional<CartItem> checkItem = itemRepo.findByProductId(productId);
				if(!checkItem.isPresent()) {
					CartItem item=new CartItem();
					item.setProductId(productId);
					item.setQuantity(1);
					item.setTotalPrice(fetchPrice(productId));
					itemRepo.save(item);
				}else {
					CartItem item=checkItem.get();
					updateQuantity(productId,item.getQuantity()+ 1);
				}

		return getAllItems();
	}

	@Override
	public List<CartItem> removeFromCart(String productId) {
		Optional<CartItem> checkItem = itemRepo.findByProductId(productId);
		if(!checkItem.isPresent()) {
			CartItem item=checkItem.get();
			itemRepo.delete(item);	
		}
		return getAllItems();
	}

	@Override
	public List<CartItem> updateQuantity(String productId, int quantity) {
		Optional<CartItem> checkItem = itemRepo.findByProductId(productId);
		if(checkItem.isPresent()) {
			CartItem item=checkItem.get();
			item.setQuantity(quantity);
			item.setTotalPrice(item.getTotalPrice()*quantity);
			itemRepo.save(item);
		}
		return getAllItems();
	}

	@Override
	public float calculateTotalCost() {
		 
		return itemRepo.getTotalCartValue();
	}
	
	@Override
	public List<CartItem>getAllItems(){
		return itemRepo.findAll();
	}
	
	private float fetchPrice(String productId) {
		Product product = ProductServiceClient.getForObject("http://product-ms/product/"+productId,Product.class);
				if(product != null)
					return product.getPrice();
		return 0;			
	}
   private float fetchPriceFallback(String productId, Throwable t) {
	Product product = new Product(productId,"Dummy Product",0,"A dummy product");
	System.err.println(t.getMessage());
	System.out.println("Response from Fallback");
	System.out.println(product);
	return product.getPrice();
}


//	

}
