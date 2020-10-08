package com.cg.userregistration;

public class InvalidEmailException extends RuntimeException{
	public InvalidEmailException(String message) { 
		super(message);
	}
}
