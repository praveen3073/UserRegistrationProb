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
		String lastName;
		do
		{
			System.out.print("Enter first name: ");
			firstName = in.nextLine();
		}while(isValidFirstName(firstName)==false);
		do
		{
			System.out.print("Enter last name: ");
			lastName = in.nextLine();
		}while(isValidLastName(lastName)==false);
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
	
	private static boolean isValidLastName(String lastName)
	{
		if(Pattern.matches("[A-Z][a-z]{2,}", lastName)==false)
		{
			System.out.println("Invalid Last Name.");
			return false;
		}
		return true;
	}
}
