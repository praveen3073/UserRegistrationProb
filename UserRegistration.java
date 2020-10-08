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
		try {
			inputUserDetails();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
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
		
		try {
			System.out.print("Enter first name: ");
			firstName = in.nextLine();
			isValidFirstName(firstName);
		} catch(InvalidFirstNameException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.print("Enter last name: ");
			lastName = in.nextLine();
			isValidLastName(lastName);
		} catch(InvalidLastNameException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.print("Enter email: ");
			email = in.nextLine();
			isValidEmail(email);
		} catch(InvalidEmailException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.print("Enter mobile number: ");
			mobileNo = in.nextLine();
			isValidMobileNo(mobileNo);
		} catch(InvalidMobileNoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.print("Enter password: ");
			password = in.nextLine();
			isValidPassword(password);
		} catch(InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-----User Registration Successful-----");
	}
	
	/**
	 * @param firstName
	 * @return
	 * Validates firstName, first char capital & min three char
	 */
	static boolean isValidFirstName(String firstName)
	{
		if(Pattern.matches("[A-Z][a-z]{2,}", firstName)==false)
		{
			throw new InvalidFirstNameException("Invalid First Name Exception");
		}
		return true;
	}
	
	/**
	 * @param lastName
	 * @return
	 * Validates lastName, first char capital & min three char
	 */
	static boolean isValidLastName(String lastName)
	{
		if(Pattern.matches("[A-Z][a-z]{2,}", lastName)==false)
		{
			throw new InvalidLastNameException("Invalid Last Name Exception");
		}
		return true;
	}
	
	/**
	 * @param email
	 * @return
	 * Validates email by calling isValidEmailAllCases()
	 */
	static boolean isValidEmail(String email)
	{
		if(isValidEmailAllCases(email)==false)
		{
			throw new InvalidEmailException("Invalid Email Exception");
		}
		return true;
	}
	
	/**
	 * @param mobileNo
	 * @return
	 * Validates mobileNo, pattern ## ##########
	 */
	static boolean isValidMobileNo(String mobileNo)
	{
		if(Pattern.matches("[0-9]{2}\\s[0-9]{10}", mobileNo)==false)
		{
			throw new InvalidMobileNoException("Invalid Mobile Number Exception");
		}
		return true;
	}
	
	/**
	 * @param password
	 * @return
	 * Validates password
	 */
	static boolean isValidPassword(String password)
	{
		if(isPasswordRightLength(password)==false || hasPassUpperCase(password)==false || hasPassNo(password)==false 
		|| hasPassSpecialChar(password)==false)
		{
			throw new InvalidPasswordException("Invalid Password Exception");
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
