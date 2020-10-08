package com.cg.userregistration;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

public class UserRegistrationTest {

	@Test
	public void givenFirstName_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidFirstName("Aks");
		assertEquals(true, result);
	}
	
	@Test
	public void givenFirstName_WhenInvalid_ShouldReturnInvalidFirstNameException() {
		try {
			UserRegistration.isValidFirstName("Ak");
		} catch (InvalidFirstNameException e) {
			assertEquals("Invalid First Name Exception", e.getMessage());
		}
	}
	
	@Test
	public void givenLastName_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidFirstName("Jain");
		assertEquals(true, result);
	}
	
	@Test
	public void givenLastName_WhenInvalid_ShouldReturnInvalidLastNameException() {
		try {
			UserRegistration.isValidLastName("Ak");
		} catch (InvalidLastNameException e) {
			assertEquals("Invalid Last Name Exception", e.getMessage());
		}
	}
	
	@Test
	public void givenEmail_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidEmail("pop3073@gmail.com");
		assertEquals(true, result);
	}
	
	@Test
	public void givenEmail_WhenInvalid_ShouldReturnInvalidEmailException() {
		try {
			UserRegistration.isValidEmail("pop3073gmail.com");
		} catch (InvalidEmailException e) {
			assertEquals("Invalid Email Exception", e.getMessage());
		}
	}
	
	@Test
	public void givenMobileNo_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidMobileNo("91 9834576643");
		assertEquals(true, result);
	}
	
	@Test
	public void givenMobileNo_WhenInvalid_ShouldReturnInvalidMobileNoException() {
		try {
			UserRegistration.isValidMobileNo("91 98766");
		} catch(InvalidMobileNoException e) {
			assertEquals("Invalid Mobile Number Exception", e.getMessage());
		}
	}
	
	@Test
	public void givenPassword_WhenValid_ShouldReturnTrue() {
		boolean result = UserRegistration.isValidPassword("Dlk4%nnn");
		assertEquals(true, result);
	}

	@Test
	public void givenPassword_WhenInvalid_ShouldReturnInvalidPasswordException() {
		try {
			UserRegistration.isValidPassword("Aksdfg3");
		} catch (InvalidPasswordException e) {
			assertEquals("Invalid Password Exception", e.getMessage());
		}
	}
}
