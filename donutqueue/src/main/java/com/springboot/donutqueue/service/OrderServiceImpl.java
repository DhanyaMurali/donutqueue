package com.springboot.donutqueue.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.donutqueue.dao.DonutOrderDao;
import com.springboot.donutqueue.entity.DonutOrder;
import com.springboot.donutqueue.entity.DonutOrderRequest;
import com.springboot.donutqueue.entity.DonutOrderResponse;
import com.springboot.donutqueue.entity.OrderResponse;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	DonutOrderDao donutOrderDao;

	//PriorityBlockingQueue<HashMap> priorityQueueMap = new PriorityBlockingQueue<HashMap>();
	
	@Override
	public List<DonutOrderResponse> getOrders() {
		
		return donutOrderDao.getOrders();
	} 

	@Override
	public String addOrder(DonutOrder theOrder) throws Exception{
		
		return donutOrderDao.addOrder(theOrder);
	}

	@Override
	public String deleteOrderById(int clientId) {
		
		return donutOrderDao.deleteOrderById(clientId);
	}

	@Override
	public OrderResponse getOrderById(int clientId) {
		
		return donutOrderDao.getOrderById(clientId);
	}

	@Override
	public List<DonutOrderRequest> getReadyOrders() {
		
		return donutOrderDao.getReadyOrders();
		
	}



}
