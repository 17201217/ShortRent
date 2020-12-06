package com.shortrent.error;

public class ShortRentException extends Exception{

	private ShortRentErrorMessage errorMessage;
	
	public ShortRentException(ShortRentErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ShortRentErrorMessage getErrorMessage() {
		return errorMessage;
	}
	
	public String getMessage() {
		return errorMessage.getMessage();
	}
}
