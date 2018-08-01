package kaderTask1;

import java.text.ParseException;

public class Faculty extends Employee {

	//instance variables
	private String officeHours;
	public String rank;
	
	
	
	
	
	public Faculty(String name, String officeHours, String rank,String office, double salary) throws ParseException
	{	//calls superclass constructor to set name, office and salary
		super(name,office,salary);
		this.officeHours=officeHours;
		this.rank=rank;
		
		
	}
	//@override toString calls superclass toString and adds additional info
	public String toString()
	{
		
		return super.toString()+"\nOffice Hours: "+officeHours+"\nRank: "+rank;
		
	}
}
