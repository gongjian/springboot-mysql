package org.gongjian;

import org.gongjian.domain.Order;
import org.gongjian.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateOrderTests {

	@Autowired
	private OrderService orderService;
	
	@Test
	public void testCreateOrder() {
		
		Order order = new Order();
		//order.setId(1L);
		order.setName("OOXX");
		order.setAmount(1L);
		
		orderService.createOrder(order);
	}

}
