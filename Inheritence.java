/*I declare that all material in this assessment task is my own work except where there is a clear acknowledgement 
 * or reference to the work of others.I further declare that I have complied with, and agree to 
 * abide by the UIS Academic Integrity Policy at the University website. https://www.uis.edu/academicintegrity
 * Author's Name: Borhan Kader UIN: 672595290
 */




package kaderTask1;

import java.text.ParseException;

public class kaderTask1 {

	
	public static void m(Object x){
		System.out.println(x.toString());
	}
	
	
	public static void main(String [] args) throws ParseException
	{
		Object object=new Object();
		
		//Name,Address,Phone Number,Email. if(email does not have '@' then a default emailAddress will be set).
		object=new Person("Mohammad Salah", "674 Walnutwood Lane Minneapolis, MN 55406","210-511-8745","bkade2@uis.edu");
		m(object);
		System.out.println("------------------------------------------------------------------------------");
		
		//Name,Status
		object=new Student("Cristiana Ronaldo","Senior");
		m(object);
		System.out.println("------------------------------------------------------------------------------");
		
		//Name,Office,Salary,DateHired
		object=new Employee("Lionel Messi","New York",90000.00);
		m(object);
		
		System.out.println("------------------------------------------------------------------------------");
		//Name,Office Hours,Rank,Office,Salary
				object=new Faculty("Sergio Ramos","8:00 AM-5:00 PM","Manager","Boston",70000.00);
				m(object);
				
		System.out.println("------------------------------------------------------------------------------");
		//Name,Office,Title,Salary
				object=new Staff("Mile Jedinak","Boston","Administrative Manager",35000.00);
				m(object);

				
	}
	
}
