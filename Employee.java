package kaderTask1;

import java.text.NumberFormat;
import java.text.ParseException;

public class Employee extends Person {
	//instance variables
	private String office;
	private double salary;
	private String date;
	//creating MyDate Object and setting HireDate
	//intently initializing hired date later than today with invalid month 13 and invalid date 32, to see the getTime() method work and fix it to current date; (year,month,day) input 
	private MyDate dateHired= new MyDate(2019,13,32);
	
	
	
	
	//formatter to format salary
	public NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	
	protected void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	
	public Employee(String name, String office,double salary) throws ParseException
	{	
		setName(name);
		this.office=office;
		this.salary=salary;
		this.date=dateHired.getTime();
	}
	

	public String getOffice() {
		return office;
	}
	protected void setOffice(String office) {
		this.office = office;
	}
	//@override toString
	public String toString()
	{
		return getClass().getSimpleName()+ " Name: " + getName()+"\nOffice: "+office+"\nDate Hired: "+date+"\nSalary: "+formatter.format(salary); 
	}

	
	
}

