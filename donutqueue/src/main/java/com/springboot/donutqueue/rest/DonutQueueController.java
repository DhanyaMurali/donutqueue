package com.springboot.donutqueue.rest;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.donutqueue.entity.DonutOrder;

import com.springboot.donutqueue.entity.DonutOrderRequest;
import com.springboot.donutqueue.entity.DonutOrderResponse;
import com.springboot.donutqueue.entity.OrderResponse;
import com.springboot.donutqueue.service.OrderService;

@Validated
@RestController
@RequestMapping("/api")
public class DonutQueueController {

	private OrderService orderService;

	@Autowired
	public DonutQueueController(OrderService theorderService) {
		orderService = theorderService;
	}

	// Method for getting all orders placed in the queue

	@GetMapping("/orders")
	public List<DonutOrderResponse> getOrders() throws Exception {
		List<DonutOrderResponse> orderList = new ArrayList<DonutOrderResponse>();
		orderList = orderService.getOrders();
		if (orderList.isEmpty()) {
			throw new Exception("No Order");
		}

		return orderList;

	}

	// To get the order details of a particular order by client id

	@GetMapping("/orders/{clientId}")
	public OrderResponse getOrderById(@PathVariable int clientId) {
		OrderResponse currentOrder = orderService.getOrderById(clientId);
		return currentOrder;
	}

	// Add a new order

	@PostMapping("/orders")
	public String addOrder(@Valid @RequestBody DonutOrder newOrder) throws Exception {
		String message = orderService.addOrder(newOrder);
		return message;
	}

	// To delete a particular order

	@DeleteMapping("/orders/{clientId}")
	public String deleteOrderById(@PathVariable int clientId) {

		String message = orderService.deleteOrderById(clientId);
		return message;
	}

	// To get the orders ready for delivery

	@GetMapping("/orders/ready")
	public List<DonutOrderRequest> getReadyOrders() throws Exception {
		List<DonutOrderRequest> readyList = new ArrayList<DonutOrderRequest>();
		readyList = orderService.getReadyOrders();
		if (readyList.isEmpty()) {
			throw new Exception("No Order");
		}

		return readyList;

	}

}
