package com.mysmartshop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	@Autowired
	RestTemplate restClient;
	
	@GetMapping
	public String greet(){
		return "message from order service";
	}
	@GetMapping("/cart")
	public String fetchProductGreetMessage() {
		String msg=restClient.getForObject("http:localhost:8300/cart",String.class);
		return "Message received from cart service:" +msg;
	}

}
