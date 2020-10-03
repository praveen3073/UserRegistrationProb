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
		String mobileNo;
		String password;
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
			System.out.print("Enter email: ");
			email = in.nextLine();
		}while(isValidEmail(email)==false);
		do
		{
			System.out.print("Enter mobile number: ");
			mobileNo = in.nextLine();
		}while(isValidMobileNo(mobileNo)==false);
		do
		{
			System.out.print("Enter password: ");
			password = in.nextLine();
		}while(isValidPassword(password)==false);
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
	
	/**
	 * @param mobileNo
	 * @return
	 * Validates mobileNo, pattern ## ##########
	 */
	private static boolean isValidMobileNo(String mobileNo)
	{
		if(Pattern.matches("[0-9]{2}\\s[0-9]{10}", mobileNo)==false)
		{
			System.out.println("Invalid Mobile Number.");
			return false;
		}
		return true;
	}
	
	/**
	 * @param password
	 * @return
	 * Validates password
	 */
	private static boolean isValidPassword(String password)
	{
		if(isPasswordRightLength(password)==false)
		{
			System.out.println("Invalid Password.");
			return false;
		}
		return true;
	}
	
	/**
	 * @param password
	 * @return
	 * Validates password. Min char length should be 8.
	 */
	private static boolean isPasswordRightLength(String password)
	{
		if(Pattern.matches(".{8,}", password)==false)
		{
			System.out.println("Password length less than 8.");
			return false;
		}
		return true;
	}
}
