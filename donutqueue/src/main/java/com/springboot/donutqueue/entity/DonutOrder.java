package com.springboot.donutqueue.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

/**
 * This class provides the request object which accepts client id and the no.of donuts.
 *
 */
@Valid
public class DonutOrder {
	
	@NotNull(message = "client id is required")
	@Range(min = 1,max = 20000)
	private int clientId;
	
	@NotNull(message = "No:of donut is required")
	@Range(min = 1,max = 10)
	private int quantity;
	
	public DonutOrder() {
		
	}

	public DonutOrder( int clientId,int quantity) {
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
		return "DonutOrder [clientId=" + clientId + ", quantity=" + quantity + "]";
	}
	
}
