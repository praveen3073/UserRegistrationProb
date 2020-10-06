package com.cg.userregistration;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ValidEmailTest {
	private String emailSample;
	private boolean expectedResult;
	
	public ValidEmailTest(String emailSample, boolean expectedResult) {
		this.emailSample = emailSample;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {	{"abc@yahoo.com", true},
												{"abc-100@yahoo.com", true},
												{"abc.100@yahoo.com", true},
												{"abc111@abc.com", true},
												{"abc-100@abc.net", true},
												{"abc.100@abc.com.au", true},
												{"abc@1.com", true},
												{"abc@gmail.com.com", true},
												{"abc+100@gmail.com", false},
												{"abcgmail.com", false},
												{"abc@.com.my", false},
												{"abc123@gmail.a", false},
												{"abc123@.com", false},
												{"abc123@.com.com", false},
												{".abc@abc.com", false},
												{"abc()*@gmail.com", false},
												{"abc@%*.com", false},
												{"abc..2002@gmail.com", false},
												{"abc.@gmail.com", false},
												{"abc@abc@gmail.com", false},
												{"abc@gmail.com.1a", false},
												{"abc@gmail.com.aa.au", false}
		});
	}
	
	@Test
	public void givenEmail_ShouldReturnAsPerParameterizedResult() {
		assertEquals(expectedResult, UserRegistration.isValidEmail(emailSample));
	}
}
