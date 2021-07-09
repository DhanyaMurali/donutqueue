package com.springboot.donutqueue.service;

import java.util.List;
import com.springboot.donutqueue.entity.DonutOrder;
import com.springboot.donutqueue.entity.DonutOrderRequest;
import com.springboot.donutqueue.entity.DonutOrderResponse;
import com.springboot.donutqueue.entity.OrderResponse;

public interface OrderService {

	public List<DonutOrderResponse> getOrders();
	
	public String addOrder(DonutOrder theOrder) throws Exception;

	public String deleteOrderById(int clientId);
	
	public OrderResponse getOrderById(int clientId);
	
	public List<DonutOrderRequest> getReadyOrders();
}
