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
		String email;
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
		do
		{
			System.out.print("Enter Email: ");
			email = in.nextLine();
		}while(isValidEmail(email)==false);
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
	
	/**
	 * @param lastName
	 * @return
	 * Validates lastName, first char capital & min three char
	 */
	private static boolean isValidLastName(String lastName)
	{
		if(Pattern.matches("[A-Z][a-z]{2,}", lastName)==false)
		{
			System.out.println("Invalid Last Name.");
			return false;
		}
		return true;
	}
	
	/**
	 * @param email
	 * @return
	 * Validates email, pattern abc.xyz@bl.co.in with .xyz & .in optional
	 */
	private static boolean isValidEmail(String email)
	{
		if(Pattern.matches("[a-z]+(.[a-z]+)?@bl.co(.in)?", email)==false)
		{
			System.out.println("Invalid Email.");
			return false;
		}
		return true;
	}
}
