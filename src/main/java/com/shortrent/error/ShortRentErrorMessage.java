package com.shortrent.error;

public class ShortRentErrorMessage {

	private int code;
	private String message;
	
	public ShortRentErrorMessage(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
