package com.springboot.donutqueue.entity;

public class OrderResponse {

	private int position;
	
	private long waitTime;
	
	public OrderResponse() {
		
	}

	public OrderResponse(int position, long waitTime) {
		super();
		this.position = position;
		this.waitTime = waitTime;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	@Override
	public String toString() {
		return "Response [position=" + position + ", waitTime=" + waitTime + "]";
	}
	
}
