package com.cg.userregistration;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Praveen Satya
 * Program validates user registration using regex	
 */
public class UserRegistration {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to User Registration");
		inputUserDetails();
		in.close();
	}
	
	/**
	 * Takes user input from console
	 */
	private static void inputUserDetails()
	{
		String firstName;
		do
		{
			System.out.print("Enter first name: ");
			firstName = in.nextLine();
		}while(isValidFirstName(firstName)==false);
	}
	
	/**
	 * @param firstName
	 * @return
	 * Validates firstName, first char capital & min three char
	 */
	private static boolean isValidFirstName(String firstName)
	{
		if(Pattern.matches("[A-Z][a-z]{2,}", firstName)==false)
		{
			System.out.println("Invalid First Name.");
			return false;
		}
		return true;
	}
}
