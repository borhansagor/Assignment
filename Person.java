package kaderTask1;

import java.util.regex.Pattern;

public class Person {
	//Initializing private attributes;
	private String name,address,phoneNumber,emailAddress;
	
	
	//Default Class Constructor
	public Person()
	{	
		this.name="Borhan Kader";
		this.address="1523 Seven Pines, Springfield, IL, 62704";
		this.phoneNumber="210-544-7523";
		this.emailAddress="bkade2@uis.edu";
	}
	
	//Class Constructor with name Parameter  
	public Person(String name)
	{
		setName(name);
	}
	//Class constructor with multiple Parameter
	public Person(String name,String address, String phoneNumber, String emailAddress)
	{
		this.name=name;
		this.address=address;
		this.phoneNumber=phoneNumber;
		setEmailAddress(emailAddress);
	
	}
	
	//setters and getters 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	//Regex pattern checker, if invalid email is set in main then set it to "default@email.com".
	public void setEmailAddress(String emailAddress) {
		String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
		Pattern paternRegex = Pattern.compile(emailPattern);
		if(paternRegex.matcher(emailAddress).matches())
		{
			this.emailAddress = emailAddress;
		}
		else{
			this.emailAddress="default@email.com";
		}
	}
	//@override toString
	public  String toString()
	{
		return getClass().getSimpleName()+ " Name: "+ name+ "\nAddress: "+address+"\nPhone Number: "+phoneNumber+"\nEmail: "+emailAddress;
	}
	
	
	
	
	
	
	
	
	
	
}
