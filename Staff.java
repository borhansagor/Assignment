package kaderTask1;

import java.text.ParseException;

public class Staff extends Employee {
	//instance variable 
	private String title;
	
	public Staff(String name,String office,String title,double salary) throws ParseException
	{
		super(name,office,salary);
		this.title=title;
		
		
	
	}
	//@override toString calls superclass toString and adds additional info
	public String toString()
	{
		
		return super.toString()+"\nTitle: "+title;
		
	}
	
}	


