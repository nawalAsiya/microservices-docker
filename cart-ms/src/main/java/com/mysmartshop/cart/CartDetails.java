package com.mysmartshop.cart;

import java.util.List;


import lombok.Data;

@Data
public class CartDetails {

private List<CartItem>itemsList;
private float totalCartValue;
}
