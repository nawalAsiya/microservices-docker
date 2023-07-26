package com.mysmartshop.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	private String productId;
	private String name;
	private float price;
	private String description;

}
