package com.springboot.donutqueue.service;

import java.util.Comparator;


import com.springboot.donutqueue.entity.DonutOrderRequest;

public class PrioritySorter implements Comparator<DonutOrderRequest> {

	//Comparator class to add elements based on priority.Client id <=1000 have a higher priority
	
	@Override
	public int compare(DonutOrderRequest o1, DonutOrderRequest o2) {
		
		int clientId_1 = o1.getClientId();
		int clientId_2 = o2.getClientId();
		if(clientId_1<=1000 && clientId_2<=1000) {
			return (int) (o1.getTimeOfRequest()-(o2.getTimeOfRequest()) );

		}else if(clientId_1<=1000 && clientId_2>=1000)
			return -1;
		else if(clientId_1>=1000 && clientId_2<=1000) {
			return 1;
		}
		return 1;
	}

}
