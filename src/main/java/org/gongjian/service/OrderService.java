package org.gongjian.service;

import org.gongjian.domain.Order;

public interface OrderService {
	
	void updateOrder(Long id, Long incAmount);
	
	void createOrder(Order order);

}
