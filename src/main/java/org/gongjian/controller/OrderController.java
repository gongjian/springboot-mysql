package org.gongjian.controller;

import org.gongjian.domain.Order;
import org.gongjian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/test")
	public String test() {
		for(int i=1; i<=10; i++) {
			Thread t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					orderService.updateOrder(1L, 2L);
					
				}
			}, "T"+i);
			
			t.start();
		}
		
		return "SUCCESS";
	}
	
	@RequestMapping("/create")
	public String createOrder() {
		Order order = new Order();
		//order.setId(1L);
		order.setName("o1");
		order.setAmount(123L);
		orderService.createOrder(order);
		
		return "SUCCESS";
	}

}
