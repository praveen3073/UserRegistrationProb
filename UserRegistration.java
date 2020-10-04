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
	 * Validates email by calling isValidEmailAllCases()
	 */
	private static boolean isValidEmail(String email)
	{
		if(isValidEmailAllCases(email)==false)
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
		if(isPasswordRightLength(password)==false || hasPassUpperCase(password)==false || hasPassNo(password)==false 
		|| hasPassSpecialChar(password)==false)
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
	
	/**
	 * @param password
	 * @return
	 * Validates password. Should have atleast 1 upper case letter.
	 */
	private static boolean hasPassUpperCase(String password)
	{
		if(Pattern.matches(".*[A-Z]+.*", password)==false)
		{
			System.out.println("Password should have atleast one capital letter.");
			return false;
		}
		return true;
	}
	
	/**
	 * @param password
	 * @return
	 * Validates password. Should have atleast 1 number.
	 */
	private static boolean hasPassNo(String password)
	{
		if(Pattern.matches(".*[0-9]+.*", password)==false)
		{
			System.out.println("Password should have atleast one number.");
			return false;
		}
		return true;
	}
	
	/**
	 * @param password
	 * @return
	 * Validates passsword. Should have exactly one special character.
	 */
	private static boolean hasPassSpecialChar(String password)
	{
		if(Pattern.matches("\\w*[^\\w\\s]{1}\\w*", password)==false)
		{
			System.out.println("Password should have exactly one special character.");
			return false;
		}
		return true;
	}
	
	/**
	 * @param email
	 * @return
	 * Validates email for all given test cases
	 */
	private static boolean isValidEmailAllCases(String email)
	{
		if(Pattern.matches(".+[@].+", email)==false)
			System.out.println("Email must contain '@'");
		else if(Pattern.matches(".+@\\..+", email)==true)
			System.out.println("TId can't start with '.'");
		else if(Pattern.matches(".+\\..{2,}", email)==false)
			System.out.println("Last tId should have atleast 2 characters");
		else if(Pattern.matches("\\..+", email)==true)
			System.out.println("First character of email can't be '.'");
		else if(Pattern.matches("[.a-z0-9_-]+@.+", email)==false)
			System.out.println("Email can only have character, digit, '_' and '-'");
		else if(Pattern.matches(".+@[a-z0-9.]+", email)==false)
			System.out.println("Email's tId can only have characters and digits");
		else if(Pattern.matches(".+\\.\\..+", email)==true)
			System.out.println("Double dots not allowed");
		else if(Pattern.matches(".+\\.@.+", email)==true)
			System.out.println("Email's last character can't end with '.'");
		else if(Pattern.matches(".*@.*@.*", email)==true)
			System.out.println("Double '@' is not allowed");
		else if(Pattern.matches(".*\\.[a-z]{2}", email)==false && Pattern.matches(".*\\.[a-z0-9]{3,}", email)==false)
			System.out.println("Email's tId which contains 2 characters can't have digits");
		else if(Pattern.matches(".*@[^.]+\\.[^.]+\\.[^.]+\\..+", email)==true)
			System.out.println("Can't have multiple tId");
		else
			return true;
		return  false;
	}
}
