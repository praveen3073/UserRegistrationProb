package com.cg.userregistration;

public class InvalidLastNameException extends RuntimeException{
	public InvalidLastNameException(String message) {
		super(message);
	}
}
