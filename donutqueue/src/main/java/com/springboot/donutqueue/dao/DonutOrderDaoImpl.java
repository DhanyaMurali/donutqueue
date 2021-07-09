package com.springboot.donutqueue.dao;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import org.springframework.stereotype.Component;
import com.springboot.donutqueue.entity.DonutOrder;
import com.springboot.donutqueue.entity.DonutOrderRequest;
import com.springboot.donutqueue.entity.DonutOrderResponse;
import com.springboot.donutqueue.entity.OrderResponse;
import com.springboot.donutqueue.exception.ClientNotFoundException;
import com.springboot.donutqueue.service.PrioritySorter;

@Component
public class DonutOrderDaoImpl implements DonutOrderDao {

	private final Comparator<DonutOrderRequest> prioritySorter = new PrioritySorter();
	private final PriorityBlockingQueue<DonutOrderRequest> priorityQueue = new PriorityBlockingQueue<DonutOrderRequest>(
			30, prioritySorter);
	

	int priorityQueueSize = 0;

	// Method for getting all orders placed in the queue
	@Override
	public List<DonutOrderResponse> getOrders() {
		// TODO Auto-generated method stub
		List<DonutOrderResponse> polledElements = new ArrayList<DonutOrderResponse>();

		long waitTime;
		// loop through priority queue and get all placed orders.The wait time is
		// calculated and added to the response object.
		for (DonutOrderRequest req : priorityQueue) {
			DonutOrderResponse resp = new DonutOrderResponse();
			waitTime = (new Date().getTime() - req.getTimeOfRequest()) / 1000;
			resp.setClientId(req.getClientId());
			resp.setQuantity(req.getQuantity());
			resp.setWaittime(waitTime);
			polledElements.add(resp);
		}
		return polledElements;

	}

	// To add a new order.while adding a new order the time of request is also set
	// in to the object.
	@Override
	public String addOrder(DonutOrder theOrder) throws Exception {

		DonutOrderRequest request = new DonutOrderRequest();
		List<Integer> clientIds = new ArrayList<>();
		Date date = new Date();
		request.setClientId(theOrder.getClientId());
		request.setQuantity(theOrder.getQuantity());
		request.setTimeOfRequest(date.getTime());
		// To check if the client id already exists.
		if (!priorityQueue.isEmpty()) {

			for (DonutOrderRequest req : priorityQueue) {
				int id = req.getClientId();
				clientIds.add(id);

			}
		}

		if (clientIds.contains(theOrder.getClientId())) {
			throw new Exception("Order Placed already,cannot modify it");
		}

		priorityQueue.add(request);
		return "Order succesfully placed";

	}

	//To delete a particular order
	public String deleteOrderById(int clientId) {

		String message = null;
		for (DonutOrderRequest req : priorityQueue) {
			if (req.getClientId() == clientId) {
				priorityQueue.remove(req);
				message = "Order cancelled successfully";
			}

		}
		if (message == null) {
			throw new ClientNotFoundException("Client not found");
		}
		return message;
	}

	//To get the order details of a particular order by client id
	public OrderResponse getOrderById(int clientId) {
		OrderResponse orderRep = new OrderResponse();
		Date date1 = new Date();
		int position = 0;
		long waitTime = 0;
		long currentTime = 0;
		boolean flag = false;
		for (DonutOrderRequest req : priorityQueue) {
			position++;
			if (req.getClientId() == clientId) {
				flag = true;
				currentTime = date1.getTime();
				waitTime = (currentTime - req.getTimeOfRequest()) / 1000;
				System.out.println("inside getOrderById method: position = " + position + "waittime =" + waitTime);
				orderRep.setPosition(position);
				orderRep.setWaitTime(waitTime);
			}

		}
		if (!flag) {
			throw new ClientNotFoundException("Client not found");
		}
		return orderRep;
	}

	//To get the order ready for delivery
	@Override
	public List<DonutOrderRequest> getReadyOrders() {
		List<DonutOrderRequest> readylist = new ArrayList<DonutOrderRequest>();
//		int donutsTotal = 0;
//		for (DonutOrderRequest req : priorityQueue) {
//			donutsTotal = donutsTotal + req.getQuantity();
//			if (donutsTotal <= 50) {
				readylist.add(priorityQueue.poll());
//			}
//
//		}

		return readylist;

	}

}
