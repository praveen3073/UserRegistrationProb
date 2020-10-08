package com.cg.userregistration;

public class InvalidPasswordException extends RuntimeException{
	public InvalidPasswordException(String message) {
		super(message);
	}
}
