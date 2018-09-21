package org.gongjian.service;

import org.gongjian.dao.OrderRepository;
import org.gongjian.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private TransactionService transactionService;

	@Override
	@Transactional()
	public void updateOrder(Long id, Long incAmount) {
		System.out.println(Thread.currentThread().getName() + " : update order start");
		Order orderDB = orderRepository.findOne(id);

		System.out.println(Thread.currentThread().getName() + " : " + orderDB.getAmount() + "/" + incAmount);
		orderDB.setAmount(orderDB.getAmount() + incAmount);

		orderRepository.save(orderDB);

		Order oo = new Order();
		//oo.setId(111L);
		oo.setName("111111111111111111111111111111111111111111111111111");
		orderRepository.save(oo);
		System.out.println(Thread.currentThread().getName() + " : update order end");
	}

	@Override
	@Transactional()
	public void createOrder(Order order) {
		orderRepository.save(order);
		
		transactionService.scheduleAfterTransaction();
	}

}
