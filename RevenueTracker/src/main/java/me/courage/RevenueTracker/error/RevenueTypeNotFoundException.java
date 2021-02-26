package me.courage.RevenueTracker.error;

public class RevenueTypeNotFoundException extends RuntimeException {

	public RevenueTypeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RevenueTypeNotFoundException(String message) {
		super(message);
	}

	public RevenueTypeNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
