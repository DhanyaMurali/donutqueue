package com.springboot.donutqueue.dao;

import java.util.List;

import com.springboot.donutqueue.entity.DonutOrder;
import com.springboot.donutqueue.entity.DonutOrderRequest;
import com.springboot.donutqueue.entity.DonutOrderResponse;
import com.springboot.donutqueue.entity.OrderResponse;

public interface DonutOrderDao {
	//Method for getting all orders placed in the queue
	public List<DonutOrderResponse> getOrders();
	
	//for adding an order
	public String addOrder(DonutOrder theOrder) throws Exception;

	//To delete an order
	public String deleteOrderById(int clientId);
	
	//To get a particular order by clientid
	public OrderResponse getOrderById(int clientId);
	
	//To get all orders ready for delivery
	public List<DonutOrderRequest> getReadyOrders();
}
