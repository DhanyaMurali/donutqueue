package com.springboot.donutqueue.entity;



public class DonutOrderRequest {
	
	
	private int clientId;
	
	private int quantity;
	
	private  long timeOfRequest;
	
	public DonutOrderRequest() {
		
	}

	

	public DonutOrderRequest(int clientId, int quantity) {
		super();
		this.clientId = clientId;
		this.quantity = quantity;
		System.out.println("Hello");
	}


	public long getTimeOfRequest() {
		return timeOfRequest;
	}



	public void setTimeOfRequest(long timeOfRequest) {
		this.timeOfRequest = timeOfRequest;
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
		return "DonutOrderRequest [clientId=" + clientId + ", quantity=" + quantity + "]";
	}
	
	
	
}
