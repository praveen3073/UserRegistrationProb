package com.cg.userregistration;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserRegistrationTest {

	@Test
	public void givenFirstName_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidFirstName("Aks");
		assertEquals(true, result);
	}
	
	@Test
	public void givenLastName_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidFirstName("Jain");
		assertEquals(true, result);
	}
	
	@Test
	public void givenEmail_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidEmail("pop3073@gmail.com");
		assertEquals(true, result);
	}
	
	@Test
	public void givenMobileNo_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidMobileNo("91 9834576643");
		assertEquals(true, result);
	}
	
	@Test
	public void givenPassword_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidPassword("Dlk4%nnn");
		assertEquals(true, result);
	}

}
