package com.springboot.donutqueue.errors;

public class ErrorResponse {

	private final int status;
	private final String message;
	private final long timeStamp;

	public ErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;

	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

}
