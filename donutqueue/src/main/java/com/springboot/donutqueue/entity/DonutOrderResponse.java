package com.springboot.donutqueue.entity;

public class DonutOrderResponse {

	private int clientId;
	
	private int quantity;
	
	private long waittime;
	
	public DonutOrderResponse() {
		
	}

	public DonutOrderResponse(int quantity, int waittime) {
		super();
		
		this.quantity = quantity;
		this.waittime = waittime;
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

	public long getWaittime() {
		return waittime;
	}

	public void setWaittime(long waittime) {
		this.waittime = waittime;
	}

	@Override
	public String toString() {
		return "DonutOrderResponse [clientId=" + clientId + ", quantity=" + quantity + ", waittime=" + waittime + "]";
	}
	
	
}
