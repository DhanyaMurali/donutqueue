package com.springboot.donutqueue.entity;
/*
 * 
 * This class provides the object for holding the deliveries ready in the priority queue
 * 
 */

public class DonutOrderReady {

	private int clientId;
	
	private int quantity;
	
	public DonutOrderReady() {
		
	}

	public DonutOrderReady(int clientId, int quantity) {
		super();
		this.clientId = clientId;
		this.quantity = quantity;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "DonutOrderReady [clientId=" + clientId + ", quantity=" + quantity + "]";
	}
	
}
