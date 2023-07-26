package com.mysmartshop.cart;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository  extends JpaRepository<CartItem, Integer>{
	
	public Optional<CartItem> findByProductId(String productId);
	
	@Query(value="select sum(total_Price) from Cart_Item",nativeQuery = true)
	public float getTotalCartValue();
}
